module Ficha2 where

import Data.Char


tresUlt :: [a] -> [a]
tresUlt l = case l of (_:b:c:d:t) -> tresUlt (b:c:d:t)
                      _ -> l        

segundos :: [(a,b)] -> [b]                      
segundos []=[] 
segundos ((a,b):t) = b : segundos t  

nosPrimeiros :: (Eq a) => a -> [(a,b)] -> Bool
nosPrimeiros a [] = False
nosPrimeiros a ((b,c) : d) =  a == b || nosPrimeiros a d

sumTriplos :: (Num a, Num b, Num c) => [(a,b,c)] -> (a,b,c)
sumTriplos l = m (0,0,0) l
m (d,e,f) [] = (d,e,f)
m (d,e,f) ((a,b,c) : g) = m (d + a, e + b, f + c) g



arroz :: Char -> Bool -- arroz é isDigit
arroz d = ord d >= ord '0' && ord d <= ord '9'


soDigitos :: [Char] -> [Char]
soDigitos [] = []
soDigitos (h:t) = if arroz h == True then h: soDigitos t else soDigitos t

eLower ::Char -> Bool
eLower c = c `elem` ['a' .. 'z']

minusculas :: [Char] -> Int
minusculas [] = 0
minusculas (h:t)
        | eLower h = 1 + minusculas t
        | otherwise = minusculas t


digitparaInt :: Char-> Int
digitparaInt x = ord x - 48

nums :: String -> [Int]
nums [] = []
nums (h : t) 
    |arroz h = digitparaInt h : (nums t)
    |otherwise = nums t


type Polinomio = [Monomio]
type Monomio = (Float,Int)
grau :: Polinomio -> Int
grau l = g (0) l
g m [] = m
g m ((a,b) : c) 
    | m < b = g b c 
    | otherwise =  g m c 

somaNorm ::Monomio -> Polinomio -> Polinomio
somaNorm n [] = [n]
somaNorm (c1, e1) ((c2,e2): p)
    |e1 == e2 = (c1 + c2, e1) : p
    | otherwise = (c2, e2 ) : somaNorm (c1, e1) p

normaliza :: Polinomio-> Polinomio
normaliza [] = []
normaliza (n:p) = somaNorm n (normaliza p)


