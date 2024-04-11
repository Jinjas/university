import Data.Char 
import System.Random
import Data.List
import Data.Maybe

parposiElem :: [Int] -> [(Int,Int)]
parposiElem l = map (\ n -> (fromJust(elemIndex n l ),n)) l

type MSet a = [(a,Int)]

calcula :: MSet a -> ([a],Int)
calcula l = foldl (\acc c -> ((fst acc) ++ [fst c],(snd acc) + (snd c) )) ([],0) l

removeMSet :: Eq a => a -> [(a,Int)] -> [(a,Int)]
removeMSet coisa [] = []
removeMSet coisa ((isso,n):t) | coisa == isso && n /= 1 = ((isso,n-1) : t )
                              | coisa == isso = t
                              |otherwise = (isso,n) : removeMSet coisa t
--removeMSet 'c' [('b',2), ('a',4), ('c',1)] == [('b',2), ('a',4)]



a1 = Node 5 (Node 3 Empty
                    Empty)
            (Node 7 Empty 
                    (Node 9 Empty 
                            Empty))
--"((* <-3-> *) <-5-> (* <-7-> (* <-9-> *)))"
remove :: Ord a => a -> BTree a -> BTree a
remove a Empty = Empty
remove a (Node b Empty r) | a == b = r
remove a (Node b l Empty) | a == b = l
remove a (Node b l r) | a < b = Node b (remove a l) r
                      | a > b = Node b l (remove a r)
                      | otherwise  = constructor l r             --a==b &&  l && r /= Empty

constructor :: Ord a => BTree a -> BTree a -> BTree a
constructor (Node a l1 Empty) maiores = Node a l1 maiores
constructor (Node a l1 r1) maiores =  Node a l1 (constructor r1 maiores)

instance Show a => Show (BTree a) where 
    show bt = ver bt
     
ver :: Show a => BTree a -> String
ver Empty = "*"
ver (Node a l r) = "(" ++ ver l ++ " <-" ++ show a ++ "-> " ++ ver r ++ ")" 

type Mat a = [[a]]
--1
--a)
--elemIndices :: Eq a => a -> [a] -> [Int]
--elemIndices x l = elemIndices' x l  0

data FileSystem = File Nome | Dir Nome [FileSystem]
type Nome = String



fichs :: FileSystem -> [Nome]
fichs (File x) = [x]
fichs (Dir x []) = []
fichs (Dir x l) = concatMap fichs l


dirFiles :: FileSystem -> [Nome] -> Maybe [Nome]
--dirFiles fs1 ["usr","xxx"] == Just ["abc.txt","readme"]
dirFiles fs [] = Just (fichs fs)
dirFiles (File x) (z:y) = Nothing
dirFiles (Dir x l) (h:s) | x == h = dirfilesAux l s
                         | otherwise = Nothing

dirfilesAux :: [FileSystem] -> [Nome] -> Maybe [Nome]
dirfilesAux [] (_:_) = Nothing
dirfilesAux l [] = Just (files l []) 
dirfilesAux (File x:s) (h1:s1) = dirfilesAux s (h1:s1)
dirfilesAux (Dir x l :s) (h1:s1) | x == h1 = dirfilesAux l s1
                                 | otherwise = dirfilesAux s (h1:s1)

files :: [FileSystem] -> [Nome]-> [Nome] 
files [] acc = acc
files ((File h):s) acc = files s (acc ++ [h])
files ((Dir h ls):s) acc = files s acc

partes :: String -> Char -> [String]
partes s c = filter (/= []) (partes' s c [])

partes' :: String -> Char -> String -> [String]
partes' [] c acc = [acc]
partes' (h:s) c acc | h == c = acc : (partes' s c [])
                    | otherwise = partes' s c (acc ++ [h])

--partes "um;bom;exemplo;" ’;’ == ["um","bom","exemplo"]
--partes "um;exemplo;qualquer" ’;’ == ["um","exemplo","qualquer"]


listaFich :: FileSystem -> IO ()
listaFich l = do
        putStrLn "indique uma path que queira seguir(por exemplo:usr/xxx/PF): "
        caminho <- getLine
        if (dirFiles l (partes caminho '/')) == Nothing then putStrLn "Não é uma directoria"
                                                        else putStrLn (unwords (fromJust (dirFiles l (partes caminho '/'))))


intToStr :: Int -> String
intToStr x  | x < 10 = [chr (x+48)]
            | otherwise = (intToStr (div(x-y)10)) ++ [chr (y+48)] 
        where y = (mod x 10)

--132 -> 2 3 1





elemIndices' ::  Eq a => a -> [a] -> Int -> [Int]
elemIndices' _ [] _ = []
elemIndices' x (h:t) acc | x == h = acc : elemIndices' x t (acc+1)
                         | otherwise = elemIndices' x t (acc+1)

--ou 
elemIndices'' :: Eq a => a -> [a] -> [Int]
elemIndices'' x [] = []
elemIndices'' x (h:t) | h == x = 0 : map (+1) (elemIndices'' x t)
                    | otherwise = map (+1) (elemIndices'' x t)

--b)
--isSubsequenceOf :: Eq a => [a] -> [a] -> Bool
--isSubsequenceOf [] _ = True
--isSubsequenceOf _ [] = False
--isSubsequenceOf (h:t) (hs:ts)| h == hs = isSubsequenceOf t ts
--                             | otherwise = isSubsequenceOf (h:t) ts

--2)
--a)
lookupAP :: Ord a => a -> BTree (a,b) -> Maybe b
lookupAP x Empty = Nothing
lookupAP x (Node (a,b) esq dir) | x == a = Just b
                                |x < a = lookupAP x esq
                                |otherwise = lookupAP x dir

--b)
arroz :: (a -> b -> c) -> BTree a -> BTree b -> BTree c
arroz f (Node x1 e1 d1) (Node x2 e2 d2) = Node (f x1 x2 ) (arroz f e1 e2 ) (arroz f d1 d2)
arroz _ _ _ = Empty

--3)----------------------------------------------------------------
digitAlpha :: String -> (String,String)
digitAlpha = foldr (\x (ds,as) -> if isDigit  x then ( x:ds , as) else if isAlpha x then (ds, x:as) else (ds,as)) ([],[])

--4)
--a)
data Seq a = Nil | Cons a (Seq a) | App (Seq a) (Seq a)
firstSeq :: Seq a -> a
firstSeq (Cons x _)= x
firstSeq (App Nil s) = firstSeq s
firstSeq (App s _) = firstSeq s
firstSeq Nil = error "arroz"

--b)
dropSeq :: Int -> Seq a -> Seq a
dropSeq _ Nil = Nil
dropSeq n (Cons _ s) = dropSeq (n-1) s
dropSeq n (App s1 s2) | n < contaCons s1 = App (dropSeq n s1) s2
                      | n == contaCons s1 = s2
                      | otherwise = dropSeq (n-contaCons s1) s2


contaCons :: Seq a -> Int
contaCons Nil = 0
contaCons (Cons _ s) = 1 + contaCons s
contaCons (App s1 s2) = contaCons s1 + contaCons s2

--c)
instance Show a => Show (Seq a) where
    show s = "<<"++ mostra s ++">>"

mostra ::Show a => Seq a -> String
mostra Nil = ""
mostra (Cons a Nil) = show a
mostra (Cons a s) = show a ++ "," ++ mostra s
mostra (App s1 Nil) = mostra s1
mostra (App s1 s2) = mostra s1 ++ "," ++ mostra s2
--5)--------------------------------------------------------------------------------------------------------------------------------------
--a)
getElem :: Mat a -> IO a
getElem mat = do
    getCol <- randomRIO (0,length (head mat) -1)
    getLin <- randomRIO (0,length mat-1)
    return ((mat !! getLin) !! getCol)

--b)----------------
magic :: Mat Int -> Bool
magic mat = sumLinhas valor mat && sumColunas valor mat && sumDiagonais valor mat
    where valor = sum (head mat)

sumLinhas :: Int -> Mat Int -> Bool
sumLinhas valor = foldl (\acc l -> sum l == valor && acc) True

sumColunas :: Int -> Mat Int -> Bool
sumColunas valor mat = foldl (\acc l -> sum (map (!! l) mat) ==  valor && acc) True [0..(length mat - 1)]

sumDiagonais :: Int -> Mat Int -> Bool
sumDiagonais valor mat = sum (map (\n -> (mat !! n) !! n) [0..(length mat - 1)]) == valor && sum (map (\n -> (mat !! n) !! (length mat - 1 - n)) [0..(length mat - 1)]) == valor






fs1 = Dir "usr" [Dir "xxx" [File "abc.txt", File "readme", Dir "PF" [File "exemplo.hs"]],
      Dir "yyy" [], Dir "zzz" [Dir "tmp" [], File "teste.c"] ]

--20/21 6b

readFiles :: [FileSystem] -> [Nome]
readFiles [] = []
readFiles (File x : fl) = x : readFiles fl
readFiles (_ : fl) = readFiles fl

data BTree a = Empty | Node a (BTree a) (BTree a) 

path :: [Bool] -> BTree a -> [a]
path [] Empty = []
path [] (Node x l r) = [x]
path _  Empty = []
path (h:t) (Node x l r) | h = x: (path t r)
                        | otherwise = x : (path t l)

{-
valor :: [Float] -> Float -> Float
valor l n =  sum (map (\x -> x* (locate' (locate l x) n)) l)

locate' :: Maybe Float -> Float -> Float
locate' (Just a) n =  n^ a
locate :: [a] -> Float -> Maybe a
locate [] _ = Nothing
locate (h:t) 0 = Just h
locate (h:t) x = locate t (x-1) 
-}