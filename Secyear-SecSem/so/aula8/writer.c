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
    if((fd = open("fifo",O_WRONLY)) == -1){
        perror("open");
        return -1;
    }else{
        printf("opened");
    }

    while ((bytes_read = read (0, buf,sizeof(char)*20)) > 0){
        write (fd,buf,bytes_read);
    }

}

    //cat fifo
    //cat > fifo
