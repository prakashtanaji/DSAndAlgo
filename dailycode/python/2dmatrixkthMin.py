from collections import deque

class Cell :
    def __init__(self,_x,_y):
        self.x,self.y = _x,_y

mat = [[1,3,5,6],
    [2,5,6,11],
    [5,7,10,12],
    [13,14,15,16]]

def kthMin(mat, k):
    m = len(mat) 
    n = len(mat[0])
    
    if m * n < k: return -1
    
    pq = deque()

    for i in range(m) :
        pq.append(Cell(i, 0))
    
    curr = -1
    i = 0
    while True :
        curr = pq.popleft()

        i+=1

        if i == k: break

        if curr.y + 1 < n :
            pq.append(Cell(curr.x, curr.y + 1))

    return mat[curr.x][curr.y]

k = 10
print("{}th element is {}".format(k, kthMin(mat, k)))



    