#include <stdio.h>


void swapM (int *x, int *y) {
    int z = *x;
    *x = *y;
    *y = z;
}

void swap (int v[], int i, int j) {

    int z = v[i];
    v[i] = v[j];
    v[j] = z;
}

int soma (int v[], int N) {

    int valor = 0;
    for (int i = 0; i < N; i++)
        valor += v[i];
    return valor;
}

void inverteArray (int v[], int N) {

    for (int i = 0,f = N-1; i < N/2; i++,f--) {
        int z = v[i];
        v[i] = v[f];
        v[f] = z;
    }
}

int maximum (int v[], int N, int *m) {
    if (N > 0) {
    *m = v[0];
    for (int i = 0; i < N; i++)
        if (*m < v[i])
            *m = v[i];
    int a = *m;
    printf ("%d ",a);
    return 0;    
    }
    else return 1;
}

void quadrados (int q[], int N) {

    for (int i = 0; i < N; i++) {
    q[i] = i*i; 
    printf ("%d ", q[i]);   
    }
}

void pascal (int v[], int N) {

   int coef = 1;
   for (int i = 0; i < N; i++) {
      for (int space = 1; space <= N - i; space++)
         printf("   ");
      for (int j = 0; j <= i; j++) {
         if (j == 0 || i == 0)
            coef = 1;
         else
            coef = coef * (i - j + 1) / j;
         printf("%6d", coef);
      }
      printf("\n");
   }

}

int main() {
    int v[5] = {1123333333,23231,12133,4122112,532323};
    int q[21];
    int x = 3, y = 5, m = 0;
    swapM (&x, &y);
    printf ("%d %d\n", x, y);

    printf ("%d\n",soma (v, 5));

    inverteArray (v, 5);
    printf ("%d\n",v[2]);
    
    printf ("%d\n", maximum (v,5,&m));
    quadrados (q,21);
    putchar('\n');
    pascal (q,20);
    return 0;
}
