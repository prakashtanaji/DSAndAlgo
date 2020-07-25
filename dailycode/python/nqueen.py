import sys

def printmat(mat) :
    print()
    for i in range(len(mat)) :
        print(mat[i])

def proceed(mat, currcol, n) :
    currcol = currcol +1
    if currcol < n:
        mat[0][currcol] = 1
    # print("proceed is ")
    # printmat(mat)
    return currcol

def back(mat, currrow, currcol, n):
    
    if currrow != n-1:
        mat[currrow][currcol] = 0
        mat[currrow+1][currcol] = 1
        # printmat(mat)
        return (currrow + 1, currcol)
    else:
        pos1 = get1pos(mat, currcol, n)
        while pos1 != None and pos1 == n-1:
            mat[pos1][currcol] = 0
            currcol-=1
            pos1 = get1pos(mat, currcol, n)
        if pos1 == None:
             return None, None
        mat[pos1][currcol] = 0
        mat[pos1+1][currcol] = 1
        # printmat(mat)
        return pos1+1, currcol

def get1pos(mat, col, n) :
    if col <0: return None
    for i in range(n):
        if mat[i][col] == 1:
            return i

    return None

def solve(n):
    res = [[]]
    res = [[0 for i in range(n)] for j in range(n)]

    # print (res)

    res[0][0] = 1

    row,col = 0,0 
    # pcol = col
    while col < n:
        # pcol = col
        if isOk(res, row, col, n) == True:
            col = proceed(res, col, n)
            row = 0
        else :
            row, col = back(res, row, col, n)
        
        if col == None : break
        # if pcol != col:
        #     print("progress")
    return res, col


def isOk(mat, row , col, n) :
    for i in range(n) :
        if mat[i][col] == 1 and i != row: return False
    if col != 0 :
        for i in range(col-1, -1, -1):
            if mat[row][i] == 1: return False
        i,j = row-1,col-1
        while i>-1 and j > -1 :
            if mat[i][j] == 1: return False
            i-=1
            j-=1
        i,j = row+1,col-1
        while i<n and j > -1 :
            if mat[i][j] == 1: return False
            i+=1
            j-=1
            
    return True

n = int(sys.argv[1])
mat, res = solve(n)

print("result is ", res)
if res is not None :
    for i in range(n) :
        print(mat[i])

