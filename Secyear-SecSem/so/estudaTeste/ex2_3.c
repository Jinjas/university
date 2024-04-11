#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(int argc, char** argv){

    pid_t pid; 
    int status;
    for ( int i = 1; i <= 10; i++){
        if(pid = fork()== 0){
            char * aux = malloc(sizeof(char) *254);
            sprintf(aux, "processo pai do filho: %d\n",getppid());
            write(1, aux, strlen(aux));
            sprintf(aux, "processo filho do filho: %d\n",getpid());
            write(1, aux, strlen(aux));
            exit(i);
        }
    }

    for (int i = 1; i <= 10; i++){
        if (wait(&status) > 0){
            if (WIFEXITED(status))
                printf("PAI \t child exit status: %d\n", WEXITSTATUS(status));
            else 
                printf("PAI \t child error exiting\n");
        }
    }
    return 0;
}