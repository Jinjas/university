#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>

int mycp(char* input, char*output, int tamanho){
    
    int fdin = open(input, O_RDONLY);
    int fdout = open(output, O_WRONLY | O_CREAT); 

    char *buf = malloc(tamanho * sizeof(char));
    ssize_t bytesRead;
    while(bytesRead = read(fdin,buf,tamanho) > 0){
        write(fdout,buf,bytesRead);
    }
    close(fdout);
    close(fdin);
    free(buf);
    return 0;
}


int main(int argc, char** argv){
    
    if (argc < 3 || argc > 4){
        write(1,"Usage: ./mycp <inputfile> <outputfile> <tamanho>", strlen("Usage: ./mycp <inputfile> <outputfile> <tamanho>"));
        return 1;
    }
    return mycp(argv[1], argv[2], atoi(argv[3]));
    
}