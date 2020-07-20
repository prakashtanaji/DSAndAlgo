#from collections import deque
import queue
import sys

#q = queue.PriorityQueue()

class MyPQ :
    def __init__(self, mat):
        self.pq = queue.PriorityQueue()
        self.mat = mat
    def add(self, cell) :
        self.pq.put((mat[cell[0]][cell[1]], cell))
    def remove(self):
        return self.pq.get()

mat = [[1,3,5,6],
    [2,5,6,11],
    [5,7,10,12],
    [13,14,16,16]]

def kthMin(mat, k):
    m = len(mat) 
    n = len(mat[0])
    
    if m * n < k: return -1
    
    pq = MyPQ(mat)

    for i in range(m) :
        pq.add([i, 0])

    print('test')
    print(pq)
    mat[0][0] = 1
    print(pq)
    
    global curr
    i = 0
    while True :
        curr = pq.remove()
        print(curr)

        i+=1

        if i == k: break

        if curr[1][1] + 1 < n :
            pq.add([curr[1][0], curr[1][1] + 1])

        print(pq)

    return mat[curr[1][0]][curr[1][1]]

k = int(sys.argv[1])
if k<1 : 
    print('enter valid value')
    exit()
print("{}th element is {}".format(k, kthMin(mat, k)))



    