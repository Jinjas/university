#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char **argv){
    //int þ;
    //int æ;
    printf("started\n");
    for (int i=1; i<argc; i++){

        if (fork() == 0){
        execlp(argv[i],argv[i],NULL);
        printf("exec arg:%d\n",i+1);
        exit(5);
        }
    }
    int status;
    for(int i=1; i<argc; i++)
        wait(&status);
    printf("ended\n");
    int terminated_pid = wait(&status);
    printf("exit status:%d\n", status);
    return 0;
}

