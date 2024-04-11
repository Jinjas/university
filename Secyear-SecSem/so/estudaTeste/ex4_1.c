#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(int argc, char **argv){
    int pipe_fd[2];
    if (pipe(pipe_fd) < 0) {
        perror("pipe");
        return 1;
    }
    int pid;
    if((pid = fork()) == 0){
        close(pipe_fd[1]);
        int i;
        read(pipe_fd[0], &i, sizeof(int));
        exit(i);
    }
    else{
        close(pipe_fd[0]);
        int i = 10;
        write(pipe_fd[1], &i, sizeof(int));
    }
    int status;
    if(wait(&status) > 0 && WIFEXITED(status)){
        printf("exit staus: %d\n",WEXITSTATUS(status));
    }
    return 0;
}