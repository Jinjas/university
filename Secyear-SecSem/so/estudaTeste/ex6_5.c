#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>
#include <sys/wait.h>


int main(){

    int pipe_fd[2];
    if(pipe(pipe_fd) < 0)
        return -1;

    if(fork() == 0){
        close(pipe_fd[0]);
        dup2(pipe_fd[1],STDOUT_FILENO);
        close(pipe_fd[1]);
        execlp("ls", "ls","/etc",NULL);
    }
    else
    if(fork() ==0){
        close(pipe_fd[1]);
        dup2(pipe_fd[0],STDIN_FILENO);
        close(pipe_fd[0]);

        execlp("wc", "wc","-l",NULL);
        
    }
    int status;
    wait(&status);
    return 0;
}