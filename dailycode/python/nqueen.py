
def proceed(mat, currcol, n) :
    currcol = currcol +1
    if currcol < n:
        mat[currcol][0] = 1
    return currcol

def back(mat, currrow, currcol, n):
    mat[currrow][currcol] = 0
    if currcol != n-1:
        mat[currrow+1][currcol] = 1
        return (currrow + 1, currcol)
    else:
        pos1 = get1pos(mat, currcol, n)
        while pos1 != None and pos1 != n-1:
            mat[pos1][currcol] = 0
            currcol-=1
            pos1 = get1pos(mat, currcol, n)
        if pos1 == None:
             return None, None
        mat[pos1][currcol] = 0
        mat[pos1+1][currcol] = 1

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

    print (res)

    res[0][0] = 1

    row,col = 0,0 
    while col < n:
        if isOk(res, row, col) == True:
            col = proceed(res, col, n)
        else :
            row, col = back(res, row, col, n)
        
        if col == None : break

    return res, col


def isOk(mat, row , col, n) :
    for i in range(n) :
        if mat[i][col] == 1 and i != row: return False
    if col != 0 :
        for i in range(col-1, -1, -1):
            if mat[row][i] == 1: return False
    return True

mat, res = solve(4)

print("result is ", res)
if res is not None :
    print(res)