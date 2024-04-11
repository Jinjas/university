#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>


int main(){
    
    pid_t pid;
    int status;
    if ((pid =fork()) == 0){
        //child
        
        printf("child \t pid: %d\n",getpid());
        printf("child \t ppid: %d\n",getppid());
        _exit(5);
    }
    else{
        //child
        
        printf("PAI \t pid: %d\n",getpid());
        printf("PAI \t ppid: %d\n",getppid());
    }
    if (wait(&status) > 0){
        if (WIFEXITED(status))
            printf("PAI \t child exit status: %d\n", WEXITSTATUS(status));
        
        else 
            printf("PAI \t child error exiting\n");
    }
    printf("PAI \n exiting.....\n");
    return 0;
}