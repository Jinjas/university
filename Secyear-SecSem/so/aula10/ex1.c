#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main(){

    int input_file_fd = open("/etc/passwd", O_RDONLY,0666);
    int output_file_fd = open("saida.txt", O_CREAT | O_TRUNC | O_RDONLY,0666);
    int error_file_fd = open("erros.txt", O_CREAT | O_TRUNC | O_RDONLY,0666);
    int save = dup(STDOUT_FILENO);

    dup2(input_file_fd,STDIN_FILENO);
    close(input_file_fd);

    dup2(output_file_fd,STDOUT_FILENO);
    close(output_file_fd);

    dup2(error_file_fd,STDERR_FILENO);
    close(error_file_fd);

    char buf[10];
    int read_bytes = 0;
    while((read_bytes = read(STDIN_FILENO,buf,10))>0){
        write(1,buf,read_bytes);
        write(2,buf,read_bytes);
    }
    
    dup2(save,STDOUT_FILENO); 
    close(save);

    write (1,"terminei\n",sizeof("terminei\n"));
    return 0;
}