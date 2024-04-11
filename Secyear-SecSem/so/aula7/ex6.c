#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>


int main(int argc, char *argv[]) {
    //create pipe
    struct searchResult{
        int line;
        int ocorr;
    };
    int column = 5; 
    int lines = 4;
    int matrix[4][5] ={{1,2,3,20,5},{1,2,3,20,5},{1,2,3,4,5},{1,20,3,4,5}};
    int pedido = 20;
    int pipe_fd[2];
    if (pipe(pipe_fd) < 0) {
        perror("pipe");
        return 1;
    }

    int final = 0;
    
    int pid;
    for (int i = 0; i < lines; i++) {
        if ((pid = fork()) == 0){
            close(pipe_fd[0]);
            struct searchResult resultadoLine;
            int ocorr = 0;
            for (int j = 0; j < column; j++) 
                if(matrix[i][j] == pedido)
                    ocorr ++;
            
            resultadoLine.line = i;
            resultadoLine.ocorr = ocorr;
            write(pipe_fd[1], &resultadoLine, sizeof(struct searchResult)); //transmitir os varios resultados
            _exit(ocorr);
        }
    }

    close(pipe_fd[1]);
    struct searchResult result;
    result.ocorr = 0;

    for(int i = 0; i < lines; i++){//percorre os varios resultados
        int read_retrun = read(pipe_fd[0], &result, sizeof(struct searchResult));
        printf("linha->ocorrencias: %d -> %d\n", result.line, result.ocorr);
        final += result.ocorr;
    }
    
    printf("resultado final: -> %d\n", final);
    
    return 0;
}