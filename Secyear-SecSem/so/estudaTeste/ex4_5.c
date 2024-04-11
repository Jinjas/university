#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(int argc, char **argv){

int pipe_fd [2];
if(pipe(pipe_fd)< 0){
    perror("pipe");
    return 1;
}
if(fork() == 0){
    close(pipe_fd[0]);
    for(int i = 1; i < 100000; i++){
        write(pipe_fd[1],&i,sizeof(int));
    }
    exit(5);
}
else{
    close(pipe_fd[1]);
    int i;
    while (read(pipe_fd[0],&i,sizeof(int))!= 0){
        char *aux = malloc(sizeof(char)*10);
        sprintf(aux,"%d\n",i);
        write(1,aux,strlen(aux));
    }
}
return 0;
}