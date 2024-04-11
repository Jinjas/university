#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

int ex2(int r){
    for (int i=0; (i<r) ; i++)
        if (i%2 == 0) putchar ('_');
        else putchar ('#');
}

int exc3_1 (int x) {
    for (int i=0; i < x ; i++){
        for (int i=0; i < x ; i++)
            putchar('#');
        putchar('\n');
    }
    return 0;
}

int exc3_2 (int x){
    int n = 0;
    for (int i=0; i < x ; i++){
        for (int i=0; i < x ; i++)
            if ((i+n) % 2 == 0)
                putchar('#');
            else 
                putchar ('_');
        putchar('\n');
        n++;
        }
}

int exc3_3_dir (int nlinhas) {
    int tamanho = 0;
    bool arroz = true;
    for (int i=1; i < nlinhas * 2; i++) {
        if (tamanho == nlinhas) 
            arroz = false; 
        
        if (arroz){tamanho++;} 
        else tamanho--;

        for (int i=0; i < tamanho ; i++)
            putchar('#');
        putchar('\n');
    }
}

int exc3_3_cim (int a) {
    int x,y,i;
    for (y=0;y<a;y++) {
        for (i=a-y;i>=0;i--)
            printf(" ");
        for (x=y*2;x>=0;x--)
            printf("#");
        printf ("\n");
    }
}


int ex4 (int r) {
    int x = -r;
    int y = -r;
    int num = 0;
    for (int i=0; i <= 2*r ; i++,x++){
        for (int i=0; i <= 2*r ; i++,y++)
            if (sqrt((x * x +y*y)) <= r){
                printf("# ");
                num++;
                }
            else 
                printf("  ");
        putchar('\n');
        y = -r;
    }
    printf("be there are kinda this %d chars \n",num);
    return 0;
}
void extra (int n) {

}
int binaryTransform (int num) {
        int valor = num-1;
        printf ("número em binario %d --> ",num);
        while (valor>0) {
            if (valor%2 == 0) putchar ('0');
            else putchar ('1');
            valor = valor/2;
        }
    putchar ('\n');
    return 0;
}


int main() {
    printf ("exc1.1 -> 12,16 \n");
    printf ("exc1.2 -> 0,algo \n");
    printf ("exc1.3 -> A 65 ; B 66 2 50 ; b 98\n");
    printf ("exc1.4 -> 100,200 \n\n");
    printf ("exc2.1 -> 3 5\n");
    printf ("exc2.2 -> 11 66\n");
    printf ("exc2.3 ->");
 
    
    ex2(20);
    putchar('\n');
    exc3_1(9);
    putchar('\n');
    exc3_2(8);
    putchar('\n');
    exc3_3_dir(9);
    putchar('\n');
    exc3_3_cim(9);
    putchar('\n');
    ex4(10);
    putchar('\n');
    binaryTransform(16);
    return 0;
}
