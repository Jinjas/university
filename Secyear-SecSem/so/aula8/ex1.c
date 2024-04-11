#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(int argc, char **argv){
    
    if (mkfifo("fifo",0666)==0)
        perror("mkfifo"); 
    
    return 0;
}