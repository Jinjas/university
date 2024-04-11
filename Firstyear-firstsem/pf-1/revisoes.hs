module Revisoes where
import Data.Char

intersect :: Eq a => [a] -> [a] -> [a]
--intersect [1,1,2,3,4] [1,3,5]==[1,1,3]
intersect [] _ = []
intersect (x:s) l | elem x l = x : intersect s l
                  | otherwise = intersect s l

-- 1:1:3:[]
tails :: [a] -> [[a]]
--tails [1,2,3] == [[1,2,3],[2,3],[3],[]]
tails [] = [[]]
tails l = l : tails (tail l)
--[1,2,3]:[2,3]:[3]:[[]]

type ConjInt = [Intervalo]
type Intervalo = (Int,Int)
--[1, 2, 3, 4, 7, 8, 19, 21, 22, 23] == [(1,4),(7,8),(19,19),(21,23)]
elems :: ConjInt -> [Int]
elems [] = []
elems ((min,max):s) | min == max = min : elems s
                    | otherwise = min: elems ((min+1,max):s)


geraconj :: [Int] -> ConjInt
geraconj [] = []
geraconj (h:s) = geraAux s (h , h)

geraAux :: [Int] -> Intervalo -> ConjInt
geraAux [] acc = [acc]
geraAux (x:s) (min,max) | x == (max + 1) = geraAux s (min,x)
                        | otherwise = (min,max) : (geraAux s (x , x))

data Contacto = Casa Integer
              | Trab Integer
              | Tlm Integer
              | Email String
     deriving (Show)
type Nome = String
type Agenda = [(Nome, [Contacto])]


acrescEmail :: Nome -> String -> Agenda -> Agenda
acrescEmail nome mail [] = [(nome,[Email mail])]
acrescEmail nome mail (h@(n,conts):s) |nome /= n = h: (acrescEmail nome mail s) 
                                      |otherwise = (n,conts ++[(Email mail)]) :s

verEmails :: Nome -> Agenda -> Maybe [String]
verEmails _ [] = Nothing
verEmails nome (h@(n,conts):s) | nome == n = Just (emails conts)
                               | otherwise = verEmails nome s
emails :: [Contacto] -> [String]
emails [] = []
emails (Email mail:s) = mail: emails s
emails (_:s) = emails s


consulta :: [Contacto] -> ([Integer],[String])
consulta l = foldl (\acc contacto -> insere contacto acc) ([],[]) l

insere :: Contacto -> ([Integer],[String]) -> ([Integer],[String])
insere (Casa a) (nums,mails) = (nums ++ [a],mails) 
insere (Trab a) (nums,mails) = (nums ++ [a],mails) 
insere (Tlm a)  (nums,mails) = (nums ++ [a],mails)
insere (Email a) (nums,mails) = (nums,mails ++ [a]) 

consultaIO :: Agenda -> IO ()
consultaIO a = do
         putStrLn "introduza o nome a procurar"
         nome <- getLine
         let (n,contactos) = head (filter (\n -> fst n == nome) a) 
         putStrLn (concat [show x ++ "\n" | x <- contactos])  

data RTree a = R a [RTree a] deriving (Show, Eq)
paths :: RTree a -> [[a]]
--paths r1 == [[1,2],[1,3,4,5],[1,3,4,6],[1,7]]
paths (R a []) = [[a]]
paths (R a l) =  concat $ map (\ x -> [a: nodes| nodes <- paths x]) l
r1 = (R 1 [R 2 [], R 3 [R 4 [R 5 [],R 6 []]],R 7 []])
unpaths :: Eq a => [[a]] -> RTree a
unpaths [[a]] = R a []
unpaths list = R n (unpaths' (map tail list))
        where n = head $ head list
       --   verif = all (\x -> head x == n) list
unpaths' :: Eq a => [[a]] -> [RTree a]
unpaths' [[a]] = [R a []]
unpaths' [[]] = []
unpaths' list | all (\x -> head x == n) list = [R n (unpaths' (map tail list))]
              | otherwise  = [R n (unpaths' (map tail (filter (\x -> head x == n)list)))]++(unpaths' (filter (\x -> head x /= n)list))
        where n = head $ head list

sortOnada :: Ord b => (a -> b) -> [a] -> [a]
sortOnada f [] = []
sortOnada f (x:s) = put f x (sortOnada f s)

put :: Ord b => (a -> b) -> a -> [a] -> [a]
put _ x [] =[x]
put f x (h:t) | f x <= f h = (x:h:t) 
              | otherwise = h:(put f x t)
