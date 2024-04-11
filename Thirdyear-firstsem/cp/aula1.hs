import Data.List


mylength :: [a] -> Int
mylength [] = 0
mylength (x:xs) = 1 + mylength xs

myreverse :: [a] -> [a]
myreverse [] = []
myreverse (x:xs) = (myreverse xs) ++[x]

splitl :: [a] -> [a]
splitl [] = []
splitl [a] = [a]
splitl (x:xs) = (x : splitl (init xs))

splitr :: [a] -> [a]
splitr [] = []
splitr [a] = []
splitr (x:xs) = (splitr(init xs)) ++ [last xs]

curry :: ((a,b) -> c) -> a -> b -> c
curry f a b = f (a,b)

uncurry :: ( a -> b -> c ) -> (a,b) -> c
uncurry f (a,b) = f a b

flip :: (a -> b -> c) -> b -> a -> c
flip f b a = f a b


store c =  (c:) . take 10 . nub 