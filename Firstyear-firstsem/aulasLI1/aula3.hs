
module Master where

type Nome = String
type Coordenada = (Int, Int)
data Movimento= N | S | E | W deriving (Show,Eq) -- norte, sul, este, oeste
type Movimentos = [Movimento]
data PosicaoPessoa = Pos Nome Coordenada deriving (Show,Eq)


instance Ord PosicaoPessoa where
    compare (Pos n1 (x1 ,y1)) (Pos n2 (x2 ,y2)) = compare y2 y1 
--a

posicao :: PosicaoPessoa -> Movimentos -> PosicaoPessoa
posicao pp [] = pp
posicao (Pos name (x,y)) (h:t)
    | h == E = posicao (Pos name (x + 1 , y)) t
    | h == W = posicao (Pos name (x - 1 , y)) t
    | h == N = posicao (Pos name (x , y + 1)) t
    | otherwise = posicao (Pos name (x , y - 1)) t
    
--b

posicoesM :: [PosicaoPessoa] -> Movimento -> [PosicaoPessoa]
posicoesM [] _ = [] 
posicoesM ((Pos name (x , y)) : t) E = (Pos name (x + 1 , y)) : posicoesM t E
posicoesM ((Pos name (x , y)) : t) W = (Pos name (x - 1 , y)) : posicoesM t W
posicoesM ((Pos name (x , y)) : t) N = (Pos name (x , y + 1)) : posicoesM t N
posicoesM ((Pos name (x , y)) : t) S = (Pos name (x , y - 1)) : posicoesM t S

--c

posicoesMs :: [PosicaoPessoa] -> Movimentos -> [PosicaoPessoa]
posicoesMs [] m = []
posiçoesMS (h : t) m = (posicao h m : (posicoesMs t m)) 

--d

pessoasNorte :: [PosicaoPessoa] -> [Nome]

pessoasNorte (Pos n ())) = obtemNome pessoasNorte ps

obtemNome :: [PosicaoPessoa] -> [Nome]
obtemNome []= []
obtemNome ((Pos name x) : t) = name : (obtemNome t)

