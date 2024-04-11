module Ficha1 where

import Data.Char
-- area dado o lado
area_ld x = x*x

--perimetro retangulo
perimR :: (Integer, Integer) ->Integer
perimR (b, l) = (2*b + 2*l)

-- perimetro circulo a
perimC :: Float-> Float
perimC x= 2 * x * pi

--distancia de 2 pontos b
dist :: (Double, Double) -> (Double,Double)-> Double
dist (x1,y1)(x2,y2)= sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))

-- primeiro e ultimo de uma lista c
primUlt::[a]->(a,a)
primUlt l =(head l,last l)

--verifica se é multiplo d
multiplo:: Int->Int->Bool
multiplo m n = mod m n == 0
--multiplo m n =if mod m n == 0 then True else False

-- alinea etake _ [] = []
data Semaforo = Verde | Amarelo | Vermelho deriving (Show,Eq)

safe :: Semaforo -> Semaforo -> Bool
safe Vermelho _ = True
safe _ Vermelho = True
safe _ _ = False

--ex 6
data Ponto = Cartesiano Double Double | Polar Double Double deriving (Show,Eq)
--a
posx :: Ponto -> Double
posx (Cartesiano x y) = x
posx (Polar r a) = r * cos a
--b
posy :: Ponto -> Double
posy (Cartesiano x y) = y
posy (Polar r a) = r * sin a
--c
raio :: Ponto -> Double
raio (Cartesiano x y) = sqrt(x^2 + y^2)
raio (Polar r a) = r
--d
angulo :: Ponto -> Double
angulo (Cartesiano x y) = atan (y/x)
angulo (Polar a r) = a
--e
dist' :: Ponto -> Ponto -> Double
dist' p1 p2 = sqrt((posx p1 -posx p2)^2 + (posy p1 -posy p2)^2)

--ex 7

data Figura = Circulo Ponto Double
            | Retangulo Ponto Ponto
            | Triangulo Ponto Ponto Ponto
              deriving (Show,Eq)

--a
poligono :: Figura -> Bool
poligono (Circulo c r) = False
poligono (Retangulo p1 p2) = posx p1 /= posx p2 && posy p1 /= posy p2
poligono (Triangulo p1 p2 p3) = dist' p1 p2 + dist' p2 p3 > dist' p1 p3 && dist' p1 p2 + dist' p1 p3 > dist' p2 p3 && dist' p3 p2 + dist' p1 p3 > dist' p1 p2 

--b
vertices :: Figura -> [Ponto]
vertices (Circulo c r) = []
vertices (Retangulo p1 p2) = if poligono (Retangulo p1 p2)  then [p1, Cartesiano (posx p1) (posy p2) , p2, Cartesiano (posx p2) (posy p1) ] else []
vertices (Triangulo p1 p2 p3) = if poligono (Triangulo p1 p2 p3)  then [ p1, p2, p3] else []

--c
area :: Figura -> Double
area (Triangulo p1 p2 p3) =
    let a = dist' p1 p2
        b = dist' p2 p3
        c = dist' p3 p1
        s = (a+b+c) / 2 -- semi-perimetro
    in sqrt (s*(s-a)*(s-b)*(s-c)) -- formula de Heron
area (Retangulo p1 p2) =
    let a = dist' (Cartesiano (posx p1) (posy p2)) p2
        b = dist' p1 (Cartesiano (posx p1) (posy p2))
    in a * b
area (Circulo c r) = pi * (r^2)

--d 
perimetro :: Figura -> Double
perimetro (Circulo c r) = 2 * pi * r
perimetro (Retangulo p1 p2) = 2 * abs (posx p2 - posx p1) + 2 * abs (posy p2 - posy p1)
perimetro (Triangulo p1 p2 p3) = dist' p1 p2 + dist' p2 p3 + dist' p1 p3

-- ex 8


--a
isLower :: Char -> Bool
isLower ch = ch `elem` ['a'..'z']

--b
arroz :: Char -> Bool
arroz d = ord d >= ord '0' && ord d <= ord '9'



