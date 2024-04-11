#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#define size 1024
int mycat(){

    
    ssize_t bytes_read;
    ssize_t bytes;
    ssize_t bytes_written;
    char * buffer = (char *)malloc(sizeof(char) * size);
    
    while ((bytes = read (0, buffer,size)) > 0){
        bytes_read += bytes;
        bytes_written = write (1, buffer,bytes);
    }
    return 0;
}

int main(int argc, char **argv) {
    //ctrl + d 
     return mycat();
}