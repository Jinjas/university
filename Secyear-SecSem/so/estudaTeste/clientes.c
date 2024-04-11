#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(int argc, char** argv){

    int fd,bRead;
    if((fd = open("fifo",O_WRONLY)) == -1){
        perror("openfifo");
        return -1;
    }
    char *buf = malloc(sizeof(char)*255);
    while ((bRead = read(0,buf,sizeof(buf))) >0){
        write(fd,buf,bRead);
    }
    close(fd);
}