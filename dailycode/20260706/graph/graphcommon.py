class GraphAdj:
    
    def __init__(self, V, edges, isUni):
        self.V = V
        self.adjLst = [[] for _ in range(V)]

        if isUni:
            for edge in edges:
                self.adjLst[edge[0]].append(edge[1])
        else:
            for edge in edges:
                self.adjLst[edge[0]].append(edge[1])
                self.adjLst[edge[1]].append(edge[0])

class GraphMat:
    
        def __init__(self, V, edges, isUni):
            self.adjMat = [[0 for _ in range(V)] for _ in range(V)]

            if isUni:
                for edge in edges:
                    self.adjMat[edge[0]][edge[1]] = 1
            else:
                for edge in edges:
                    self.adjMat[edge[0]][edge[1]] = 1
                    self.adjMat[edge[1]][edge[0]] = 1