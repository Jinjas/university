#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(int argc, char **argv){
    int bRead,fd;
    char *buf = malloc(255*sizeof(char));
    if((fd = open("fifo",O_RDONLY)) == -1){
        perror("fifo dont exist");
        return 1;
    }else{
        printf("opened");
    }
    while((bRead = read(fd,buf,sizeof(char)*255))>0){
        write(1,buf,bRead);
    }
    return 0;
}