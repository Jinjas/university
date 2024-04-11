typedef struct nodo {
    int valor;
    struct nodo *pai, *esq, *dir;
} *ABin;

void caminho (ABin a) {
    if (a ->pai){
        ABin pai = (a->pai);
        if (a == pai->dir){
            caminho (pai);
            printf (" dir ");
        }
        else {
            caminho (pai);
            printf(" esq ");
        }
    }
}
void main (){
    ABin a;
    
}