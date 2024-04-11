#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>


//Escreva um programa “servidor”, que fique a correr em background, e acrescente a um ficheiro de “log”
// todas as mensagens que sejam enviadas por “clientes”. Escreva um programa cliente que envia para o
// servidor o seu argumento. Cliente e servidor devem comunicar via pipes com nome

int main(int argc, char **argv){
    
    if (mkfifo("fifo",0666)==0)
        perror("mkfifo"); 

    int log;
    int fd2;
    int fd,bytes_read;
    char buf[256];
        if((fd = open("fifo",O_RDONLY)) == -1){
            perror("open");
            return -1;
        }else{
            printf("opened");
        }
        
        if((fd2 = open("fifo",O_WRONLY)) == -1){
            perror("open");
            return -1;
        }else{
            printf("opened");
        }

        if((log = open("log.txt",O_CREAT|O_WRONLY,0640)) == -1){
            perror("open");
            return -1;
        }else{
            printf("opened");
        }

        while ((bytes_read = read (fd, buf,sizeof(char)*255)) > 0)
            write (log, buf,bytes_read);
        close (fd);
}
//se quiserem responder ao cliente cada cliente precisa tambem de um fifo e 
//mandar a informação necessaria para o servidor aceder a esse fifo.