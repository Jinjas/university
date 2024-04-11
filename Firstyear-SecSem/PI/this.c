#include <stdio.h>
#include <math.h>
#include <string.h>

typedef struct {
    int x, y;
} Posicao;

typedef struct {
    int id;
    double valor;
} Ar;

void insertF(Ar * array, Ar valor){
    int i;
    for(i = 0; i <= valor.id; i++)
        //procurar posicao
        if (array[i].valor > valor.valor) break;
    
    //colocar valor
    Ar aux2, aux1 = array[i];
    array[i] = valor;
    //shifts
    for(i++; i < valor.id; i++){
        aux2 = array[i];
        array[i] = aux1;
        aux1 = aux2;
    }
}

Posicao nesimo(Posicao a[], int N) {
    Ar array[N];
    int i;
    
    for(i = 0; i<N ; i++){
        Ar ar;
        ar.valor = a[i].x * a[i].x + a[i].y * a[i].y;
        ar.id = i;
        insertF(array, ar);
    }
    return a[array[2].id]; // termo - 1
}
void corrige(char str[]){
    int v = 82+123; // valor dado
    int i;
    for(i = 0; str[i] != '\0'; i++){
        v-=str[i] - '0';
    }
    for(i = 0; str[i] != '\0'; i++){
        if(str[i]=='0')
            if(v>9){
                v-=9;
                str[i]= '9';
            } else {
                str[i] = '0' + v;
                return;
            }
    }
    return ;
}

int main(){
    char str[1000] = "9088077463848473623726380000000000";
    corrige(str);
    printf("\n\t%s",str);



    Posicao p45[10] = {{1,355},{1,85},{24,0},{1,0},{1,15},{0,24},{1,30},{1,65},{1,76},{1,95}};
    Posicao pr = nesimo(p45,10);
    printf("\n\tx = %d  y = %d\n\n", pr.x, pr.y);
}




typedef struct nodo {
    int valor;
    struct nodo *esq, *dir;
} * ABin;


static int global = 1;

ABin procura(ABin a) {
    
    ABin ret = NULL;
    if(!a)
        return NULL;
    if(a->esq) {
        ret = procura(a->esq);
    }
    if(global==34 && !ret) return a;
    if (!ret){
        global++;
        ret = procura(a->dir);
    }
    return ret;
}
