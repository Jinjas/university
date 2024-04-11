#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>


int mensagens(char *palavra, char*ficheiro){

    int resultado = 0;
    int pipe_fd2[2];
    int pipe_fd[2];
    if(pipe(pipe_fd)<0)
        return -1;
    if(pipe(pipe_fd2)<0)
        return -1;
    
    
    if(fork() == 0){
        close(pipe_fd[0]);
        close(pipe_fd2[1]);
        close(pipe_fd2[0]);
        dup2(pipe_fd[1],1);
        close(pipe_fd[1]);
        execlp("grep","grep",palavra,ficheiro,NULL);
    }
    else
    if(fork() == 0){
        close(pipe_fd[1]);
        close(pipe_fd2[0]);
        dup2(pipe_fd[0],0);
        close(pipe_fd[0]);
        dup2(pipe_fd2[1],1);
        close(pipe_fd2[1]);
        execlp("wc","wc","-l",NULL);
    }
    else{
        close (pipe_fd[0]);
        close (pipe_fd[1]);
        close (pipe_fd2[1]);

        read(pipe_fd2[0],&resultado,sizeof(int));
        close(pipe_fd2[0]);
        return resultado;
    }    


}