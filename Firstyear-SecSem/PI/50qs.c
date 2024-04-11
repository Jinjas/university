#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <string.h>

int max (){
    int x=-1;
    int y;
    while (x != 0){
        scanf("%d",&x);

        if (x > y) 
            y=x;
    }
    printf ("O maior é %d", y);
}

int media(){
    int soma = 0;
    int numeros = -1;
    int x = -1;
    while (x != 0){
        scanf("%d",&x);
        soma+= x;
        numeros++;
    }
    int valor = soma/numeros;
    printf ("media é %d", valor);
}

int almostMax (){
    int x;
    scanf("%d",&x);

    int y;
    int z;
    while (x != 0) {
        scanf("%d",&x);
        if (x > y) {
            z=y;
            y=x;
        }
        else 
            if (x > z)
                z=x;
    }
    printf ("O segundo maior é %d", z);
}
int bitsUm (unsigned int n){
    int x = 0;
    for (; n>0; n/=2) 
        if (n % 2 == 1)
            x++;
    printf ("contagem de 1 --> %d\n",x);
}

int binaryTransform (int num) {
        int valor = num;
        printf ("número em binario %d --> ",num);
        while (valor>0) {
            printf ("%d",valor % 2);
            valor = valor/2;
        }
    putchar ('\n');
    return 0;
}

char *concats (char s1[], char s2[]) {
    int i = 0;
    while (s1[i] != '\0')
        i++;
    for (int j = 0; j <= strlen(s2);j++,i++)
        s1[i] = s2[j];
    s1[i] = '\0';
return s1;
}
//8
char *copy (char *dest, char source[]) {
    int i = 0;
    for (;source[i] != '\0'; i++)
        dest [i] = source[i];
    dest [i] = '\0';
    return dest;
}
//9
int comp (char s1[], char s2[]) {
    for (int i = 0; i < strlen(s2) || i < strlen(s1); i++) {
        if (s1[i] < s2[i]) {
            printf ("<0\n");
            return 0;
        } 
        if (s1[i] > s2[i]) {
            printf (">0\n");
            return 0;
        }
    }
    printf ("0\n");
    return 0;
}
char *where (char s1[], char s2[]) {
    for (int i = 0; i < strlen(s1) ; i++) {
        if (s1[i] == s2[0]) {
            for (int j = 0; j < strlen (s2)+1; j++) {
                if (s1[i+j] != s2[j]) {
                    //printf("what\nletra a comparar: %c\nletra da palavra: %c\n",s2[j],s1[i+j]);
                    break;
                    }
                else if (s1[i+j] == '\0') {
                    printf ("NULL\n");
                    return NULL;
                }
                if (s2[j+1] == '\0') {
                    printf ("%d\n",i);
                    return '\0';
                } 
            }
        }
    }
    printf ("NULL\n");
    return NULL;
}


void reverte (char s[]) {
    //trade--> troca 2 posiçoes;
    int max = strlen(s);
    int aux;    
    for (int i = 0; i <= max/2 ;i++) {
        aux = s[i];
        s[i] = s[max-i];
        s[max-i] = aux;
    }
    for (int i = 0; i <= max ;i++) 
        printf ("%c", s[i]);
    printf("\n");
}
void strnoV (char s[]){
    int i = 0;
    while ( i < strlen(s)) 
        if (s[i] != 65 && s[i] != 97 && s[i] != 65 + 4 && s[i] != 97 + 4 && s[i] != 65 + 8 && s[i] != 97 + 8 && s[i] != 65 + 14 && s[i] != 97 + 14 && s[i] != 65 + 20 && s[i] != 97 + 20){
            printf ("%c", s[i]);
            i++;
        }
        else for (int j = i;j< strlen(s); j++)
                 s[j] = s[j+1];
    printf("\n");
    for (int i = 0; i <= strlen(s) ;i++) 
        printf ("%c", s[i]);
    printf("\n");
}

void truncW (char t[], int n) {
    int a = 0;
    for (int i = 0; t[i] != '\0'; i++) {
        if (t[i] == ' ')
            a = 0;
        else a++;
        //remove até ao espaço
        if (a >= n+1) {
            for (int j = i; t[j] != '\0'; j++)
                t[j] = t[j+1];
            i--;
        }
        //"liberdade, igualdade e fraternidade"
    }
    printf("%s\n", t);
}

char charMaisfreq (char s[]) {
    int maior = 0, acc;
    char letra = 48;
    if (strlen(s) == 0)
        return letra;
    for (int i = 0;s[i] != '\0'; i++) {
        acc = 0;

        for (int j = 0; s[j] != '\0';j++)
            if (s[i] == s[j])
                acc++;

        if (acc > maior) {
            maior = acc;
            letra = s[i];
        }
    }
    return letra;
}

int iguaisConsecutivos (char s[]) {
    int maior = 0,valor;
    if (strlen(s) == 0)
        return 0;
    for (int i = 0; s[i] != '\0'; i++,valor = 1) {
        for(int j = i+1; s[i] == s[j]; j++,valor++);
        if (valor > maior)
            maior = valor;
    }
    return maior;
}

int check(char s[], int inicio , int verifyIt) {
    for (int i = inicio; i < verifyIt;i++)
        if(s[i] == s[verifyIt]) return 0;
    return 1;
}

// aaaaaa
//maior = 0 valor = 1 index = 0  j = 1 s[j] = a
int difConsecutivos (char s[]) { 
    int maior = 0, valor = 0;
    for (int index = 0; s[index] ; index++) {
        valor = 0;
        for(int j = index; s[j]; j++)
            if (check (s,index,j)) valor++;
                else break;
            if (valor > maior) maior = valor;
        }  
        printf ("%d\n",maior);
        return maior;
}

int sufPref (char s1[], char s2[]){
    //verificar se s1 é prefixo de s2
    //tirar o primeiro elemento de forma ciclica de s1 e repetir verificaçã
    for (int i=0; s1[i];i++){
        int tamanho = 0;
        for (int j = i; s1[j];j++) {
            if (s1[j] != s2[j-i]) break;
            tamanho++;
            if (s1[j+1] == '\0') return tamanho;
        }
    }
    return 0;

}
/*
void insere (int v[], int N, int x) {
    for (int i = 0; i <= N; i++) {
        if (v[i] > x){
            for(int j = N;j > i; j--) {
                v[j] = v[j-1];
            }
            v[i] = x;
            break;
        }
        if (i == N-1) v[N] = x;
    }
}
*/
void insere (int v[], int N, int x) {
    for (int i = 0; i < N; i++) {
        if (v[i] > x){
            for(int j = N;j >= i; j--) {
                v[j+1] = v[j];
            }
            v[i] = x;
            break;
        }
        if (i == N-1) v[N] = x;
    }
    for (int i = 0; i <= N; i++) {
        printf("%d ", v[i]);
    }
}

void merge (int r [], int a[], int b[], int na, int nb) {
    int k = 0,j = 0,i = 0;
    while (k < na + nb)
        if ((a[i] < b[j] && i < na) || j >= nb ) r[k++] = a[i++];
        else r[k++] = b[j++];
}


int menosFreq (int v[], int N) {
    int menor = v[0];
    int menorfreq = N, freqAtual;
    for (int i = 0; i < N; i++) {
        freqAtual = 0;
        for (int j = 0; j < N; j++) if (v[i] == v[j]) freqAtual++;
        if (menorfreq > freqAtual) {
            menorfreq = freqAtual;
            menor = v[i];
        }
    }
    printf("%d\n",menor);
    return menor;
}
int maxCresc (int v[], int N) {
    int valor = 1, maior = 1;
    for (int i = 0; i < N; i++){
        if (v[i] < v[i+1]) valor++;
        else{
            if (maior < valor) maior = valor;
            valor = 1;
        }
    }
    printf("%d\n",maior);
    return maior;
}

int crescente (int a[], int i, int j) {
    int valor = 1;
    while (i < j && valor) {
        if(a[i] > a[++i]) valor = 0;
    }
    return valor;
}




int main(){
  // almostMax();
  // media ();
  // max ();
  int v[ 12] = {1,2,3,4,5,6,7,9,29};
  char s1[100]= "carsomething";
  char s2[100]= "wadscar";
  char s3[26]= "abcedoiu";
  char s4[35]= "liberdade, igualdade e fraternidade";
  int numbers[100] = {1,23,1,32213123,44123,3,123,223,323,422,4,113,213,1};
  //menosFreq(numbers,14);
  //maxCresc(numbers,14);  
  //printf("%d\n",crescente(numbers,5,9));
  insere (v,9,100);
  printf("\n");
  insere (v,10,0);
  printf("\n");
  insere (v,11,8);
  // difConsecutivos(s1);
  // truncW (s4, 4);
  // reverte (s3);
  // strnoV (s3);
  // printf ("%c\n",charMaisfreq(s1));
  // comp(s1,s2);
  // where(s1,s2);
  // bitsUm(30);
  // binaryTransform(30);
  // printf ("%d\n",sufPref("batota","totalidade"));

  return 0;
}