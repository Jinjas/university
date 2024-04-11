#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>


int mycat(){
    char * buf = malloc(255*sizeof(char));
    ssize_t len;

    while (len = read(0, buf, 255) > 0){
        write(1,buf,len);
    }
    free(buf);
    return 0;


}


int main(int argc, char** argv){
    
    if (argc > 2)
        return 1;
    return mycat();
    
}