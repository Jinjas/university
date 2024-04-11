#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/wait.h>


int main(){

    //criar o pipe
    // criar processo filho
    //pai: fechar pipe[0];lê do stdin e escreve no pipe [1]

    //filho: fecar pipe[1]; redireciona STDIN->pipe[0];exec wc

    int pipe_fd[2];

    if(pipe(pipe_fd)<0){
        perror("errouuu");
    }

    if(fork() ==0){
        close (pipe_fd[1]);
        dup2(pipe_fd[0],STDIN_FILENO);
        close (pipe_fd[0]);

        execlp("wc","wc",NULL);
    
    } else{
        close(pipe_fd[0]);

        char buf[10];
        int read_bytes = 0;
        while((read_bytes = read(STDIN_FILENO,buf,10))>0){
            write(pipe_fd[1],buf,read_bytes);
        }

        close(pipe_fd[1]);
        wait(NULL);
    }
    return 0;
}