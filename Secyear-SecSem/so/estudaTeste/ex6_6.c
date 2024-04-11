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
    int pipe_fd2[2];
    if(pipe(pipe_fd2) < 0)
        return -1;
    int pipe_fd3[2];
    if(pipe(pipe_fd3) < 0)
        return -1;

    if(fork() == 0){
        close(pipe_fd[0]);
        close(pipe_fd3[1]);
        close(pipe_fd3[0]);
        close(pipe_fd2[1]);
        close(pipe_fd2[0]);
        dup2(pipe_fd[1],STDOUT_FILENO);
        close(pipe_fd[1]);
        execlp("grep", "grep","-v",NULL);
    }
    else
    if(fork() ==0){
        close(pipe_fd[1]);
        close(pipe_fd3[1]);
        close(pipe_fd3[0]);
        close(pipe_fd2[0]);
        dup2(pipe_fd2[1],STDOUT_FILENO);
        close(pipe_fd2[1]);
        dup2(pipe_fd[0],STDIN_FILENO);
        close(pipe_fd[0]);

        execlp("cut", "cut","-f7","-d:",NULL);
        
    }
    else
    if(fork() == 0){
        close(pipe_fd[0]);
        close(pipe_fd[1]);
        close(pipe_fd3[0]);
        close(pipe_fd2[1]);
        dup2(pipe_fd3[1],STDOUT_FILENO);
        close(pipe_fd3[1]);
        dup2(pipe_fd2[0],STDIN_FILENO);
        close(pipe_fd2[0]);
        execlp("uniq", "uniq",NULL);
    }
    else
    if(fork() ==0){
        close(pipe_fd2[1]);
        close(pipe_fd2[0]);
        close(pipe_fd2[1]);
        close(pipe_fd2[0]);
        close(pipe_fd3[1]);
        dup2(pipe_fd3[0],STDIN_FILENO);
        close(pipe_fd3[0]);

        execlp("wc", "wc","-l",NULL);
        
    }
    int status;
    wait(&status);
    return 0;
}