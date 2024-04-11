#include <stdio.h>
int isfact (int a , int b ,int c) {
int valor = 1;
int acomulacao = 1;
while (a >= valor) {
    if (a == valor) {
        printf ("FATORIAL\n");
        return 0;
        }
    acomulacao++;
    valor *= acomulacao;
}
if (b < c)
    printf ("%d %d %d\n", b,c,a);
else 
    printf ("%d %d %d\n",c,b,a);
return 0;
}



int main() {
    int x , y, z;
    if (scanf("%d %d %d", &x, &y, &z) == 3) {
        if (x >= y && x >= z)
            isfact (x,y,z);
        else 
            if (y >= z && y >= x)
                isfact (y,x,z);
            else
                isfact (z,x,y);
    }

    return 0;
}
