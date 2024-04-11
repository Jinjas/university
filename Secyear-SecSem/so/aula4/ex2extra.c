#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>


int main(){
    
    pid_t pid;
    int status, i = 10;
    char ola[4] = "ola";
    if ((pid =fork()) == 0){
        //child
        i = i+5;
        ola[2]='b';
        printf("child \t i: %d\n", i);
        printf("child \t pid: %d\n",getpid());
        printf("child \t ppid: %d\n",getppid());
        printf("%c\n",ola[2]);
        
        _exit(5);
    }
    else{
        //child
        i=i-5;
        printf("PAI \t i: %d\n", i);
        printf("PAI \t pid: %d\n",getpid());
        printf("PAI \t ppid: %d\n",getppid());
    }
        printf("%c\n",ola[2]);
    if (wait(&status) > 0){
        if (WIFEXITED(status))
            printf("PAI \t child exit status: %d\n", WEXITSTATUS(status));
        else 
            printf("PAI \t child error exiting\n");
    }
    printf("PAI \n exiting.....\n");
    return 0;
}