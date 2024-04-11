#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>

#include <sys/wait.h>


int main(char *palavra,int n, char* autores[n]){
    int result = 0;

    for(int i=0;i<n;i++){
        if(fork() == 0){
            exit(mensagens(palavra,autores[i]) > 0);
        }
    }
    int status;
    for(int i=0;i<n;i++){
        wait(&status);
        if(WIFEXITED(status))
            result += WEXITSTATUS(status);
    }

    return result;
}