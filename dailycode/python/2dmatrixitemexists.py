mat = [[1,3,5,6],
    [2,5,6,11],
    [5,7,10,12],
    [13,14,15,16]]

def isexists(mat, t) :
    y = len(mat[0])-1
    x = 0
    while x < len(mat) and y>0 :
        if mat[x][y] == t : return True
        if mat[x][y] > t: y-=1
        else : x+=1
            
    return False

t = -10
print("The target {}, {}".format(t, isexists(mat, t)))