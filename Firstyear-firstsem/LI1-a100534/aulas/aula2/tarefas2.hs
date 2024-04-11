{-|
Module : Exerc2-ficha1
Description : Este modulo contem resoluções da tarefa 2 da primeira aula 

Copyright   : Rodrigo <a100534@alunos.uminho.pt>;
-}
module Exerc2x where
{- | A função ’area_ld’ calcula a area de um quadrado quando nos dado o valor do lado


@
 area_ld x = x*x
@

== Exemplos de utilização:

>>> area_ld 2
4

-}

area_ld x = x*x

--perimetro retangulo b
perimR :: (Integer, Integer) ->Integer
perimR (b, l) = (2*b + 2*l)

--caracter pertence string c
charstng :: Char -> [Char] -> Bool
charstng c s = elem c s

-- exercicio d
elemRmv ::[a]-> [a]
elemRmv l = if  (mod (length l) 2) == 0 
            then tail l
            else init l

-- exercicio e
fstLst :: [a] -> (a, a)
fstLst l = (head l, last l)

-- exercicio f
name :: [String] -> (String, String)
name l = (head l, last l)

-- exercicio g
listas :: ([a], [b])-> (a, [b])
listas (xs,ys) = (head xs , ys)

-- exercicio h
nameu :: [String] -> String
nameu l = [head (head l)] ++ "." ++ last l

