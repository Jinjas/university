#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

void SinitStack (SStack s) {
    s -> sp = 0;
}

int SisEmpty (SStack s) {
    return (s->sp == 0);
}

int Spush (SStack s, int x) {
    if (s->sp == MAX) return 1;
    s->sp++; 
    return 0;
}

int Spop (SStack s, int *x) {
    if (s -> sp == 0) return 1;
    s -> sp--;
    *x = s-> values[s -> sp];
    return 0;
}

void DinitStack (DStack s) {
    s -> size = MAX;
    s -> sp =0;
    s -> values = malloc (MAX * sizeof(int));
    //if (s-> values == NULL) s->size = 0;
}

int Dpush (DStack s, int x) {
    if (s -> sp == MAX){
        int * aux = realloc (s-> values,2* s->size);
        if (aux == NULL) return 1;
        s -> size *= 2;
        s -> values = aux;
    }
    s->sp++; 
    return 0;
}
int Dpop (SStack s, int *x) {
    if (s -> sp == 0) return 1;
    s -> sp--;
    *x = s-> values[s -> sp];
    return 0;
}

int SinitQueue (SQueue q) {
    s -> length = 0;
    s -> front =0;
}

int Senqueue (SQueue q, int x) {
    if (s -> length == MAX) return 1;
    s -> values [(s-> front + s -> length) % MAX] = x;
    s -> length++;
    return 0;
}