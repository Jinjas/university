ramdomIO :: Random a => IO a
ramdomRIO :: Random a => (a,a) -> IO a

bingo :: IO()
bingo = do l <- geralista []
           putStr (show l)
geralista :: [Int]-> IO [Int]
geralista xs | length xs == 90 = return xs
             | otehrwise = do x<- ramdomRIO(1,90)
                              let n =if elemx xs then xs else x : xs
                              geralista n

--b)
masterminal :: IO()
masterminal = do l <- geralista
                 putStr "digitos gerados"
                 putStr "tente adivinhar"
                 lu <- geraLista u
                 let lp = zip lu l
                     posCerta = length [ fst x | x <-lp,fst x == snd x]
                     posErrada = lenth[fst x | x<-lp,elemfst x l,fst x /= snd x]
                 putStr ("o nymero de digitos certos é" ++ show posCerta)
                 putStr ("o nymero de digitos errados é" ++ show posErrado)