import graphcommon;# import GraphAdj;

V = 7
edges = [[0,1],[0,2],[1,3],[2,3],[2,4],[2,5],[3,6],[0,6]]


graphAdj = graphcommon.GraphAdj(V, edges, False)
graphMat = graphcommon.GraphMat(V, edges, False)

def bfsMat(mat,  root):

    res = []
    if len(mat) == 0:
        return res;

    visited = [False] * len(mat);

    q = []

    q.append(root)
    visited[root] = True;

    while q:
        n = len(q)

        while n:

            curr = q.pop(0)
            res.append(curr);

            edges = mat[curr]
            for i in range(len(edges)):
                if mat[curr][i] == 1 and visited[i] == False:
                    q.append(i);
                    visited[i] = True;
            
            n-=1
    print(res);

def bfsAdj(adj,  root):

    res = []
    if len(adj) == 0:
        return res;

    visited = [False] * len(adj);

    q = []

    q.append(root)
    visited[root] = True;

    while q:
        n = len(q)

        while n:

            curr = q.pop(0)
            res.append(curr);

            for edge in adj[curr]:
                if visited[edge] == False:
                    q.append(edge);
                    visited[edge] = True;
            

            n-=1
    print(res);

bfsAdj(graphAdj.adjLst, 2);
bfsMat(graphMat.adjMat, 2);



     