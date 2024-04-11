#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

int main(int argc, char **argv){
    //int þ;
    //int æ;
        int status;
        char **buf = (char**)calloc(argc, sizeof(char*));
        for (int i=1; i<argc; i++){
            buf[i-1] = strdup(argv[i]);
        }

        if (fork() == 0){
            execvp(buf[0],buf);
            _exit(5);
        }

        if (wait(&status) > 0){
        if (WIFEXITED(status))
            printf("exit status: %d\n", WEXITSTATUS(status));
        
        else 
            printf("error exiting\n");
    }
        free(buf);
    return 0;

}

