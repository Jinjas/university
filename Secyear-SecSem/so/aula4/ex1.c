#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

/*
code
heap
||
\/

/\
||
stack


 --------
|  code  |
|  heap  |
|   ||   |
|   \/   | <----  (pai)
|        |
|   /\   |
|   ||   |
|  stack |
 --------

    ||
    ||  <-- fork()
    \/

  
 --------
|  code  |
|  heap  |
|   ||   |
|   \/   | <---  (filho)
|        |
|   /\   |
|   ||   |
|  stack |
 --------

fork(void) :: return values

if(funfou)
    ao processo-pai retorna o processo(PID) do processo-filho
    retorna 0 ao processo-filho
else(erro)  
    return -1


*/
/*
int main(){
    pid_t pid;
    if((pid = fork()) == 0){
        //codigo do processo-filho
    }
    else {
        //codigo do processo-pai
    }
}


o processo filho terina depois da função: _exit
o pai pode aguardar pelos filhos através de wait ou waitpid(diz em particular qual dos pids espera)


int main(){
    pid_t pid;
    if((pid = fork()) == 0){
        //codigo do processo-filho
        _exit(0)
    } else {
        //codigo do processo-pai
        pid_t child = wait(&status);
        printf("filho saiu %d \ erro: %d\n", child, WEXITSTATUS(status));
    }
}


*/
int main(){
    printf("pid: %d\n",getpid());
    printf("ppid: %d\n",getppid());

}
