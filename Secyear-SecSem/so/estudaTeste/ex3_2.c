#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>

int main(int argc, char** argv){
pid_t pid;
int status;
if(pid = fork == 0){
    execlp("ls","ls","-l",NULL);
    exit(5);
}

if(wait(&status) >0)
    if(WIFEXITED(status))
        printf("PAI \t child exit status: %d\n", WEXITSTATUS(status));

return 0;
}