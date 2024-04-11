{-# OPTIONS_GHC -Wno-incomplete-patterns #-}
module Questõesdamanha where
import Data.Vector (convert)

--5
reverte :: [a] -> [a]
reverte  = rev []
rev acc [] = acc
rev acc (h:t) = rev (h:acc) t

--11
group :: Eq a => [a] -> [[a]]
group [] = []
group [x] = [[x]]
group (h:t)
    | elem h (head r) = (h : (head r)) : tail r
    | otherwise = [h] : r
    where r = group t

--15
cabecas :: [[a]] -> [a]
cabecas [[]] = []
cabecas [] = []
cabecas ([] : t2) = cabecas t2
cabecas ((h : t1) : t2) = h : cabecas t2

--16
membros :: [a] -> Int
membros [] = 0
membros (h : t) = 1 + membros t

total :: [[a]] -> Int
total [[]] = 0
total [] = 0
total ([] : t) = 0 + total t
total (h : t) = membros h + total t

--17
fun :: [(a,b,c)] -> [(a,c)]
fun [] = []
fun ((a, b, c) : t) = (a, c) : fun t

--18
cola :: [(String,b,c)] -> String
cola [] = ""
cola ((a, b, c) : t) = a ++ cola t

--19
idade :: Int -> Int -> [(String,Int)] -> [String]
idade _ _ [] = ["es estupido nao es?"]
idade a i ((x,y) : t)
    | (a - i) - y >= 0 = x : idade a i t
    | otherwise = idade a i t

--20
pef :: Int -> Int -> [Int]
pef  = p 0
p acc n m
    | m > acc = n ^ acc : p (acc + 1) n m
    | otherwise = []

--21
isPrime :: Int -> Bool
prime :: Int -> Int -> Bool
isPrime  = prime 2

prime acc n = ( acc ^ 2 > n) || ( mod n acc /= 0) && prime (acc + 1) n

--23
isSofixof :: Eq a => [a] -> [a] -> Bool
isSofixof [] _ = True
isSofixof _ [] = False
isSofixof s l = last s == last l && isSofixof (init s) (init l)

--27
delete :: Eq a => a -> [a] -> [a]
delete _ [] = []
delete x (h:t)
    |x /= h = h : delete x t
    |otherwise = t

--28
remove :: Eq a => [a] -> [a] -> [a]
remove l [] = l
remove [] _ = []
remove l (h:t) = remove (delete h l) t

--32
tdJunto :: [String] -> String
tdJunto [] = ""
tdJunto (h:t) = h ++ (if null t then [] else " ") ++ tdJunto t

--33


emlinhas :: [String] -> String
emlinhas [] = ""
emlinhas (h:t) = h ++ "\n" ++ emlinhas t



elemIndices :: Eq a => a-> [a] -> [Int]
elemIndices _ [] = []
elemIndices x (h:t) | x == h = 0 : map (+1) (elemIndices x t)
                    | otherwise = map (+1) (elemIndices x t)


--ou

elemIndices' :: Eq a => a-> [a] -> [Int]
elemIndices' _ [] = []
elemIndices' x (h:t) | x == h = 0 : fuctionadoCRL (elemIndices' x t)
                    | otherwise = fuctionadoCRL (elemIndices' x t)

fuctionadoCRL :: [Int] -> [Int]
fuctionadoCRL [] = []
fuctionadoCRL (h:t) = h+1 : fuctionadoCRL t

--ou

elemIndices'' :: Eq a => a -> [a] -> [Int]
elemIndices'' x l = localizador x 0 l

localizador :: Eq a => a -> Int -> [a] -> [Int]
localizador _ _ [] = []
localizador x acc (h:t) | x == h = acc : localizador x (acc + 1) t
                        | otherwise = localizador x (acc + 1) t


quickSort'' :: Ord a => [a] -> [a]
quickSort'' [] = []
quickSort'' (l:ls) = maisPequenos ++ [l] ++ maiores
    where maisPequenos = quickSort'' (filter (<=l) ls)
          maiores = quickSort'' (filter (>l) ls)

--40
converteMSet :: [(a, Int)] -> [a]
converteMSet [] = []
converteMSet ((a,1):t) = a : converteMSet t
converteMSet ((a,b):t) = a : converteMSet ((a, b - 1) : t)

--44

partitionEithers' :: [Either a b] -> ([a],[b])
partitionEithers' [] = ([],[])
partitionEithers' ((Left a):t) = (a : as,bs)
    where (as,bs) = partitionEithers' t
partitionEithers' ((Right b):t) = (as,b : bs)
    where (as,bs) = partitionEithers' t


--45 

olhaUmGanso :: [Maybe a] -> [a]
olhaUmGanso [] = []
olhaUmGanso (Nothing : t) = olhaUmGanso t
olhaUmGanso (Just a : t) = a : olhaUmGanso t

data Movimento = Norte | Sul | Este | Oeste deriving (Show, Eq)
--46
caminho :: (Int, Int) -> (Int, Int) -> [Movimento]
caminho (xi, yi) (xf, yf)
    | xi < xf = Este : caminho (xi + 1, yi) (xf, yf)
    | xi > xf = Oeste : caminho (xi - 1, yi) (xf, yf)
    | yi < yf = Norte : caminho (xi, yi + 1) (xf, yf)
    | yi > yf = Sul : caminho (xi, yi - 1) (xf, yf)
    | otherwise = []

--47
hasLoops :: (Int,Int) -> [Movimento] -> Bool
hasLoops a [] = False
hasLoops a (x: xs) | a /= y = repete a ys
                   | otherwise = True
            where (y:ys) = tail (listaPosi a (x: xs))

--verifica se repete
repete :: (Int, Int) -> [(Int, Int)] -> Bool 
repete a [] = False
repete a (x : xs) | a == x = True
                  | otherwise = repete a xs


-- lista de posições
listaPosi :: (Int, Int) -> [Movimento] -> [(Int, Int)]
listaPosi a [] = [a]
listaPosi (a,b) (x : hs) | x == Norte = (a,b) : listaPosi (a, b+1) hs
                         | x == Sul = (a,b) : listaPosi (a, b-1) hs
                         | x == Este = (a,b) : listaPosi (a+1, b) hs
                         | x == Oeste = (a,b) : listaPosi (a-1, b) hs
                         
{-
posicao :: (Int,Int) -> [Movimento] -> (Int,Int)
posicao p [] = p
posicao (x, y) (m:ms) = posicao (case m of Norte -> (x, y + 1)
                                           Sul -> (x, y - 1)
                                           Este -> (x + 1, y)
                                           Oeste -> (x - 1, y)) ms

hasLoops :: (Int,Int) -> [Movimento] -> Bool
hasLoops _ [] = False
hasLoops pi ms = pi == posicao pi ms || hasLoops pi (init ms)
-}

--48)

type Ponto = (Float, Float)
data Rectangulo = Rect Ponto Ponto 

contaQuadrados :: [Rectangulo] -> Int 
contaQuadrados [] = 0 
contaQuadrados ((Rect (x1,y1) (x2,y2)):s) | abs (x1-x2) == abs (y1 - y2) = 1 +contaQuadrados s
                                          | otherwise = contaQuadrados s

--49)
areaTotal :: [Rectangulo] -> Float 
areaTotal [] = 0
areaTotal ((Rect (x1,y1) (x2,y2)):s) = abs (x1-x2) * abs (y1 - y2) + areaTotal s

--50)

data Equipamento = Bom | Razoavel | Avariado deriving (Show,Eq)

naoReparar :: [Equipamento] -> Int 
naoReparar [] = 0
naoReparar (a:b) | a == Avariado = 1 + naoReparar b
                 | otherwise = naoReparar b


--2)
eFTT :: Int -> Int -> Int -> [Int]
eFTT x1 x2 xf
              | (x1 > x2 && x2 > xf) || (x1 < x2 && x2 < xf) = x1 : eFTT  x2 (2 * x2 - x1) xf
              | otherwise = [x1]

--3)
maismais :: [a] -> [a] -> [a]
maismais [] l = l
maismais (h : t) l = h : maismais t l


--4)
ahhh :: [a] -> Int -> a
ahhh (h:t) 0 = h
ahhh (h:t) y = ahhh t (y-1)

--5)
birou :: [a] -> [a]
birou l = birou' l [] 

birou' [] acc = acc
birou' (h : t) acc = birou' t (h : acc)

--6) 
pegaEm :: Int -> [a]-> [a]
pegaEm 0 l = []
pegaEm _ [] = []
pegaEm x (h:t) = h : pegaEm (x-1) t


--7)
retiraEm :: Int -> [a]-> [a]
retiraEm 0 l = l
retiraEm _ [] = []
retiraEm x (h:t) =  retiraEm (x-1) t

--pmaior)

pmaior :: (Eq a, Ord a) => [a] -> Int 
pmaior (h:t) = pmaior' (1,0,h) t

pmaior' (posatu, posmai, maior) [] = posmai
pmaior' (posatu, posmai, maior) (h:t) | h > maior = pmaior' (posatu + 1, posatu, h) t
                                      | otherwise = pmaior' (posatu + 1, posmai, h) t



{-
{- |
Module      : Tarefa2_2021li1g040
Description : Construção/Desconstrução do mapa
Copyright   : Daniel da Silva Pereira <a100545@alunos.uminho.pt>;
            : Rodrigo Viana Ramos Casal Novo <a100534@alunos.uminho.pt>;

Módulo para a realização da Tarefa 2 do projeto de LI1 em 2021/22.

= Construção e desconstrução do mapa

A função __@constroiMapa@__ recebe numa lista de pecas, ordenada ou não, e retorna um mapa,
ou seja, uma lista de listas de pecas, em que cada lista de pecas corresponde a uma linha do mapa.
A função __@desconstroiMapa@__ recebe um mapa e torna-a numa lista de peças. 
-}
module Tarefa2_2021li1g040 where
import LI12122
import Tarefa1_2021li1g040
{- |
@
constroiMapa :: [(Peca, Coordenadas)] -> Mapa                 
constroiMapa input_mapa | validaPotencialMapa input_mapa = constroiMapaT4 input_mapa
                        | otherwise = []
@
A função @constroiMapa@ recorre uma função auxiliar @controiMapaT4@ pois, caso recorressemos à função @constroiMapa@
na tarefa 4, esta poderia falhar devido à validação do mapa. Sendo assim, a verificação do mapa é feita apenas 
em @constroiMapa@ procedendo para a construção do mapa em @constroiMapaT4@ (caso o @validaMapa@ retorne True).
-}

constroiMapa :: [(Peca, Coordenadas)] -- ^ Recebe a lista de pecas, ordenadas ou não
             -> Mapa                  -- ^ Retorna o mapa construido
constroiMapa input_mapa |validaPotencialMapa input_mapa = constroiMapaT4 input_mapa
                        | otherwise = []
constroiMapaT4 :: [(Peca, Coordenadas)] -> Mapa 
constroiMapaT4 input_mapa = constroi_aux (0,0) (ordena_linha_coluna [] input_mapa input_mapa (nLinhas input_mapa)) [] (tamanhoMapa input_mapa)
    where 
          constroi_aux :: (Int,Int) -> [(Peca, Coordenadas)] -> [Peca] -> Coordenadas -> Mapa
          constroi_aux (c,l) [] mapa (numcul,numlin) 
            |c == numcul +1 = concat_map mapa (0,0) (numcul,numlin) []
            | otherwise = constroi_aux (c+1,l) [] (mapa ++ [Vazio]) (numcul,numlin)          
          constroi_aux (c,l) pecas@((p1,(c1,l1)):ss) mapa (numcul,numlin) | (c<=numcul) && (l<=numlin) && isCoordIn (c,l) pecas = constroi_aux (c+1,l) ss (mapa ++ [p1]) (numcul,numlin)
                                                                          | (c<=numcul) && (l<=numlin) = constroi_aux (c+1,l) pecas (mapa ++ [Vazio]) (numcul,numlin)
                                                                          | otherwise = constroi_aux (0,l+1) pecas mapa (numcul,numlin)
          
          concat_map :: [Peca] -> (Int,Int) -> (Int,Int) -> [Peca] -> Mapa
          concat_map [] (accCol,accLin) (cColunas,cLinhas) juntador = []
          concat_map (h:t) (accCol,accLin) (cColunas,cLinhas) juntador | accCol < cColunas && accLin <= cLinhas = concat_map t (accCol +1 ,accLin) (cColunas,cLinhas) (juntador++[h])
                                                                       | accCol == cColunas && accLin <= cLinhas = (juntador ++ [h]) : (concat_map t (0 ,accLin+1) (cColunas,cLinhas) [])
                                                                       | otherwise = []
          
{-| A função @ordena_linha_coluna@ ordena o mapa por linhas e consecutivamente por colunas,
recorrendo posteriormente à função @ordenaColuna@ para o fazer retornando assim uma lista de peças 
ordenada tornando mais facil a execução da função @constroiMapa@
 -}
ordena_linha_coluna :: [(Peca,Coordenadas)] -- ^ Recebe um acumulador 
                    -> [(Peca,Coordenadas)] -- ^ Recebe a lista de pecas que serao verificas
                    -> [(Peca,Coordenadas)] -- ^ Recebe a mesma lista de peças que nunca será alterado, servindo apenas para repor a lista de peças anterior quando a função passa para uma nova linha
                    -> Int                  -- ^ Recebe o número de linhas do mapa
                    -> [(Peca,Coordenadas)] -- ^ Retorna a lista de peças ordenada
ordena_linha_coluna acc [] mapa linha 
    | linha < 0 = acc 
    | otherwise = (ordena_linha_coluna [] mapa mapa (linha-1)) ++ (ordenaColuna acc)

ordena_linha_coluna acc ((p,(c,l)):ss) mapa linha  
    | l == linha = ordena_linha_coluna (acc ++ [(p,(c,l))]) ss mapa linha 
    | otherwise = ordena_linha_coluna acc ss mapa linha 

{-| 
A função @ordenaColuna@ funciona similarmente ao quicksort mas ligeiramente adaptado ao problema em questão recorrendo às 
funções __@maisPequenos@__ e __@maiores@__
-}
ordenaColuna :: [(Peca,Coordenadas)] -- ^ Recebe a lista de peças ordenada por linhas
             -> [(Peca,Coordenadas)] -- ^ Retorna a lista de peças ordenada por linhas e por colunas
ordenaColuna [(p1,(c1,l1))] = [(p1,(c1,l1))]
ordenaColuna [] = []
ordenaColuna ((p1,(c1,l1)):ss) = (ordenaColuna (maisPequenos c1 ss)) ++ [(p1,(c1,l1))] ++ (ordenaColuna (maiores c1 ss))

{-| Coleciona as pecas com a coluna mais pequena em comparação com a do elemento central da função @ordenaColuna@ -}
maisPequenos :: Int -> [(Peca,Coordenadas)] -> [(Peca,Coordenadas)]
maisPequenos _ []= []
maisPequenos c ((p1,(c1,l1)):ss) | c1 <= c = (p1,(c1,l1)) : maisPequenos c ss
                                 | otherwise = maisPequenos c ss
 
{-| Coleciona as pecas com a coluna maior em comparação com a do elemento central da função @ordenaColuna@ -}
maiores :: Int -> [(Peca,Coordenadas)] -> [(Peca,Coordenadas)]        
maiores _ [] = []
maiores c ((p1,(c1,l1)):ss) | c1 > c = (p1,(c1,l1)) : maiores c ss
                            | otherwise = maiores c ss 
 
{-| 
 A @isCoordin@ verifica se a coordenada em questão consta no input 
-}
isCoordIn :: Coordenadas -> [(Peca, Coordenadas)] -> Bool
isCoordIn _ [] = False
isCoordIn (c1,l1) ((a,b):ss) = (c1,l1) == b || isCoordIn (c1,l1) ss

{-| Calcula o número de linhas do mapa-}
nLinhas :: [(Peca, Coordenadas)] -> Int
nLinhas mapa = l 
    where (_,l) = tamanhoMapa mapa

-----------------------------------------
{-|
A função __@desconstroiMapa@__ recebe uma lista de lista de peças e retorna uma lista de peças com as suas respetivas coordenadas 
ignorando os espaços vazios.
-}
desconstroiMapa :: Mapa -- ^ Recebe o mapa
                -> [(Peca, Coordenadas)] -- ^ Retorna uma lista de peças com as respetivas coordenadas
desconstroiMapa l = desconstroiMapa' l (0,0) 

desconstroiMapa' :: Mapa -> (Int,Int) -> [(Peca, Coordenadas)]
desconstroiMapa' [] (_,_)  = []
desconstroiMapa' ([] : resto) (c,l)  = desconstroiMapa' resto (0, l+1) 
desconstroiMapa' ([Vazio] : resto) (c,l) = desconstroiMapa' ([]:resto) (c, l) 
desconstroiMapa' ((peca1:pecas) : resto) (c,l) | peca1 == Vazio = desconstroiMapa' (pecas : resto) (c+1, l) 
                                               | otherwise = (peca1, (c,l)) : desconstroiMapa' (pecas : resto) (c+1, l)  
-}



t5


{-
{- |
Module      : Tarefa2_2021li1g040
Description : Aplicação gráfica completa
Copyright   : Daniel da Silva Pereira <a100545@alunos.uminho.pt>;
            : Rodrigo Viana Ramos Casal Novo <a100534@alunos.uminho.pt>;

Módulo para a realização da Tarefa 5 do projeto de LI1 em 2021/22.
-}

module Main where

import Graphics.Gloss
import Graphics.Gloss.Interface.Pure.Game
import LI12122
import Tarefa4_2021li1g040
import Tarefa2_2021li1g040 (desconstroiMapa)
import Graphics.Gloss.Interface.IO.Game (playIO)
import System.Exit (exitSuccess)
import Data.Maybe (fromJust)
import Mapas

data Estado = Menu OpcaoAtual [Jogo] -- jogo gravado
            | SelectMode OpcaoModo String Int [Jogo]
            | Pause Int Estado
            | Playable (([Jogo],[Jogo]),Picture,Picture,Coordenadas) -- jogo que se joga, jogo gravado, imagem do mapa ,imagem do jogador
            | Multiplayer (([Jogo'],[Jogo]),Picture,Picture,Picture,Coordenadas,[Coordenadas])
data OpcaoAtual = OpcaoJogo | OpcaoExit | OpcaoLoad --  OpcaoCont
data OpcaoModo = OpcaoNivel | Modo | Voltar
data Imagens = Imagens
   { pecas :: [(Peca,Picture)]
   , jogador :: [(Direcao,Picture)]
   , jogador' :: [(String,Picture)]
   , backgraunds :: [(String,Picture)]
   }
-- cosmetico dos menus// acrescentar mais mapas

type World = (Estado,Imagens)

janela :: Display
--janela = InWindow "LI1" (1000, 700) (0, 0)
janela = FullScreen

corFundo :: Color
--corFundo = greyN 0.9
corFundo = light $ light blue


inicialState :: Estado
inicialState = Menu OpcaoJogo levelMaps
  where levelMaps@(Jogo mapa jogador:restoDosNiveis)= [gameMap 1,gameMap 1,gameMap 2,gameMap 2,gameMap 3,gameMap 3,gameMap 4,gameMap 4]

coordPorta :: Mapa -> Coordenadas
coordPorta m = takecoord $ head (filter porta (desconstroiMapa m))
    where porta (p,_) = p==Porta
          takecoord (_,c) = c

pictureJogador :: Imagens-> Jogador -> Picture
pictureJogador img (Jogador (c,l) dir withBox)|dir == Oeste && withBox = pictures[Translate (fromIntegral (50*c)) (fromIntegral (50-50*l)) (scale 0.089 0.09 $ fromJust $ lookup Caixa $ pecas img),translate (fromIntegral(50*c)) (fromIntegral (-50*l)) $ scale 0.2 0.2 $ fromJust $ lookup Oeste $ jogador img]-------jogador com caixa
                                          |dir == Oeste =  translate (fromIntegral(50*c)) (fromIntegral (-50*l)) $ scale 0.2 0.2 $ fromJust $ lookup Oeste $ jogador img
                                          |dir == Este && withBox = pictures[Translate (fromIntegral (50*c)) (fromIntegral (50-50*l)) (scale 0.089 0.09 $ fromJust $ lookup Caixa $ pecas img), translate (fromIntegral(50*c)) (fromIntegral (-50*l)) $ scale 0.2 0.2 $fromJust $ lookup Este $ jogador img]-------jogador com caixa
                                          |otherwise =  translate (fromIntegral(50*c)) (fromIntegral (-50*l)) $ scale 0.2 0.2 $fromJust $ lookup Este $ jogador img

pictureJogador' :: Imagens-> Jogador -> Picture
pictureJogador' img (Jogador (c,l) dir withBox)|dir == Oeste && withBox = pictures[Translate (fromIntegral (50*c)) (fromIntegral (50-50*l)) (scale 0.089 0.09 $ fromJust $ lookup Caixa $ pecas img),translate (fromIntegral(50*c)) (fromIntegral (-50*l-1)) $ scale 0.2 0.2 $ fromJust $ lookup "Oeste" $ jogador' img]-------jogador com caixa
                                               |dir == Oeste =  translate (fromIntegral(50*c)) (fromIntegral (-50*l-1)) $ scale 0.2 0.2 $ fromJust $ lookup "Oeste" $ jogador' img
                                               |dir == Este && withBox = pictures[Translate (fromIntegral (50*c)) (fromIntegral (50-50*l)) (scale 0.089 0.09 $ fromJust $ lookup Caixa $ pecas img), translate (fromIntegral(50*c)) (fromIntegral (-50*l-1)) $ scale 0.2 0.2 $fromJust $ lookup "Este" $ jogador' img]-------jogador com caixa
                                               |otherwise =  translate (fromIntegral(50*c)) (fromIntegral (-50*l-1)) $ scale 0.2 0.2 $fromJust $ lookup "Este" $ jogador' img


{-
data Figura
    = Quadrado Int Color (Int,Int) --bloco e caixa
    | Rectangulo Int Int Color (Int,Int) -- porta
    | Circulo Int Color (Int,Int)

figuraToPicture :: Figura -> Picture
figuraToPicture (Quadrado l c (coluna,linha)) = Translate (fromIntegral coluna) (fromIntegral linha) $ Color c $ rectangleSolid (fromIntegral l)  (fromIntegral l)
figuraToPicture (Rectangulo b l c (coluna,linha)) = Translate (fromIntegral coluna) (fromIntegral linha) $ Color c $ rectangleSolid (fromIntegral b)  (fromIntegral l)
figuraToPicture (Circulo r c (coluna,linha)) = Translate (fromIntegral coluna) (fromIntegral linha) $ Color c $ Circle (fromIntegral r)

mapaToPicture :: (Mapa,Coordenadas) -> [Figura]
mapaToPicture ([],_)= []
mapaToPicture ([]:resto,(_,l)) = mapaToPicture (resto,(0,l-50))
mapaToPicture ((x:resto):resto',(c,l)) | x == Bloco = Quadrado 50 black (c,l) : tail
                                | x == Porta = Rectangulo 30 50 blue (c,l) : tail
                                | x == Vazio = tail
                                | x == Caixa = Quadrado 50 red (c,l) : tail
                                | otherwise = error "input não é um mapa"
                    where tail = mapaToPicture (resto:resto',(c+50,l))
-}

mapaToPicture :: Imagens -> (Mapa,Coordenadas) -> [Picture]
mapaToPicture img ([],_)= []
mapaToPicture img ([]:resto,(_,l)) = mapaToPicture img (resto,(0,l-50))
mapaToPicture img ((x:resto):resto',(coluna,linha)) | x == Bloco = Translate (fromIntegral coluna) (fromIntegral linha) (scale 0.129 0.17 $ fromJust $ lookup Bloco $ pecas img) : tail
                                | x == Porta = Translate (fromIntegral coluna+5) (fromIntegral linha) (scale 0.09 0.095 $ fromJust $ lookup Porta $ pecas img) : tail
                                | x == Vazio = tail
                                | x == Caixa = Translate (fromIntegral coluna) (fromIntegral linha) (scale 0.089 0.09 $ fromJust $ lookup Caixa $ pecas img) : tail
                                | otherwise = error "input não é um mapa"
                    where tail = mapaToPicture img (resto:resto',(coluna+50,linha))

printState :: World -> IO Picture --(Jogo,Picture,Picture) -> Picture 1150 750
--desenhar modo playable
printState (Playable ((Jogo mapa j:proximosniveis,save),fundo,jogador,c), img)= return $   Translate ((fromIntegral(length (head mapa))/(-2))*50+25)  ((fromIntegral(length mapa)/2)*50-25)  $ pictures [translate ((fromIntegral(length (head mapa))/2)*50-25)  ((fromIntegral(length mapa)/(-2))*50+25) $ scale 0.835 0.835 $ fromJust $ lookup "jogo1" $ backgraunds img,fundo, jogador]
printState (Playable _,img) = error "fim do jogo"

--desenhar modo multiplayer
--printState (Multiplayer ((Jogo' mapa j1 j2:proximosniveis,save),fundo,jogadorUm,jogadorDois,c,_), img)= return $ Translate ((fromIntegral(length (head mapa))/(-2))*50+25) ((fromIntegral(length mapa)/2)*50-25) $ pictures [translate ((fromIntegral(length (head mapa))/2)*50-25)  ((fromIntegral(length mapa)/(-2))*50+25) $ scale 0.835 0.835 $ fromJust $ lookup "jogo1" $ backgraunds img,fundo, jogadorUm, jogadorDois]
printState (Multiplayer ((Jogo' mapa j1 j2:proximosniveis,save),fundo,jogadorUm,jogadorDois,c,_), img)= return $ Translate ((fromIntegral(length (head mapa))/(-2))*50+25) ((fromIntegral(length mapa)/2)*50-25) $ pictures [translate ((fromIntegral(length (head mapa))/2)*50-25)  ((fromIntegral(length mapa)/(-2))*50+25) $ scale 4.5 4.5 $ fromJust $ lookup "jogo2" $ backgraunds img,fundo, jogadorUm, jogadorDois]
printState (Multiplayer _,img) = error "fim do jogo"

--desenhar 2ºMenu
printState (SelectMode Modo s n _, img)       |s == "Normal" = return $ Pictures [scale 0.8 0.8 $ fromJust $ lookup "Menu" $ backgraunds img , segundoQuadrado, Color blue primeiroQuadrado, terceiroQuadrado, Translate (-50) (-75) (Scale 0.30 0.30 (Text ("Level"++ show n))), Translate (-65) 45 (Scale 0.30 0.30 (Text s)),Translate (-45) (-195) (Scale 0.30 0.30 (Text "Back")),polygon [(120,20),(120,100),(160,60),(120,20)]]
                                              |otherwise     = return $ Pictures [scale 0.8 0.8 $ fromJust $ lookup "Menu" $ backgraunds img , segundoQuadrado, Color blue primeiroQuadrado, terceiroQuadrado, Translate (-50) (-75) (Scale 0.30 0.30 (Text ("Level"++ show n))), Translate (-65) 45 (Scale 0.30 0.30 (Text s)),Translate (-45) (-195) (Scale 0.30 0.30 (Text "Back")),polygon [(-120,20),(-120,100),(-160,60),(-120,20)]]
printState (SelectMode OpcaoNivel s n _, img) |n==1          = return $ Pictures [scale 0.8 0.8 $ fromJust $ lookup "Menu" $ backgraunds img , Color blue segundoQuadrado, primeiroQuadrado, terceiroQuadrado, Translate (-50) (-75) (Scale 0.30 0.30 (Text ("Level"++ show n))), Translate (-65) 45 (Scale 0.30 0.30 (Text s)),Translate (-45) (-195) (Scale 0.30 0.30 (Text "Back")),polygon [(120,-100),(120,-20),(160,-60),(120,-100)]]
                                              |s == "Normal" && n>1 && n < nMapaNormal = return $ Pictures [scale 0.8 0.8 $ fromJust $ lookup "Menu" $ backgraunds img , Color blue segundoQuadrado, primeiroQuadrado, terceiroQuadrado, Translate (-50) (-75) (Scale 0.30 0.30 (Text ("Level"++ show n))), Translate (-65) 45 (Scale 0.30 0.30 (Text s)),Translate (-45) (-195) (Scale 0.30 0.30 (Text "Back")),polygon [(-120,-100),(-120,-20),(-160,-60),(-120,-100)],polygon [(120,-100),(120,-20),(160,-60),(120,-100)]]
                                              |s == "Double" && n>1 && n < nMapaDouble = return $ Pictures [scale 0.8 0.8 $ fromJust $ lookup "Menu" $ backgraunds img , Color blue segundoQuadrado, primeiroQuadrado, terceiroQuadrado, Translate (-50) (-75) (Scale 0.30 0.30 (Text ("Level"++ show n))), Translate (-65) 45 (Scale 0.30 0.30 (Text s)),Translate (-45) (-195) (Scale 0.30 0.30 (Text "Back")),polygon [(-120,-100),(-120,-20),(-160,-60),(-120,-100)],polygon [(120,-100),(120,-20),(160,-60),(120,-100)]]
                                              |otherwise     = return $ Pictures [scale 0.8 0.8 $ fromJust $ lookup "Menu" $ backgraunds img, Color blue segundoQuadrado, primeiroQuadrado, terceiroQuadrado, Translate (-50) (-75) (Scale 0.30 0.30 (Text ("Level"++ show n))), Translate (-65) 45 (Scale 0.30 0.30 (Text s)),Translate (-45) (-195) (Scale 0.30 0.30 (Text "Back")),polygon [(-120,-100),(-120,-20),(-160,-60),(-120,-100)]]
printState (SelectMode voltar s n _, img)  = return $ Pictures [scale 0.8 0.8 $ fromJust $ lookup "Menu" $ backgraunds img, segundoQuadrado, primeiroQuadrado, Color blue terceiroQuadrado, Translate (-50) (-75) (Scale 0.30 0.30 (Text ("Level"++ show n))), Translate (-65) 45 (Scale 0.30 0.30 (Text s)),Translate (-45) (-195) (Scale 0.30 0.30 (Text "Back"))]

--desenhar 1ºMenu
printState (Menu OpcaoJogo _, img) =return $ Pictures $ scale 0.8 0.8 (fromJust $ lookup "Menu" $ backgraunds img) : segundoQuadrado : Color blue primeiroQuadrado : terceiroQuadrado : mainMenu
printState (Menu OpcaoLoad _, img) =return $ Pictures $ scale 0.8 0.8 (fromJust $ lookup "Menu" $ backgraunds img) : Color blue segundoQuadrado : primeiroQuadrado : terceiroQuadrado : mainMenu
printState (Menu OpcaoExit _, img) =return $ Pictures $ scale 0.8 0.8 (fromJust $ lookup "Menu" $ backgraunds img) : segundoQuadrado : primeiroQuadrado : Color blue terceiroQuadrado : mainMenu

--desenhar MenuPause
printState (Pause 1 (Playable _), img) =return $ Pictures ( Color blue (Line [(-110,-50),(-110,40),(110,40),(110,-50),(-110,-50)])  : line [(-110,-170),(-110,-70),(110,-70),(110,-170),(-110,-170)] : menuPauseP)
printState (Pause 2 (Playable _), img) =return $ Pictures ( Line [(-110,-50),(-110,40),(110,40),(110,-50),(-110,-50)] : Color blue (line [(-110,-170),(-110,-70),(110,-70),(110,-170),(-110,-170)]) : menuPauseP)
printState (Pause 1 (Multiplayer _), img) =return $ Pictures ( Color blue (Line [(-110,-50),(-110,40),(110,40),(110,-50),(-110,-50)])  : line [(-110,-170),(-110,-70),(110,-70),(110,-170),(-110,-170)] : menuPauseM)
printState (Pause 2 (Multiplayer _), img) =return $ Pictures ( Line [(-110,-50),(-110,40),(110,40),(110,-50),(-110,-50)] : Color blue (line [(-110,-170),(-110,-70),(110,-70),(110,-170),(-110,-170)]) : menuPauseM)
printState (Pause _ _, _) = error "algo nao está certo"

mainMenu = [Translate (-40) (-75) (Scale 0.30 0.30 (Text "Load")),Translate (-85) 45 (Scale 0.30 0.30 (Text "NewGame")),Translate (-30) (-195) (Scale 0.30 0.30 (Text "Exit"))]
menuPauseP = [Translate (-40) (-20) (Scale 0.30 0.30 (Text "Load")),Translate (-175) 180 (Text "Pause"),Translate (-85) (-135) (Scale 0.30 0.30 (Text "MainMenu")),Translate (-120) 135 (Scale 0.12 0.12 (Text "Press P to resume the game"))]
menuPauseM = [Translate (-72) (-20) (Scale 0.30 0.30 (Text "Resume")),Translate (-175) 180 (Text "Pause"),Translate (-85) (-135) (Scale 0.30 0.30 (Text "MainMenu")),Translate (-120) 135 (Scale 0.12 0.12 (Text "Press P to resume the game"))]
segundoQuadrado = Line [(-110,-110),(-110,-10),(110,-10),(110,-110),(-110,-110)]
primeiroQuadrado = Line [(-110,10),(-110,110),(110,110),(110,10),(-110,10)]
terceiroQuadrado = line [(-110,-230),(-110,-130),(110,-130),(110,-230),(-110,-230)]



reageTecla :: Event -> World -> IO World --Event -> (([Jogo],[Jogo]),Picture,Picture,Coordenadas) -> (([Jogo],[Jogo]),Picture,Picture,Coordenadas) 
--MainMenu
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (Menu OpcaoLoad save@(Jogo mapa jogador:restoDosNiveis), img) = return (Playable ((save,save), Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jogador,coordPorta mapa), img)
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (Menu OpcaoExit a, img) = exitSuccess
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (Menu OpcaoJogo a, img) = return (SelectMode Modo "Normal" 1 a, img)
reageTecla (EventKey (SpecialKey KeyDown) Down _ _) (Menu OpcaoLoad a, img) = return (Menu OpcaoExit a, img)
reageTecla (EventKey (SpecialKey KeyDown) Down _ _) (Menu OpcaoJogo a, img) = return (Menu OpcaoLoad a, img)
reageTecla (EventKey (SpecialKey KeyUp) Down _ _) (Menu OpcaoLoad a, img) = return (Menu OpcaoJogo a, img)
reageTecla (EventKey (SpecialKey KeyUp) Down _ _) (Menu OpcaoExit a, img) = return (Menu OpcaoLoad a, img)

--ModeMenu
reageTecla(EventKey (SpecialKey KeyRight) Down _ _) (SelectMode Modo "Normal" _ a, img) = return (SelectMode Modo "Double" 1 a, img)
reageTecla (EventKey (SpecialKey KeyLeft) Down _ _) (SelectMode Modo "Double" _ a, img) = return (SelectMode Modo "Normal" 1 a, img)
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (SelectMode Modo "Double" _ a, img) = return (Multiplayer ((levelMaps,a),Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jog1, pictureJogador' img jog2, coordPorta mapa,caixas mapa), img)
    where levelMaps@(Jogo' mapa jog1 jog2:restoDosNiveis) =  [multiMap 1,multiMap 1,multiMap 2,multiMap 2,multiMap 3,multiMap 3]
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (SelectMode Modo "Normal" _ a, img) = return (Playable ((levelMaps,levelMaps), Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jogador,coordPorta mapa), img)
    where levelMaps@(Jogo mapa jogador:restoDosNiveis)= [gameMap 1,gameMap 1,gameMap 2,gameMap 2,gameMap 3,gameMap 3,gameMap 4,gameMap 4]
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (SelectMode OpcaoNivel "Normal" n a, img) = return (Playable (([nivel,nivel],a),Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jogador,coordPorta mapa), img)
    where nivel@(Jogo mapa jogador)= gameMap n
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (SelectMode OpcaoNivel "Double" n a, img) = return (Multiplayer (([nivel,nivel],a),Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jog1, pictureJogador' img jog2, coordPorta mapa,caixas mapa), img)
    where nivel@(Jogo' mapa jog1 jog2)= multiMap n
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (SelectMode Voltar _ _ a, img) = return (Menu OpcaoJogo a, img)
reageTecla (EventKey (SpecialKey KeyDown) Down _ _) (SelectMode OpcaoNivel str n a, img) = return (SelectMode Voltar str n a, img)
reageTecla (EventKey (SpecialKey KeyDown) Down _ _) (SelectMode Modo str n a, img) = return (SelectMode OpcaoNivel str n a, img)
reageTecla (EventKey (SpecialKey KeyUp) Down _ _) (SelectMode OpcaoNivel str n a, img) = return (SelectMode Modo str n a, img)
reageTecla (EventKey (SpecialKey KeyUp) Down _ _) (SelectMode Voltar str n a, img) = return (SelectMode OpcaoNivel str n a, img)
reageTecla (EventKey (SpecialKey KeyRight) Down _ _) (SelectMode OpcaoNivel "Normal" n a, img) | n < nMapaNormal = return (SelectMode OpcaoNivel "Normal" (n+1) a, img)
reageTecla (EventKey (SpecialKey KeyRight) Down _ _) (SelectMode OpcaoNivel "Double" n a, img) | n < nMapaDouble = return (SelectMode OpcaoNivel "Double" (n+1) a, img)
reageTecla (EventKey (SpecialKey KeyLeft) Down _ _) (SelectMode OpcaoNivel str n a, img) |n > 1 = return (SelectMode OpcaoNivel str (n-1) a, img)

--PauseMenu
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (Pause 1 (Playable((_,save@(Jogo mapa jogador: restoDosNiveis)),_,_,c)), img) = return (Playable ((save,save), Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jogador,coordPorta mapa), img)
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (Pause 1 a, img) = return (a, img)
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (Pause 2 (Playable((_,save),_,_,_)), img) = return (Menu OpcaoJogo save, img)
reageTecla (EventKey (SpecialKey KeyEnter) Down _ _) (Pause 2 (Multiplayer ((_,save),_,_,_,_,_)), img) = return (Menu OpcaoJogo save, img)
reageTecla (EventKey (SpecialKey KeyDown) Down _ _) (Pause 1 a, img) = return (Pause 2 a, img)
reageTecla (EventKey (SpecialKey KeyUp) Down _ _) (Pause 2 a, img) = return (Pause 1 a, img)
reageTecla (EventKey (Char 'p') Down _ _) (Pause _ a, img) = return (a , img)
reageTecla (EventKey (SpecialKey KeyEsc) Down _ _) (Pause _ a, img) = return (a, img)

--Jogo SinglePlayer
reageTecla (EventKey a Down _ _) (Playable ((j:nextLevels,save),fundo,_,c@(col,l)), img) |b == InterageCaixa = return (Playable ((nJ:nextLevels,save),Pictures (mapaToPicture img (mapa,(0,0))), imgJogador,c), img)
                                             |b /= Nenhum && (coord ==(col,l-1) || coord ==(col,l)) = return (novoMapa ((j:nextLevels,save), img))
                                             |b /= Nenhum = return (Playable ((nJ:nextLevels,save),fundo,imgJogador,c), img)
                    where b = traduzEvento a
                          nJ@ (Jogo mapa jogador@(Jogador coord _ _)) = moveJogador j b
                          imgJogador = pictureJogador img jogador

reageTecla (EventKey (Char 'r') Down _ _) (Playable ((_:restartlevel@(Jogo mapa jogador):restoDosNiveis,save), _, _,c), img) = return (Playable ((restartlevel:restartlevel:restoDosNiveis,save), Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jogador,c), img)
reageTecla (EventKey (Char 'p') Down _ _) (Playable a, img) = return  (Pause 1 (Playable a), img)
reageTecla (EventKey (SpecialKey KeyEsc) Down _ _) (Playable a, img) = return (Pause 1 (Playable a), img)
reageTecla (EventKey (Char 't') Down _ _) (Playable ((faseAtual,_),fundo,jogador,c), img) = return (Playable ((faseAtual,faseAtual),fundo,jogador,c), img)

--Jogo MultiPlayer
reageTecla (EventKey a Down _ _) start@(Multiplayer ((j@(Jogo' m j1'@(Jogador coord1'@(colj1,linj1) _ _) j2'@(Jogador coord2'@(colj2,linj2) _ _)):nextLevels,save),fundo,j1,j2,c@(col,l),boxs), img) 
                  |(n == 1 && (elem coord1' boxs || coord1' == c)) || (n == 2 && (elem coord2' boxs ||coord2' == c)) = return start--- quando está com uma caixa por cima(nao se pode mexer) e quando está com uma caixa por cima(nao se pode mexer)
--                  |b /= (Nenhum,3) && (coord1' == c && (coord2 == (col,l-1) || coord2 == c)) ||(coord2' == c && (coord1 ==(col,l-1) || coord1 == c)) = return $ novoMapa' ((j:nextLevels,save), img)--- entram na porta
                  |n == 1 && (coord2' == c && (coord1 == (col,l-1) || coord1 == c)) = return $ novoMapa' ((j:nextLevels,save), img)--- entram na porta
                  |n == 2 && (coord1' == c && (coord2 == (col,l-1) || coord2 == c)) = return $ novoMapa' ((j:nextLevels,save), img)--- entram na porta

                  |b == (InterageCaixa,1) && elem coord2' (caixas map1) = return (Multiplayer ((nJ1:nextLevels,save),Pictures (mapaToPicture img (map1,(0,0))), imgJogador1,j2Esmagar,c,caixas map1), img)---pega/larga caixa
                  |b == (InterageCaixa,1) = return (Multiplayer ((nJ1:nextLevels,save),Pictures (mapaToPicture img (map1,(0,0))), imgJogador1,pictureJogador' img j2',c,caixas map1), img)---pega/larga caixa
                  |b == (InterageCaixa,2) && elem coord1' (caixas map2) = return (Multiplayer ((nJ2:nextLevels,save),Pictures (mapaToPicture img (map2,(0,0))),j1Esmagar, imgJogador2,c,caixas map2), img)---pega/larga caixa
                  |b == (InterageCaixa,2) = return (Multiplayer ((nJ2:nextLevels,save),Pictures (mapaToPicture img (map2,(0,0))),pictureJogador img j1', imgJogador2,c,caixas map2), img)---pega/larga caixa
                  |n == 1 && (coord1 == (col,l-1) || coord1 == c) = return (Multiplayer ((Jogo' map1 (Jogador c Este False) j2' :nextLevels,save),fundo,fimJogador,j2,c,boxs), img) 
                  |n == 2 && (coord2 == (col,l-1) || coord2 == c) = return (Multiplayer ((Jogo' map2 j1' (Jogador c Este False) :nextLevels,save),fundo,j1,fimJogador,c,boxs), img) 
                  |n == 1 = return (Multiplayer ((nJ1:nextLevels,save),fundo,imgJogador1,j2,c,boxs), img)
                  |b /= (Nenhum,3) = return (Multiplayer ((nJ2:nextLevels,save),fundo,j1,imgJogador2,c,boxs), img)
                  where b@(mov,n) = traduzEvento2 a
                        nJ1@ (Jogo' map1 jog1'@(Jogador coord1 _ _) _) = Jogo' nMapa nJogador j2'
                          where posMovimento@(Jogo nMapa nJogador) = moveJogador (Jogo m j1') mov
                        nJ2@ (Jogo' map2 _ jog2'@(Jogador coord2 _ _)) = Jogo' nMapa j1' nJogador
                          where posMovimento@(Jogo nMapa nJogador) = moveJogador (Jogo m j2') mov
                        imgJogador1 = pictureJogador img jog1'
                        imgJogador2 = pictureJogador' img jog2'
                        j2Esmagar = translate (fromIntegral(50*colj2)) (fromIntegral (-50*linj2-1)) $ scale 0.089 0.09 $ fromJust $ lookup "esmagarJ2" $ jogador' img
                        j1Esmagar = translate (fromIntegral(50*colj1)) (fromIntegral (-50*linj2-1)) $ scale 0.089 0.09 $ fromJust $ lookup "esmagarJ1" $ jogador' img
                        fimJogador = Translate (fromIntegral col*50+5) (fromIntegral (-l)*50) (scale 0.09 0.095 $ fromJust $ lookup Porta $ pecas img)

reageTecla (EventKey (Char 'r') Down _ _) (Multiplayer ((_:restartlevel@(Jogo' mapa jog1 jog2):restoDosNiveis,save), _, _,_,c,_), img) = return (Multiplayer ((restartlevel:restartlevel:restoDosNiveis,save), Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jog1, pictureJogador' img jog2, coordPorta mapa,caixas mapa), img)
reageTecla (EventKey (Char 'p') Down _ _) (Multiplayer a, img) = return  (Pause 1 (Multiplayer a), img)
reageTecla (EventKey (SpecialKey KeyEsc) Down _ _) (Multiplayer a, img) = return (Pause 1 (Multiplayer a), img)

reageTecla _ a = return a

traduzEvento :: Key -> Movimento
traduzEvento (SpecialKey KeyRight) = AndarDireita
traduzEvento (SpecialKey KeyLeft) = AndarEsquerda
traduzEvento (SpecialKey KeyUp) = Trepar
traduzEvento (SpecialKey KeyDown) = InterageCaixa
traduzEvento (Char 'd') = AndarDireita
traduzEvento (Char 'a') = AndarEsquerda
traduzEvento (Char 'w') = Trepar
traduzEvento (Char 's') = InterageCaixa
traduzEvento _ = Nenhum

traduzEvento2 :: Key -> (Movimento,Int)
traduzEvento2 (SpecialKey KeyRight) = (AndarDireita,2)
traduzEvento2 (SpecialKey KeyLeft) = (AndarEsquerda,2)
traduzEvento2 (SpecialKey KeyUp) = (Trepar,2)
traduzEvento2 (SpecialKey KeyDown) = (InterageCaixa,2)
traduzEvento2 (Char 'd') = (AndarDireita,1)
traduzEvento2 (Char 'a') = (AndarEsquerda,1)
traduzEvento2 (Char 'w') = (Trepar,1)
traduzEvento2 (Char 's') = (InterageCaixa,1)
traduzEvento2 _ = (Nenhum,3)

--coord das caixas no mapa
caixas :: Mapa -> [Coordenadas]
caixas m = takecoords $ filter caixa (desconstroiMapa m)
    where caixa (c,_) = c == Caixa
          takecoords [] = []
          takecoords ((_,c):resto) = c : takecoords resto 

--mudar para o próximo mapa 
novoMapa :: (([Jogo],[Jogo]),Imagens) -> World
novoMapa (([_,_],save), img) = (Menu OpcaoJogo save, img)
novoMapa ((_:_:restoDosNiveis@(proximoLevel@(Jogo mapa jogador):nextLevels),save), img) = (Playable ((proximoLevel:nextLevels,save), Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jogador,coordPorta mapa), img)
novoMapa (_, img) = (inicialState, img)

novoMapa' :: (([Jogo'],[Jogo]),Imagens) -> World
novoMapa' (([_,_],save), img) = (Menu OpcaoJogo save, img)
novoMapa' ((_:_:restoDosNiveis@(proximoLevel@(Jogo' mapa jog1 jog2):nextLevels),save), img) = (Multiplayer ((proximoLevel:nextLevels,save), Pictures (mapaToPicture img (mapa,(0,0))), pictureJogador img jog1, pictureJogador' img jog2,coordPorta mapa,caixas mapa), img)
novoMapa' (_, img) = (inicialState, img)

time :: Float -> World -> IO World
time _  = return

main :: IO ()
main = do
    p1 <- loadBMP "bmps/spidermanO.bmp"
    p2 <- loadBMP "bmps/spidermanE.bmp"
    p3 <- loadBMP "bmps/parede.bmp"
    p4 <- loadBMP "bmps/caixa.bmp"
    p5 <- loadBMP "bmps/portal.bmp"
    p6 <- loadBMP "bmps/2spidermanE.bmp"
    p7 <- loadBMP "bmps/2spidermanO.bmp"
--    p8 <- loadBMP "bmps/background3.bmp"
    p11 <- loadBMP "bmps/esmagadoJ1.bmp"
    p12 <- loadBMP "bmps/esmagadoJ2.bmp"
--    p11 <- loadBMP "bmps/bgPause.bmp"
    p8 <- loadBMP "bmps/background1.bmp"
    p9 <- loadBMP "bmps/background2.bmp"
    p10 <- loadBMP "bmps/bgMenu.bmp"   
    let estado = (inicialState,Imagens [(Bloco,p3),(Caixa,p4),(Porta,p5)] [(Oeste,p1),(Este,p2)] [("Oeste",p7),("Este",p6),("esmagarJ1",p11),("esmagarJ2",p12)] [("jogo1",p8),("jogo2",p9),("Menu",p10)])
    playIO
        FullScreen
        corFundo
        200
        estado
        printState
        reageTecla
        time
-}