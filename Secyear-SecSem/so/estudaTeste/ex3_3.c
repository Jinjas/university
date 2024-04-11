#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(int argc, char** argv){
    pid_t pid;
    int status;

    for(int i = 1; i < argc; i++){
        if(pid = fork() == 0){
            execlp(argv[i],argv[i],NULL);
        }
    }
    for (int i = 1; i < argc; i++){
        wait(&status);
    }

    write(1,"hi",3);

    return 0; 
}