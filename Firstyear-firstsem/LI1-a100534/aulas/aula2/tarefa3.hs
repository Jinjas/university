{-| 
Module : tarefa 3 de LI1
Description: resolução dos exercicios da aula
Copyright: editor

Nesta tarefa procedeu-se a execução de 7 alineas
a) Contar quantos impares tem uma lista.
b) 
-}
module Tarefa3 where
{-| 


a função `contaImpares` recebe uma lista e por cada impar soma 1 unidade ao total
no fim devolve o resultado da soma

@
contaImpares :: [Int] -> Int
contaImpares [] = 0 
contaImpares (x: xs) = if odd x 
                       then 1 + contaImpares xs 
                       else contaImpares xs
@
== Exemplos de utilização:

>>> contaImpares [1,2,3]
2

>>> contaImpares [2]
0
-}

contaImpares :: [Int]-- ^ recebe uma lista de inteiros
              -> Int -- ^ devolve um numero inteiro
contaImpares [] = 0 
contaImpares (x: xs) = if odd x then 1 + contaImpares xs else contaImpares xs
{-| 
a função `stringRmv` recebe uma lista de palavras e remove todas que começem por um certo caracter


@
stringRmv :: [String]-> Char-> [String]
stringRmv [] c = []
stringRmv ((h1:t1):t2) c = if h1 == c 
                           then stringRmv t2 c 
                           else ((h1:t1):(stringRmv t2 c))
@
== Exemplos de utilização:

>>>stringRmv ["ola","tudo","adeus", "olatungi"] 'o'
["tudo","adeus"]
-}


-- haddock -h -o doc/html tarefa3.hs
-- xdg-open doc/html/index.html

stringRmv :: [String] -- ^ recebe uma sequência de palavras
            -> Char  -- ^ recebe também um caracter
            -> [String] -- ^ devolve uma string sem as palavras começadas com esse caracter
stringRmv [] c = []
stringRmv ((h1:t1):t2) c = if h1 == c then stringRmv t2 c else ((h1:t1):(stringRmv t2 c))

