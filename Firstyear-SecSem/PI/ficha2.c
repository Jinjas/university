#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>



void multInt1 (int n, float m) {
    int r = 0;
    int a = 0;
    for (int i = 0 ; i < n ; i++){
        r += m;
        a++;
        }
    printf ("%d\n",r);
    printf ("operacoes %d\n",a);
}

void multInt2 (int n, float m) {
    int r = m;
    int a = 0;
    while (n != 1) {
        n /= 2;
        m *= 2;
        if (n % 2 != 0) {
            r += m;
            a++;
        }   
    }
    printf ("%d\n", r);
    printf ("operacoes %d\n", a);
}

int mdc1 (int a, int b) {
    int x = a;
    int y = 1;
    if (a>b)
        x=b;

    for (; x>=1; x--, y++) 
        if (a % x == 0 && b % x == 0) {
            printf ("\noperacoes %d\n",y);
            return x;
            }
}

int mdc2 (int a, int b){
    int x;
    int y = 0;
    while (a != 0 && b != 0)
        if (a > b) {
            a -= b;
            x = b;
            y++;
            }
        else {
            b -= a;
            x = a;
            y++;
            }
    printf ("operacoes %d\n",y);
    return x;

}

int mdc3 (int a, int b){
    int x;
    int y = 0;
    while (a != 0 && b != 0)
        if (a > b) {
            a %= b;
            x = b;
            y++;
            }
        else {
            b %= a;
            x = a;
            y++;
            }
    printf ("operacoes %d\n",y);
    return x;

}


int main () {
    /*multInt1 (81,423);
    multInt2 (81,423);
    printf ("\tmdc: %d \n",mdc1 (126,45));
    printf ("\tmdc: %d \n",mdc2 (126,45));
    printf ("\tmdc: %d \n",mdc3 (126,45));
    */
    char extra[10000];
    char thing[10000];
    scanf("%s\n",&thing);
    strcpy(extra,thing);
    printf ("thing:%s\n", thing);
    printf ("extra:%s\n", extra);
    for (int i = 1; i < 3; i++){
        strcat (thing, extra);
        printf ("repeticao %d : %s\n", i,thing);
    }
return 0;
}

