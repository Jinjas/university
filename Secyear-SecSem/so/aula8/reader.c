#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

int main(int argc, char **argv){
    
    int fd,bytes_read;
    char buf[21];
    if((fd = open("fifo",O_RDONLY)) == -1){
        perror("open");
        return -1;
    }else{
        printf("opened");
    }
    
    while ((bytes_read = read (fd,buf,sizeof(char)*20)) > 0){
        write (1 ,buf,bytes_read);
    }

    
}