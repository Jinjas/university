#include <stdio.h>
#include <math.h>
#include <string.h>

int main() {
    char v[1000][52];
    int aux[1000];
    int freq, linhafinal = 0;
    int valor;
    // v[0][23]--> posição (0,23)

    if (scanf("%d\n",&freq) == 1)
    
    for (int i = 0; fgets(v[i],52,stdin) != 0; i++,linhafinal++);

    for (int letra = 65; letra < 91; letra++){
    // por cada letra ver tds as apariçoes --> A = 65
        valor = 0;
        for (int linha = 0 ; linha < linhafinal; linha++) {
            // procurar tds os 1 letra
            aux [linha] = 1;
            for (int coluna = 0 ; coluna < 52; coluna ++)
                if (v[linha][coluna] == letra) {
                    valor ++;
                    aux [linha] = 0;
                    coluna = 100;
                }
        }
        if (valor >= freq)
            printf("%c = %d\n",letra, valor);
        
        //pares
        if (valor > 0) 
            for (int letra2 = letra + 1; letra2 < 91; letra2++) {
                valor = 0;
                for (int linha = 0 ; linha < linhafinal; linha++)
                //por cada linha que existe a letra vejo as combinações
                    if (!aux[linha])
                        for (int coluna = 0 ; coluna < 52; coluna ++)
                            if (v[linha][coluna] == letra2)
                                valor++;
                if (valor >= freq)
                    printf ("%c%c = %d\n",letra,letra2, valor);                
            }
    }
    return 0;
}