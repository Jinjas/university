#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(int argc, char** argv){
    char * aux = malloc(sizeof(char) *254);
    
    sprintf(aux, "processo pai: %d",getppid());
    write(1, aux, strlen(aux));
    sprintf(aux, "processo filho: %d",getpid());
    write(1, aux, strlen(aux));
    return 0;
}