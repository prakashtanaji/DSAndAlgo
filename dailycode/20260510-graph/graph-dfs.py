import graphcommon;

V = 8
edges = [[0,1],[0,2],[1,3],[2,3],[2,4],[2,5],[3,6],[0,6],[5,7],[1,7],[0,7]]


graphAdj = graphcommon.GraphAdj(V, edges, True)
graphMat = graphcommon.GraphMat(V, edges, True)


