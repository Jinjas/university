#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(int argc, char **argv){

    int fd,bRead;
    char *buf = malloc(sizeof(char)*255);
    if((fd = open("fifo",O_WRONLY)) == -1){
        perror("open\n");
        return -1;
    }else{
        printf("opened\n");
    }
    while ((bRead = read(0,buf,sizeof(char)*255))>0){
        write(fd,buf,bRead);
    }
}
