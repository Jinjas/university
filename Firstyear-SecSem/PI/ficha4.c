#include <stdio.h>
#include <string.h>

int evogal(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
}

int contaVogais(char *s) {
    int acc = 0;
    for (int i = 0; s[i] != '\0'; i++)
        if (evogal(s[i]))
            acc++;
    return acc;
}
int retiraVogaisRep(char *s) {
    int acc = 0, i, j;
    for (i = 0; s[i] != '\0'; i++)
        if (evogal(s[i]) && s[i] == s[i - 1]) {
            acc++;
            for (j = i; s[j] != '\0'; j++)
                s[j] = s[j + 1];
            i--;
        }
    return acc;
}
int retiravogRep(char s[]) { // com array auxiliar
    char aux[1 + strlen(s)];
    int i, acc = 0, j;
    for (i = j = 0; s[i] != '\0'; i++)
        if (!evogal(s[i]) || s[i] != s[i + 1])
            aux[j++] = s[i];
        else
            acc++;
    aux[j] = '\0';
    strcpy(s, aux);
    return acc;
}
// ou
int retvogRep(char s[]) { // sem array auxiliar
    int i, acc = 0, j;
    for (i = j = 0; s[i] != '\0'; i++)
        if (!evogal(s[i]) || s[i] != s[i + 1])
            s[j++] = s[i];
        else
            acc++;
    s[j] = '\0';
    return acc;
}

/*
int duplicaVogais(char *s) {
    int acc = 0, i, j;
    char letra, letraguardada;
    for (i = 0; s[i] != '\0'; i++)
        if (evogal(s[i])) {
            acc++;
            letra = s[i];
            for (j = i; s[j - 1] != '\0'; j++) {
                letraguardada = letra;
                letra = s[j];
                s[j] = letraguardada;
            }
            s[i + 1] = s[i];
            i++;
        }
    return acc;
}
int partition (int x, int v[], int N) {
    int m[N], M[N], i ,im, iM,j;
    for (i = im = iM = 0; i < N; i++)
        if (v[i] <= x)  
            m[im++] = v[i];
        else M[iM++] = v[i];
    for (i = 0; i < im; i++)
        v[i] = m[i];
    for (j=0;j < iM; i++,j++)
        v[i] = m[j];
    return im;
}
int partition (int x, int v[], int N) {
int i,j;
if (v[j]<= x){swap(v,i,j);i++;}
}
*/

int partition (int x, int v[], int N) {
    int aux[N], i ,im, iM;
    for (i = im =0, iM =N - 1; i < N; i++)
        if (v[i] <= x)  
            aux[im++] = v[i];
        else aux[iM--] = v[i];
    for(i=0;i<N;i++) v[i] = aux[i];
    return im;
}

int main() {
    char a[100] = "Estaa e umaa string coom duuuplicadoos";
    char b[100] = "Esta e uma string com duplicados";
    int numes[7] = {1,2,3,4,5,6,7};
    printf("%c\n", 75);
    //printf("%s\n\tvogais retiradas : %d \n",a,retiraVogaisRep(a));
    //printf("\tvogais duplicadas : %d \n %s\n", duplicaVogais(b), b);
    //printf("%d\n",evogal('i'));
    return 0;
}
