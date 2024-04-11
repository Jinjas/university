module Ficha3 where


data Hora = H Int Int deriving (Show,Eq)
type Etapa = (Hora,Hora)
type Viagem = [Etapa]

--1 a 

valida :: [Etapa] -> Bool
valida [] = True
valida (h : t) = valida1 h && valida t

valida1 (x,y) = valida'' x && valida'' y && hseguinte x y 
    where valida'' (H h m) = (h >= 0 && h< 24) && (m >= 0 && m < 60)
          hseguinte (H h1 m1) (H h2 m2) = h1 > h2 || h1 ==h2 && m1 > m2 

--b
viagemOK :: Viagem -> Bool
viagemOK []= False
viagemOK [e] = valida1 e
viagemOK ((h1, h2) : (h3, h4) : t) = valida1 (h1, h2) && valida1 (h3, h4) && valida1 (h2, h3)

--d

efetivo :: Viagem -> Hora
efetivo [] = H 0 0
efetivo ((p, c) : es) =addMins (efetivo es) (hourDiff p c)

--ficha 1

hourDiff :: Hora -> Hora -> Int
hourDiff h1 h2 = abs (hour2min h1 - hour2min h2)

hour2min :: Hora -> Int
hour2min (H h m) = 60 * h + m

min2hour :: Int -> Hora
min2hour min = H (div min 60) (mod min 60)

addMins :: Hora -> Int -> Hora
addMins (H h m) min = min2hour (hour2min ( H h m) + min)
 
data Figura = Circulo Ponto Double
    | Rectangulo Ponto Ponto
    | Triangulo Ponto Ponto Ponto
     deriving (Show,Eq)

data Ponto = Cartesiano Double Double | Polar Double Double deriving (Show,Eq)
type Poligonal = [Ponto]
--2
--b
fechada :: Poligonal -> Bool
fechada p = length p > 3 && last p == head p

--c
triangula :: Poligonal -> [Figura]
triangula (p1 : p2 : p3 : p4: t) = (Triangulo p1 p2 p3) : triangula (p1 : p3 : p4 : t) 

area :: Figura -> Double
area (Triangulo p1 p2 p3) =
    let a = dist' p1 p2
        b = dist' p2 p3
        c = dist' p3 p1
        s = (a+b+c) / 2 -- semi-perimetro
    in sqrt (s*(s-a)*(s-b)*(s-c)) -- formula de Heron

dist' :: Ponto -> Ponto -> Double
dist' p1 p2 = sqrt((posx p1 -posx p2)^2 + (posy p1 -posy p2)^2)

posx :: Ponto -> Double
posx (Cartesiano x y) = x
posx (Polar r a) = r * cos a

posy :: Ponto -> Double
posy (Cartesiano x y) = y
posy (Polar r a) = r * sin a

--d

areaPoligono :: Poligonal -> Double
areaPoligono (p1: p2: p3 : p4 : t) = area (Triangulo p1 p2 p3) + areaPoligono (p1 : p3 : p4 : t)
areaPoligono _ = 0  

--e
-- 1- calcular distancia(dx,dy) entre o ponto e o ponto'
-- 2- calcular os novos pontos = ponto + distancias (dx,dy)

mover :: Poligonal -> Ponto -> Poligonal
mover [] _ = []
mover (p : ps) np = somaDist (p:ps) (dx,dy)
    where dx = posx np - posx p
          dy = posy np - posy p

somaDist [] _ = []
somaDist (p : ps) (dx,dy) = Cartesiano ((posx p) + dx) ((posy p) + dy) : (somaDist ps (dx,dy))