#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main(int argc, char **argv){
    printf("arg 1:  %s\n\n", argv[0]);
    FILE *f = fopen(argv[1],"rt");
    char texto[100];

    if(!f) f = stdin;
    while(!feof(f)){
        fgets(texto, 100, f);
        printf("linha: %s", texto);
    }
    
    fclose(f);
    return 0;
}