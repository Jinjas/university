#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>


int main(){
    int input_file_fd = open("/etc/passwd",O_RDONLY);
    int output_file_fd = open("saida.txt",O_CREAT|O_WRONLY,0666);
    int error_file_fd = open("erros.txt",O_CREAT|O_WRONLY,0666);
    int save = dup(STDOUT_FILENO);//é o unico que vou precisar de usar outra vez

    dup2(input_file_fd, STDIN_FILENO);
    close(input_file_fd);

    dup2(output_file_fd, STDOUT_FILENO);
    close(output_file_fd);

    dup2(error_file_fd, STDERR_FILENO);
    close(error_file_fd);
    
    char *buf = malloc(sizeof(char)*255);
    int bRead;
    while((bRead = read(0,buf,255))>0){
        write(1,buf,bRead);
        write(2,buf,bRead);
    }
    dup2(save,STDOUT_FILENO);
    close (save);

    write(1,"terminei\n",strlen("terminei\n"));


    return 0;
}