from Graph import Graph
from nodo import Node


def main():

    #Criar instância de grafo
    g = Graph()

    #Adicionar vertices ao grafo g
    #g.add_edge("s", "e",2)
    #g.add_edge("s", "a",2)
    #g.add_edge("e", "f",5)
    #g.add_edge("a", "b",2)
    #g.add_edge("b", "c", 2)
    #g.add_edge("c", "d", 3)
    #g.add_edge("d", "t",3)
    #g.add_edge("g", "t", 2)
    #g.add_edge("f","g",2)

    

    # g.add_edge("Elvas", "Alandroal",40)
    # g.add_edge("Elvas", "Arrailos",50)
    # g.add_edge("Elvas", "Borba",15)
    # g.add_edge("Arrailos", "Alcacer",25)
    # g.add_edge("Alandroal", "Redondo",25)
    # g.add_edge("Redondo", "Monsaraz",30)
    # g.add_edge("Monsaraz", "Barreiro",120)
    # g.add_edge("Barreiro", "Baixa da Banheira",5)
    # g.add_edge("Barreiro", "Palmela",25)
    # g.add_edge("Alcacer", "Palmela",35)
    # g.add_edge("Palmela", "Almada",25)
    # g.add_edge("Baixa da Banheira", "Moita",7)
    # g.add_edge("Moita", "Alcochete",20)
    # g.add_edge("Alcochete", "Lisboa",20)
    # g.add_edge("Almada", "Lisboa",15)
    # g.add_edge("Vendas Novas", "Lisboa",50)
    # g.add_edge("Montemor", "Vendas Novas",15)
    # g.add_edge("Evora", "Montemor",20)
    # g.add_edge("Estremoz", "Evora",40)
    # g.add_edge("Borba", "Estremoz",15)

    # g.add_heuristica("Elvas",270)
    # g.add_heuristica("Arrailos",220)
    # g.add_heuristica("Alandroal",180)
    # g.add_heuristica("Redondo",170)
    # g.add_heuristica("Monsaraz",120)
    # g.add_heuristica("Barreiro",30)
    # g.add_heuristica("Alcacer",140)
    # g.add_heuristica("Palmela",85)
    # g.add_heuristica("Baixa da Banheira",33)
    # g.add_heuristica("Moita",35)
    # g.add_heuristica("Alcochete",26)
    # g.add_heuristica("Almada",25)
    # g.add_heuristica("Vendas Novas",45)
    # g.add_heuristica("Montemor",70)
    # g.add_heuristica("Evora",95)
    # g.add_heuristica("Estremoz",145)
    # g.add_heuristica("Borba",250)
    # g.add_heuristica("Lisboa",0)

    


    #cosntrução de menu
    saida = -1
    while saida != 0:
        print("1-Imprimir Grafo")
        print("2-Desenhar Grafo")
        print("3-Imprimir  nodos de Grafo")
        print("4-Imprimir arestas de Grafo")
        print("5-DFS")
        print("6-BFS")
        print("7-Golosa")
        print("8-A*")
        print("0-Saír")

        saida = int(input("introduza a sua opcao-> "))
        if saida == 0:
            print("saindo.......")
        elif saida == 1:
            #Escrever o grafo como string
            print(g)
            l=input("prima enter para continuar")
        elif saida == 2:
            #Desenhar o grafo de forma gráfica
            g.desenha()
        elif saida == 3:
            #Imprimir as chaves do dicionario que representa o grafo
            print(g.m_graph.keys())
            l = input("prima enter para continuar")
        elif saida == 4:
            #imprimir todas as arestas do grafo
            print(g.imprime_aresta())
            l = input("prima enter para continuar")
        elif saida == 5:
            #Efetuar  pesquisa de caminho entre nodo inicial e final com DFS
            inicio=input("Nodo inicial->")
            fim = input("Nodo final->")
            print(g.procura_DFS( inicio, fim, path=[], visited=set()))
            l = input("prima enter para continuar")

        elif saida == 6:
            #Efetuar  pesquisa de caminho entre nodo inicial e final com DFS
            inicio=input("Nodo inicial->")
            fim = input("Nodo final->")
            print(g.procura_BFS(inicio, fim))
            l = input("prima enter para continuar")
        elif saida == 7:
            #Efetuar  pesquisa de caminho entre nodo inicial e final com DFS
            inicio=input("Nodo inicial->")
            fim = input("Nodo final->")
            print(g.greedy(inicio, fim))
            l = input("prima enter para continuar")
        elif saida == 8:
            #Efetuar  pesquisa de caminho entre nodo inicial e final com DFS
            inicio=input("Nodo inicial->")
            fim = input("Nodo final->")
            print(g.procura_aStar(inicio, fim))
            l = input("prima enter para continuar")
        else:
            print("Opção inválida...")
            l = input("prima enter para continuar")



if __name__ == "__main__":
    main()