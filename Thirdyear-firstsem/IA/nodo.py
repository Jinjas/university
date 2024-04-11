class Node:
    def __init__(self,name):
        self.m_name = str(name)

    def __str__(self):
        return "node"+self.m_name
    
    def getname(self):
        return self.m_name
    
    def setname(self,name):
        self.m_name = str(name)

    def __eq__(self, other) -> bool:
        return self.m_name == other.m_name

    def __hash__(self) -> int:
        pass