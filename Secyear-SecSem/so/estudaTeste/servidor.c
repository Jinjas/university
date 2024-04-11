#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>

int main(){

    int log,fd, bRead;
    char *buf = malloc(sizeof(char)*255);
    if (mkfifo("fifo",0666) == 0){
        perror("mkfifo");
        return -1;
    }
    if ((log = open("log.txt",O_CREAT|O_RDWR, 0600)) == -1){
        perror("openlog");
        return -1;
    }
    if((fd = open("fifo", O_RDONLY)) == -1){
        perror("openfifo");
        return -1;
    }
    while (1){
        while ((bRead = read(fd,buf,sizeof(buf))) > 0){
            write (log, buf, bRead);
        }
    }
    close(fd);
}