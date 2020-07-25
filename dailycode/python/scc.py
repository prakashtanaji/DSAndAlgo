maxlink = 1


def dfs(prelink, currlink, st, onst, links, res, g) -> (int) :
    global maxlink
    
    if links[currlink] == -1:
        print(maxlink)
        links[currlink] = maxlink
        maxlink += 1
        st.append(currlink)
        onst.add(currlink)

        newlink = 0 
        newlink = currlink
        for ed in g.getedges(currlink):
            dfslink:int = dfs(currlink, ed, st, onst, links, res, g)
            print(newlink, dfslink)
            newlink = min(dfslink, newlink)

        if newlink == currlink:
            nlist = []
            while st[-1] != currlink:
                curr = st.pop()
                nlist.append(curr)
                onst.remove(curr)
            
            curr = st.pop()
            nlist.append(curr)
            onst.remove(curr)

            res.append(nlist)

            return prelink
        else:
            return newlink
    elif currlink not in onst :
        return prelink
    else: # this is hitting the cycle
        return currlink


class Graph:
    vsize = 0
    edges = [[]]

    def __init__(self, sz):
        self.vsize = sz
        self.edges = [[] for v in range(sz)]
        print(self.edges)

    def getedges(self, v):
        print("rek forv ", v)
        return self.edges[v]
    def addedge(self, v, e):
        self.edges[v].append(e)

v = 7
g = Graph(v)
g.addedge(0,1)
g.addedge(1,2)
g.addedge(2,0)
g.addedge(0,3)
g.addedge(3,4)
g.addedge(4,5)
g.addedge(5,3)
g.addedge(6,3)
g.addedge(0,6)
g.addedge(5,6)



#for i in range(6):
print([g.getedges(i) for i in range(v)])

links = [-1 for i in range(v)]
#maxlink = 1
onst = set()
st = []
res =[[]]
start = 0


dfs(-1, start, st, onst, links, res, g )

print(res)
