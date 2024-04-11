
import math 
from queue import Queue
import networkx as nx
import matplotlib.pyplot as plt
from nodo import Node

class Graph:
    def __init__ (self,directed = False):
        self.m_nodes = []
        self.m_derected = directed
        self.m_graph = {}
        self.m_h = {}

    def __str__(self):
        out = ""
        for key in self.m_graph.keys():
            out = out +"node" + str(key) + ":" + str(self.m_graph[key]) + "\n"
        return out
        
    def get_node_by_name(self, name):
        search_node = Node(name)
        for node in self.m_nodes:
            if node == search_node:
                return node
            else:
                return None

    def imprime_aresta (self):
        listaA= ""
        lista = self.m_graph.keys()
        for nodo in lista:
            for (nodo2,custo) in self.m_graph[nodo]:
                listaA= listaA + nodo


    def add_edge (self,node1,node2,weight):
        n1 = Node(node1)
        n2 = Node(node2)
        if (n1 not in self.m_nodes):
            self.m_nodes.append (n1)
            self.m_graph[node1] = set()
        else: n1 = self.get_node_by_name (node1)

        if (n2 not in self.m_nodes):
            self.m_nodes.append (n2)
            self.m_graph[node2] = set()
        else: n2 = self.get_node_by_name (node2)

        self.m_graph[node1].add((node2,weight))
        

        if not self.m_derected:
            self.m_graph[node2].add((node1,weight))


    def getNodes (self):
        return self.m_nodes
    
    def get_arc_cost(self, node1,node2):
        custoT = math.inf
        a = self.m_graph[node1]
        for (nodo,custo) in a:
            if nodo == node2:
                custoT = custo
        return custoT



    def getNeighbors(self, nodo):
        lista = []
        for (adjacente,custo) in self.m_graph[nodo]:
            lista.append((adjacente,custo))
        return lista


    def desenha ( self):
        lista_v = self.m_nodes
        lista_a = []
        g = nx.Graph()

        for nodo in lista_v:
            n = nodo.getname()
            g.add_node(n)
            for(adjacente,peso) in self.m_graph[n]:
                lista = (n,adjacente)
                g.add_edge(n,adjacente,weight=peso)
            
        pos = nx.spring_layout(g)
        nx.draw_networkx(g, pos, with_labels=True, font_weight='bold')
        labels = nx.get_edge_attributes(g, 'weight')
        nx.draw_networkx_edge_labels(g, pos, edge_labels=labels)

        plt.draw()
        plt.show()



    def addnode(self,node):
        self.m_nodes.append(node)
        self.m_graph[node] = []


    def calcula_custo (self,path):
        teste=path
        custo=0
        i=0
        while i+1 < len(teste):
             custo=custo + self.get_arc_cost(teste[i], teste[i+1])
             i=i+1
        return custo

    def procura_DFS(self,start,end,path=[],visited=set()):
        path.append(start)
        visited.add(start)
        if start == end:
            custoT=self.calcula_custo(path)
            return (path,custoT)
        for (adjacente,peso) in self.m_graph[start]:
            if adjacente not in visited:
                resultado = self.procura_DFS(adjacente,end,path,visited)
                if resultado is not None:
                    return resultado
        path.pop()
        return None

    def procura_BFS(self,start,end):
        visited = set()
        queue = Queue()

        queue.put(start)
        visited.add(start)
        parent = {}
        parent[start] = start
        path_found = False
        while not queue.empty() and path_found ==False:
            nodo_atual = queue.get()
            if nodo_atual == end:
                path_found = True
            else:
                for(adjacente,peso) in self.m_graph[nodo_atual]:
                    if adjacente not in visited:
                        queue.put(adjacente)
                        parent[adjacente] = nodo_atual
                        visited.add(adjacente)
        if path_found:
            reconst_path = []
            while parent[nodo_atual] != nodo_atual:
                reconst_path.append(nodo_atual)
                nodo_atual = parent[nodo_atual]
            reconst_path.append(start)
            reconst_path.reverse()
            return(reconst_path, self.calcula_custo(reconst_path))
    
    def add_heuristica(self,n,estima):
        n1=Node(n)
        if n1 in self.m_nodes:
            self.m_h[n] = estima

    def greedy(self,start, end):
        open_list = set([start])
        closed_list = set([])
        
        #para devolver o caminho
        parents = {}
        parents[start] = start

        while len(open_list) > 0:
            n = None
            #escolha do proximo nodo a verificar    
            for v in open_list:
                if n == None or self.m_h[v] < self.m_h[n]:
                    n = [v]
            
            if n == None:
                print("path does not exist")
                return None

             #devolucao da path final   
            if n == end:
                reconst_path = []
                while parents[n] != n:
                    reconst_path.append(n)
                    n = parents[n]
                reconst_path.append(start)
                reconst_path.reverse()
                return(reconst_path, self.calcula_custo(reconst_path))

            for (adjacente,peso) in self.getNeighbors(n):
                if adjacente not in open_list and adjacente not in closed_list:
                    open_list.add(adjacente)
                    parents[adjacente] = n

            open_list.remove(n)
            closed_list.add(n)


    def procura_aStar(self,start, end):
        open_list = set([start])
        closed_list = set([])
        
        #para devolver o caminho
        g = {}
        g[start] = 0

        parents = {}
        parents[start] = start

        while len(open_list) > 0:
            n = None
            #escolha do proximo nodo a verificar    
            for v in open_list:
                if n == None or g[v] + self.m_h[v] < g[n] + self.m_h[n]:
                    n = [v]
            
            if n == None:
                print("path does not exist")
                return None

             #devolucao da path final   
            if n == end:
                reconst_path = []
                while parents[n] != n:
                    reconst_path.append(n)
                    n = parents[n]
                reconst_path.append(start)
                reconst_path.reverse()
                return(reconst_path, self.calcula_custo(reconst_path))

            for (m,weight) in self.getNeighbors(n):
                if m not in open_list and m not in closed_list:
                    open_list.add(m)
                    parents[m] = n
                    g[m] = g[n] + weight
                else:
                    if g[m] > g[n] + weight:
                        g[m] = g[n] + weight
                        parents[m] = n

                        if m in closed_list:
                            closed_list.remove(m)
                            open_list.add(m)

            open_list.remove(n)
            closed_list.add(n)
