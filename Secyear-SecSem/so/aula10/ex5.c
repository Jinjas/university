#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/wait.h>


int main(){

int p[2];

if(pipe(p) != 0){
    perror("pipe");
}
switch (fork()){
    case  -1:
        perror("fork");
        return -1;
    case 0:
        close(p[0]);

        dup2(p[1],1);
        close(p[1]);
        _exit(0);
    default:
        close(p[1]);
        break;
}

switch (fork()){
    case  -1:
        perror("fork");
        return -1;
    case 0:
        close(p[0]);
    
        dup2(p[0],0);
        close(p[0]);
        _exit(0);
    default:
        close(p[0]);
        break;
}

for (int w = 0; w<2;w++) {
    wait(w);
}


}
