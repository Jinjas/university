#include <stdio.h>
#include <stdlib.h>

typedef struct nodo {
    int valor;
    struct nodo *esq, *dir;
} * ABin;


ABin removeMenor (ABin *a) {
    while ((*a)->esq){
        a = &(*a)->esq;
    }
}