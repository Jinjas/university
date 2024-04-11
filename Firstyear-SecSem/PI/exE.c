#include <stdio.h>
#include <string.h>

int capi(char v[]) {
    int valor = 1;
    int n = strlen(v);
    int start, end; 
    int tamanho = 0;
    if (v[0] == '\0')
        return 0;
    
    for (int i = 0; i < n; i++) {
// qual é o maximo que cada centro consegue
        start = i - 1; 
        end = i + 1;
        while (end < n && v[i] == v[end]) 
            end++;
        //aaaaaaas        
        while (start >= 0 && v[start] == v[i]) 
            start--;
        //saaaaaaa       
        while (start >= 0 && end < n && v[start] == v[end]) {
            start--;
            end++;
        //fasasad
        }
        tamanho = end - start - 1;
     
        if (tamanho > valor) 
            valor = tamanho;
    }
    return valor;
}
char v[10002];



int main () {
    if (scanf("%s",v) == 1)
        printf("%d\n",capi(v));
    return 0;
}
