#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(int argc, char** argv){

    pid_t pid; 
    if(pid = fork()== 0){
        char * aux = malloc(sizeof(char) *254);
        sprintf(aux, "processo pai do filho: %d",getppid());
        write(1, aux, strlen(aux));
        sprintf(aux, "processo filho do filho: %d",getpid());
        write(1, aux, strlen(aux));
        exit(5);
    }
    else{
        char * aux = malloc(sizeof(char) *254);
        sprintf(aux, "processo pai do pai: %d",getppid());
        write(1, aux, strlen(aux));
        sprintf(aux, "processo filho do pai: %d",getpid());
        write(1, aux, strlen(aux));
    }
    return 0;
}