#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>

int main(){
    //int þ;
    //int æ;
    printf("started\n");
    int status;
    if (fork() == 0){
    execl("/bin/ls","ls","-l",NULL);
    printf("exec ls\n");
    exit(5);
    }
    printf("ended\n");
    int terminated_pid = wait(&status);
    printf("exit status:%d\n", WEXITSTATUS(status));
    return 0;
}

