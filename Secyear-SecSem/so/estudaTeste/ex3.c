#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>


int main (int argc, char** argv){

    ssize_t read_len;
    char *start = malloc (255*sizeof(char));
    char* buf = malloc (255*sizeof(char));
    int i = 1;
    while (read_len = read(0,buf,255)>0){
        if (read_len != 1){
            start = strcpy (start,"\t");
            sprintf(start," %d ",i);
            write (1,start,strlen(start));
            write (1,buf,read_len);
            write (1,"\n",strlen("\n"));
            i++;
        }
    }
    
    return 0;
}