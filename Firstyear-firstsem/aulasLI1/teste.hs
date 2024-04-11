module Main where

import Graphics.Gloss
import Graphics.Gloss.Interface.Pure.Game
janela :: Display 
--janela = InWindow "LI1" (200, 200) (0, 0)
janela = FullScreen

corFundo :: Color 
corFundo = greyN 0.5 

circ1 :: Figura 
circ1 = Circulo 10 red (500,500)

quad1 :: Figura 
quad1 = Quadrado 5 blue (500,500)

imagens :: [Figura]
imagens = [circ1,quad1]

figuraToPicture :: Figura -> Picture 
figuraToPicture (Quadrado l c (coluna,linha)) = Translate (fromIntegral coluna) (fromIntegral linha) $ Color c $ rectangleSolid (fromIntegral l)  (fromIntegral l)
figuraToPicture (Circulo r c (coluna,linha)) = Translate (fromIntegral coluna) (fromIntegral linha) $ Color c $ Circle (fromIntegral r)

figurasToPicture :: [Figura] -> Picture
figurasToPicture l = Pictures $ map figuraToPicture l

aumentaFigura :: Figura -> Figura
aumentaFigura (Quadrado l c centro) = Quadrado (l+10) c centro
aumentaFigura (Circulo r c centro) = Circulo (r+10) c centro
decrementaFigura (Quadrado l c (coluna,linha)) = Quadrado (l-10) c (coluna,linha)
decrementaFigura (Circulo r c (coluna,linha)) = Circulo (r-10) c (coluna,linha)

deslizaDireita :: Figura -> Figura
deslizaDireita (Quadrado l c (coluna,linha)) =Quadrado l c (coluna +30,linha)
deslizaDireita (Circulo r c (coluna,linha)) =Circulo r c (coluna+30,linha)

deslizaEsquerda :: Figura -> Figura
deslizaEsquerda (Quadrado l c (coluna,linha)) =Quadrado l c (coluna-30,linha)
deslizaEsquerda (Circulo r c (coluna,linha)) =Circulo r c (coluna-30,linha)

deslizaCima :: Figura -> Figura
deslizaCima (Quadrado l c (coluna,linha)) =Quadrado l c (coluna,linha+30)
deslizaCima (Circulo r c (coluna,linha)) =Circulo r c (coluna,linha+30)

deslizaBaixo :: Figura -> Figura
deslizaBaixo (Quadrado l c (coluna,linha)) =Quadrado l c (coluna,linha-30)
deslizaBaixo (Circulo r c (coluna,linha)) =Circulo r c (coluna,linha-30)

reageTecla :: Event -> [Figura] -> [Figura]
reageTecla (EventKey (Char '+') Down _ _) e = map aumentaFigura e
reageTecla (EventKey (Char '-') Down _ _) e = map decrementaFigura e
reageTecla (EventKey (SpecialKey KeyRight) Down _ _) e = map deslizaDireita e
reageTecla (EventKey (SpecialKey KeyDown) Down _ _) e = map deslizaBaixo e
reageTecla (EventKey (SpecialKey KeyUp) Down _ _) e = map deslizaCima e
reageTecla (EventKey (SpecialKey KeyLeft) Down _ _) e = map deslizaEsquerda e
reageTecla _ e = e
data Figura 
    = Quadrado Int Color (Int,Int)
    | Circulo Int Color (Int,Int)
main = 
    play 
    janela
    corFundo
    500
    imagens 
    figurasToPicture 
    reageTecla 
    (\_ e -> e) -- para compilar tem de haver o modulo main e a função main
    
    
    
    
    
    manter a imagem de fundo em todos os movimentos
    ha escessao de quando alteras caixas 
    o estado inicial é um (Jogo,Picture,Picture) altera-se as pictures quando pega e larga caixa
    atualiza o jogo no resto
    tem 2 imagens colocar o mapa e procurar onde está o jogador e colucar com ou sem caixa
    
    figurasToPicture :: (Jogo,Picture,Picture) -> Picture
figurasToPicture l = Pictures $ map figuraToPicture l
    
