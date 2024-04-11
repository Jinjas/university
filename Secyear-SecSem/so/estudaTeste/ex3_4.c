#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>

char** tracer_parser (char *message, int *tollerance){
    char **arguments = (char **) malloc(sizeof(char *) * tollerance[0]);
    char *token;
    token = strtok(message, " ");
    int i = 0;
    for (;(token != NULL); i++) {
        if(i >= tollerance[0] - 10){
            char **aux = realloc(arguments, sizeof(arguments) * tollerance[0] << 1);
            if(aux != NULL){
               tollerance[0] = tollerance[0] << 1;
               arguments = aux;
            }
        }
        arguments[i] = strdup(token);
        token = strtok(NULL, " ");
    }
    arguments[i] = NULL;
    return arguments;
}

int main(int argc, char** argv){
    pid_t pid;
    int status;
    int buffer_size =100;
    char **arguments = tracer_parser(argv[1], &buffer_size);


    if(pid = fork() == 0){
            execvp(arguments[0],arguments);
    }
    for (int i = 1; i < argc; i++){
        wait(&status);
    }

    write(1,"hi",3);

    return 0; 
}