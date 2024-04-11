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
    
    return 0;
}
