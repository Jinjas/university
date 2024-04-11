#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>
#include <sys/wait.h>


int main(){
int pipe_fd[2];
if(pipe(pipe_fd) < 0){
    perror("pipe_fd");
    return-1;
}

if (fork() == 0){
    close(pipe_fd[1]);

    dup2(pipe_fd[0],STDIN_FILENO);
    close(pipe_fd[0]);

    execlp("wc","wc",NULL);
}
else{
    close(pipe_fd[0]);
    int bRead;
    char* buf = malloc(sizeof(char)*255);
    while((bRead = read(0,buf,255)) > 0)
        write(pipe_fd[1],buf,bRead);

}


}