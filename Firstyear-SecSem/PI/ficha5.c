#include <stdio.h>
#include <math.h>
typedef struct aluno {
    int numero;
    char nome[100];
    int miniT [6];
    float teste;
} Aluno;

int nota (Aluno a) {
    int minis = 0;
    float n;
    for (int i = 0;i < 6;i++)
        minis += a.miniT[i];
    n = round((minis / 6.0) * 10 * 0.25 + a.teste * 0.75);
    if (n >= 10) return n;
    return 0;
}

void ordenaPorNum(Aluno t [], int N){
    Aluno menor = t[0];
    Aluno posi;
    int posimenor;
    for (int j = 0; j < N ; j++){
        menor = posi = t[j];
        for (int i = j; i < N; i++)
            if (t[i].numero < menor.numero){
                menor = t[i]; 
                posimenor = i;
            }
        t[j] = menor;
        t[posimenor] = posi;

    }
}

void aux (int t[]){
        printf ("{");
    for (int i = 0; i < 6; i++)
        printf (" %d ", t[i]);
    putchar('}');
}

int procuraNum  (int num, Aluno t[], int N){
    int u = N-1,m, l = 0;
    while (l <= u) {
        m = ( u + l)/2;
        if (t[m].numero == num) return m;
        if (t[m].numero < num) l = m+1;
        else u = m-1;
    }
    return -1;
}

void criaIndPorNum (Aluno t [], int N, int ind[]){
    int i,j,aux;
    for (i = 0; i < N;i++)
        ind[i] = i;
    for (i=0;i< N;i++) {
        aux = ind[i];
        for (j = i; j > 0 && t[ind[j-1]].numero > t[aux].numero; j--)
            ind[j] = ind [j-1];
        ind[j] = aux;
    }

    putchar('{');
    for (i = 0; i < N; i++)
        printf (" %d ", ind[i]);
    printf("}\n");
}

int main() {
    Aluno a = {7776, "Joao", {2,1,0,2,2,2}, 10.50};
    int ind[5];
    Aluno t[5] = {{4444, "André", {2,1,0,2,2,2}, 10.5}
                 ,{2222, "Joana", {2,2,2,1,0,0}, 14.5}
                 ,{7777, "Maria", {2,2,2,2,2,1}, 18.5}
                 ,{3333, "Paulo", {0,0,2,2,2,1}, 8.7}
                 ,a
                 };
/*    ordenaPorNum(t,5);
    for (int i = 0; i < 5;i++){
        printf("%d %s ",t[i].numero,t[i].nome);
        aux(t[i].miniT);
        printf(" %f\n",t[i].teste);
    }
*/
    //printf ("posição do 3333: %d \n",procuraNum (3333, t,5));

    criaIndPorNum(t,5,ind);
    for (int i = 0; i < 5;i++){
        printf("%d %s ",t[i].numero,t[i].nome);
        aux(t[i].miniT);
        printf(" %f\n",t[i].teste);
    }
    return 0;
    
}