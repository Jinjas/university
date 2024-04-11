#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
int mycp(char *input, char *output,int size){
    
    int fileIID = open (input,O_RDONLY);
    if(fileIID < 0){
        perror("erro a abrir ficheiro de entrada");
        return -1;
    }
    
    int fileOID = open (input,O_WRONLY | O_CREAT, 0640);
    if(fileOID < 0){
        perror("erro a abrir ficheiro de saida");
        return -1;
    }
    
    ssize_t bytes_read;
    ssize_t bytes_written;
    char *buf =malloc(size*sizeof(char));
    int nsyscalls = 0;
    
    while (bytes_read = read (fileIID, buf,size) > 0){
        bytes_written = write (fileOID, buf,bytes_read);
        nsyscalls += 2;
    }
    close (fileIID);
    close (fileOID);
    printf("%d nsyscalls\n",nsyscalls);
    return 0;
}

int main(int argc, char **argv) {
    
    printf("argc: %d\n", argc);
    for (int i = 1; i < argc; i++)
        printf("argv[%d] = %s\n",i, argv[i]);

    if (argc < 4){
        printf("usage: ./mycp <input file> <output file> <tamanho>\n");
        return -1;
    }
     return mycp(argv[1],argv[2],atoi(argv[3]));
}