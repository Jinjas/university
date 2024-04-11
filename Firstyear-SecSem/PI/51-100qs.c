#include <stdio.h>
#include <stdlib.h>


typedef struct lligada {
    int valor;
    struct lligada *prox;
} *LInt;

LInt newLInt (int, LInt);
int length (LInt l);


LInt newLInt (int v, LInt t){
    LInt new = (LInt) malloc (sizeof (struct lligada));
    
    if (new!=NULL) {
        new->valor = v;
        new->prox  = t;
    }
    return new;
}
//1
int length (LInt l){
    if (l == NULL) return 0;
    int i = 1;
    while (l->prox != NULL) {
        i++;
        l = l->prox;
    }
    return i;
}
//2
void freeL (LInt l) {
    while (l) {
        LInt temp = l;
        l = l->prox;
        free(temp);
    }
}
//3
void imprimeL (LInt l) {
    while (l != NULL) {
    printf("%d\n", l->valor);
        l = l->prox;
    }
}
//4
LInt reverseL (LInt l) {
    LInt anterior = NULL,proximo;
    if (!(l || l->prox)) return l;
    while (l) {
        proximo = l->prox;
        l->prox = anterior;
        anterior = l;
        l = proximo;    
    }
    return anterior;
}
//5
void insertOrd (LInt *l, int x) {
    LInt new = malloc(sizeof(struct lligada));
    new->valor = x;
    new->prox = NULL;
    LInt prev = NULL;
    if(!l)
        *l = new;
    while (*l && x > (*l)->valor){
        prev = *l;
        l = &((*l)-> prox);
    }
        if (prev) {
        new->prox = *l;
        prev->prox =new;
        }
        else {
            new->prox = *l;
            *l = new;
        }
}
//6
int removeOneOrd (LInt *l, int x) {
    LInt start = (*l);
    LInt prev = NULL;
    while (*l && x > (*l)->valor) {
        prev = *l;
        *l = (*l)->prox;
    }
    if (!(*l)) {
        *l = start;
        return 1;
    }
    if (prev == NULL) {
        *l = (*l)->prox;
        return 0;
    }
    else{
        prev->prox = (*l)->prox;
        free(*l);
        (*l) = start;
        return 0;
    }
}

//7
void merge (LInt *r, LInt a, LInt b) {
    if(!a) *r = b;
    else if(!b) *r = a;
    else{
        if (a->valor < b->valor){
           *r = a;
        a = a->prox;
        }
        else {
            *r = b;
            b = b->prox;
        }
        LInt aux = *r;
            while (a && b){
                if (a->valor < b->valor) {
                    aux->prox = a;
                    aux = a;
                    a = a->prox;
                }
                else {
                    aux->prox = b;
                    aux = b;
                    b = b-> prox;
                }
            }
        if(!a) aux->prox = b;
        else  aux->prox = a;
    }
}

//8

void splitQS(LInt l, int x, LInt *mx, LInt *Mx) {
    if (!l) return;
    LInt* aux = mx;
    LInt startlow;
    LInt starthigh;
    LInt* Aux = Mx;
    while (l) {
        if (l->valor < x){
            if (!*mx) {
                (*aux) = l;
                l = l->prox;
                (*aux)->prox = NULL;
                startlow = (*mx);
            }
            else {
            (*aux)->prox = l;
            l = l->prox;
            (*aux) = (*aux)->prox;
            (*aux)->prox = NULL;
            }
        }
        else if (!*Mx) {
            (*Aux) = l;
            l = l->prox;
            (*Aux)->prox = NULL;
            starthigh = (*Mx);
            }
            else {
            (*Aux)->prox = l;
            l = l->prox;
            (*Aux) = (*Aux)->prox;
            (*Aux)->prox = NULL;
        }
    }    
    (*mx) = startlow;    
    (*Mx) = starthigh;    
}
//9
LInt parteAmeio (LInt *l){
    int meio = length (*l);
    LInt y = *l;
    LInt ant=NULL;
    for (int i = 0; i< meio; i++){
        ant = *l;
        *l = (*l)->prox;
    }
    ant->prox = NULL;
    return y;
}

//10
int removeAll (LInt *l, int x) {
    LInt start = *l;
    int acc = 0;
    LInt anterior = NULL;
    while (*l) {
        if ((*l)->valor == x) {
            if (!anterior) {(*l) = (*l)->prox;start = *l;}
            else{
            anterior->prox = (*l)->prox;
            *l = (*l)->prox;
            }
            acc++;
        }
        else {
            anterior = *l;
            *l = (*l)->prox;
        }
    }
    (*l) = start;
    return acc;
}





LInt getLInt(int len) {
    if(len == 0) return NULL;
    LInt new = malloc(sizeof(struct lligada));
    printf("Insere um valor: ");
    int num;
    scanf("%d",&num);
    new->valor = num;
    new->prox = getLInt(len - 1);
    return new;
}

LInt getLIntCirc(int len) {
    LInt list = NULL;
    LInt prev = NULL;
    for(int i = 0; i < len; i++) {
        LInt new = malloc(sizeof(struct lligada));
        if(!list) list = new;
        if(prev) prev->prox = new;
        printf("Insere um valor: ");
        int num;
        scanf("%d",&num);
        new->valor = num;
        prev = new;
    }
    prev->prox = list;
    return list;
}

void printLInt(LInt l) {
    if(l == NULL) putchar('\n');
    else {
        printf("%d ",l->valor);
        printLInt(l->prox);
    }
}




int main(int argc, char const *argv[]) {
    LInt list1, list2;
    int opcao, len, num, num1, num2, resp, x, y;
    printf("Insere o numero correspondente ao exercicio: ");
    scanf("%d",&opcao);
    while(getchar() != '\n'); // Ao usar o scanf, o caracter '\n' permanece no buffer. Este while vê-se livre do '\n', para não estragar os getLine em baixo.
    switch (opcao) {
        case 1:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            num = length(list1);
            printf("Comprimento da lista: %d",num);
            break;
        case 2:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            printf("Comprimento da lista: %d\n",length(list1));
            freeL(list1);
            printLInt(list1);
            printf("Comprimento da lista: %d\n",length(list1));
            break;
        case 3:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            imprimeL(list1);
            break;
        case 4:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            list1 = reverseL(list1);
            printLInt(list1);
            break;
        case 5:
            printf("Comprimento da lista ordenada: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printf("Elemento a inserir: ");
            scanf("%d",&num);
            printLInt(list1);
            insertOrd(&list1,num);
            printLInt(list1);
            break;
        case 6:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printf("Elemento a remover: ");
            scanf("%d",&num);
            printLInt(list1);
            if(!removeOneOrd(&list1,num)) printLInt(list1);
            else printf("Elemento não encontrado!");
            break;
        case 7:
            printf("Comprimento da lista ordenada 1: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printf("Comprimento da lista ordenada 2: ");
            scanf("%d",&len);
            list2 = getLInt(len);
            LInt* merged = malloc(sizeof(struct lligada));
            merge(merged,list1,list2);
            printLInt(*merged);
            break;
        case 8:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printf("Valor para dividir: ");
            scanf("%d",&num);
            LInt *menores = malloc(sizeof(struct lligada));
            LInt *maiores = malloc(sizeof(struct lligada));
            splitQS(list1,num,menores,maiores);
            printf("Menores: ");
            printLInt(*menores);
            printf("Maiores: ");
            printLInt(*maiores);
            break;
        case 9:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            LInt metade = parteAmeio(&list1);
            printLInt(metade);
            printLInt(list1);
            break;
        case 10:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printf("Elemento a remover: ");
            scanf("%d",&num);
            printLInt(list1);
            resp = removeAll(&list1,num);
            printLInt(list1);
            printf("%d elementos removidos.\n",resp);
            break;
        /*case 11:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            resp = removeDups(&list1);
            printLInt(list1);
            printf("%d elementos removidos.\n",resp);
            break;
        case 12:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            resp = removeMaiorL(&list1);
            printLInt(list1);
            printf("Maior elemento: %d\n",resp);
            break;
        case 13:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            init(&list1);
            printLInt(list1);
            break;
        case 14:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            printf("Elemento a inserir: ");
            scanf("%d",&num);
            appendL(&list1,num);
            printLInt(list1);
            break;
        case 15:
            printf("Comprimento da lista 1: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printf("Comprimento da lista 2: ");
            scanf("%d",&len);
            list2 = getLInt(len);
            printLInt(list1);
            printLInt(list2);
            concatL(&list1,list2);
            printLInt(list1);
            break;
        case 16:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            printf("Endereço: %d\n", list1);
            list2 = cloneL(list1);
            printLInt(list2);
            printf("Endereço: %d\n", list2);
            break;
        case 17:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            printf("Endereço: %d\n", list1);
            list2 = cloneRev(list1);
            printLInt(list2);
            printf("Endereço: %d\n", list2);
            break;
        case 18:
            printf("Comprimento da lista: ");
            scanf("%d",&len);
            list1 = getLInt(len);
            printLInt(list1);
            resp = maximo(list1);
            printf("Máximo: %d", resp);
            break;*/
    }
    printf("\n");
    return 0;
}
