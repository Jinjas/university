#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>
bool num[33554433] = {0};

/*
void triangulares (int x, int y) {
    printf ("%d ",(int)(((sqrt(1+ 8 * x)-1) / 2)-((sqrt(1+ 8 * y)-1) / 2)+1));
}
*/
void triangulares (int x, int y) {
    int triangles = 0, valor = 0;

    for (int i = 1 ; triangles < y; i++) {
        triangles = ((i * (i+1)) / 2);
        if (triangles >= x && triangles <= y)
            valor++;
    }
    printf ("%d ",valor);
}

void primos(int x, int y){
    unsigned int valor = 0;
    num[0] = num [1] = 1;
    //110000000000000000000000000000000000
    int i = 2;
    for (; i * i < y; i++)
        if (num[i] == 0)
            //remover tds os multiplos de i
            for (int j = 2; i * j <= y; j++)
                num[i * j] = 1;
    for (int i = x; i <= y; i++)
        if (num[i] == 0)
            valor++;
    printf("%d\n", valor);
}

int main()
{
    int x, y;
    clock_t start, end;
    double tempo;

    if (scanf("%d %d", &x, &y) != 2)
        return 1;
    start = clock();
    //printf("%d ", (int)((((sqrt(1 + 8 * y)) / 2) - ((sqrt(1 + 8 * x)) / 2)) + 1));
    triangulares(x,y);
    primos(x, y);
    end = clock();
    tempo = (double)(end - start) / CLOCKS_PER_SEC;
    printf("\t time: %f\n", tempo);
    return 0;
}