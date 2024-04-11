#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct celula {
    char *palavra;
    int ocorr;
    struct celula * prox;
} * Palavras;

void libertaLista (Palavras);
int quantasP (Palavras);
void listaPal (Palavras);
char * ultima (Palavras);
Palavras acrescentaInicio (Palavras, char *);
Palavras acrescentaFim (Palavras, char *);
Palavras acrescenta (Palavras, char *);
struct celula * maisFreq (Palavras);

void libertaLista (Palavras l) {
    Palavras prox;
    while (l) {
        prox = l->prox;
        free (l->palavra);
        free (l);
        l = prox;
    }
}

int quantasP (Palavras l) {
    int cont = 0;
    while (l != NULL) {
        cont += l->ocorr;
        l = l->prox;
    }
    return cont;
}

void listaPal (Palavras l) {
    while (l != NULL) {
        printf ("%s (%d)\n",l->palavra,l->ocorr);
        l = l->prox;
    }
}
char * ultima (Palavras l) {
    if(l == NULL) return NULL;
    while (l->prox != NULL) l = l->prox;
    return l->palavra;
}
Palavras acrescentaInicio (Palavras l, char *p) { 
    Palavras new = malloc (sizeof (struct celula));
    new->ocorr  = 1;
    new->palavra = strdup(p);
    new->prox = l;
    return new;
}
Palavras acrescentaFim (Palavras l, char *p) {
    Palavras inicio = l;
    Palavras new = malloc (sizeof (struct celula));
    new->ocorr = 1;
    new->palavra = strdup(p);
    new->prox = NULL;
    if (inicio == NULL) return new;
    while (l->prox != NULL) l = l->prox;
    l->prox = new;
    return inicio;
}
Palavras acrescenta (Palavras l, char *p) {
    Palavras aux = l;
    while (aux != NULL && strcmp(aux->palavra , p)) aux = aux->prox;
        if (aux !=NULL){
            aux->ocorr++;
            return l;
        }
//    aux->prox = acrescentaInicio(aux,p);
//    return l;
    return acrescentaInicio(l,p);
}
struct celula * maisFreq (Palavras l) {
    Palavras pall = NULL;
    int maior = 0;

    while (l != NULL) {
        if (l->ocorr > maior) {pall = l; maior = l->ocorr;}
        l = l->prox;
    }
    return pall;
}

int main () {
    Palavras dic = NULL;

    char * canto1 [44] = {
        "as", "armas", "e", "os", "baroes", "assinalados",
        "que", "da", "ocidental", "praia", "lusitana", 
        "por", "mares", "nunca", "de", "antes", "navegados",
        "passaram", "ainda", "alem", "da", "taprobana",
        "em", "perigos", "e", "guerras", "esforcados",
        "mais", "do", "que", "prometia", "a", "forca", "humana",
        "e", "entre", "gente", "remota", "edificaram", 
        "novo", "reino", "que", "tanto", "sublimaram"
        };

    printf ("\n_____________ Testes _____________\n\n");

    int i; struct celula *p;
    for (i=0;i<44;i++)
        dic = acrescentaFim (dic, canto1[i]);

    printf ("Foram inseridas %d palavras\n", quantasP (dic));
    printf ("palavras existentes:\n");
    listaPal (dic);
    printf ("última palavra inserida: %s\n", ultima (dic));

    libertaLista (dic);

    dic = NULL;

    srand(42);
    
    for (i=0; i<1000; i++)
        dic = acrescenta (dic, canto1 [rand() % 44]);
    
    printf ("Foram inseridas %d palavras\n", quantasP (dic));
    printf ("palavras existentes:\n");
    listaPal (dic);
    printf ("última palavra inserida: %s\n", ultima (dic));
    
    p = maisFreq (dic);
    printf ("Palavra mais frequente: %s (%d)\n", p->palavra, p->ocorr);
    
    printf ("\n_________ Fim dos testes _________\n\n");

    return 0;
}