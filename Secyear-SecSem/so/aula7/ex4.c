#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>


int main(int argc, char *argv[]) {
    //create pipe
    int pipe_fd[2];

    if (pipe(pipe_fd) < 0) {
        perror("pipe");
        return 1;
    }

    int pid;
    if ((pid = fork()) == 0){
        close(pipe_fd[0]);
        int i= 10;
        for(int n=0; n<100000; n++){
            write(pipe_fd[1], &i, sizeof(int));
            printf(" write %d\n", n);
        }
        _exit(0);
    }
    
    close(pipe_fd[1]);
    int i;
    sleep(10);
    read(pipe_fd[0], &i, sizeof(int));
    printf("read returned\n");
    printf("%d\n", i);

    int status;
    if(wait(&status) > 0 && WIFEXITED(status)){
        printf("exit staus: %d\n",WEXITSTATUS(status));
    }
    
    return 0;
}