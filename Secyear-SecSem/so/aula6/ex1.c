#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>



int main(){
    int þ;
    int æ;
    sleep(10);
    
    execl("/bin/ls","ls","-l",NULL);
    
    printf("exec ls\n");
    return 0;
}

