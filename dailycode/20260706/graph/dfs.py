import graphcommon;

V = 5
edges = [[0,1],[0,2],[1,2],[2,3],[4,3]]

graphAdj = graphcommon.GraphAdj(V, edges, True)
print(graphAdj.adjLst)

def dfsAdj(adj : graphcommon.GraphAdj):
    res = []
    st = []
    visited = [False] * adj.V

    i = 0

    print("entering disconn loops")
    while i< adj.V: # To handle for disconnected graphs
        if visited[i] == True:
            i+=1
            continue;
        # res.append(i)
        # visited[i] = True

        st.append(i)

        print("entering loop for node:", i)
        while st:
            s = st.pop()
            if visited[s] == False:
                visited[s] = True
                res.append(s)
                print (res)
                print("entering for loop for node:", s)
                print("Edges " , adj.adjLst[s])

                for edges in adj.adjLst[s]:
                    if visited[edges] == False:
                        st.append(edges)
        i += 1

    return res


result = dfsAdj(graphAdj)
print(result)

