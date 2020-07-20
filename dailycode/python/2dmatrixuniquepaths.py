# This variation of problem is little more involved where in we can move from curr cell to any cell in four directions

n = 6

print(n)
matPaths = [[0 for i in range(n)] for j in range(n)]
matVisited = [[-1 for i in range(n)] for j in range(n)]

nexts = [[0,-1],[0,1],[1,0],[-1,0]]
print(matPaths)

class Cell:
    # x,y=0,0
    def __init__(self, _x, _y):
        self.x=_x
        self.y=_y

def getNext (currCell, matVisited) :
    adjs = []
    for adj in nexts:
        nextX = currCell.x+adj[0]
        nextY = currCell.y+adj[1]
        if nextX >=0 and \
            nextX < n and nextY >=0 and \
            nextY < n  and \
            matVisited[nextX][nextY] == -1:
            adjs.append(Cell(nextX, nextY))
    return adjs

def recurse(currCell, matPaths, matVisited) :
    if currCell.x == n-1 and currCell.y == n-1 : return 1
    # if matPaths[currCell.x][currCell.y] !=0 : return matPaths[currCell.x][currCell.y]
    count = 0
    for adj in getNext(currCell, matVisited) :
        matVisited[adj.x][adj.y] = 1
        count += recurse(Cell(adj.x, adj.y), matPaths, matVisited)
        matVisited[adj.x][adj.y] = -1
    #matPaths[currCell.x][currCell.y] = count

    return count


matVisited[0][0] = 1
print("No of unique paths ", recurse(Cell(0,0), matPaths, matVisited))

## If can only traverse bottom or right then we need to approach in a diffrent simplified memoization solution
# mat = [[0 for i in range(n)] for j in range(n)]
# for i in range(n):
#     mat[0][i] = 1
# for i in range(n):
#     mat[i][0] = 1
# for i in range(1, n):
#     for j in range(1, n):
#         mat[i][j] = mat[i-1][j] + mat[i][j-1]
# print(mat[n-1][n-1])