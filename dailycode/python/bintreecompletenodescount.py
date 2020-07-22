# give  a binary tree which is complete, find the number of nodes
import queue
def treeSz(root):
    curr = root
    sz = 1
    while True :
        if curr.left == None: break
        curr = curr.left
        sz +=1
    return sz

class Node:
    val = 0
    left = None
    right = None
    def __init__(self, _val):
        self.val = _val
        self.left = None
        self.right = None

    def print(self):
        q = queue.Queue()
        q.put(self)
        sz = q.qsize()

        while not q.empty() :
            size = q.qsize()
            while size > 0 :
                curr = q.get()
                print(curr.val, end="  ")
                if curr.left:
                    q.put(curr.left)
                if curr.right:
                    q.put(curr.right)
                size-=1
            print()


def populateTree() :
    root = Node(1)
    root.left = Node(2)
    #root.right = Node(3)

    return root

root = populateTree()

def findCount(root) :
    root.print()

    print("size is {}".format(treeSz(root)))

    least = (2 ** treeSz(root)) // 2
    highest = 2 ** treeSz(root) - 1
    print(least, highest)

    while least < highest :
        mid = (least + highest) // 2
        pathI = mid

        st = []
        while pathI >1:
            st.append(pathI%2)
            pathI = pathI //2
        
        curr = root
        loor = 0
        while len(st):
            lorr = int(st.pop())
            if loor == 0:
                curr = curr.right
            else :
                curr = curr.left
        
        if curr == None:
            highest = mid
        else :
            least = mid +1
    
    return least;


print("size of tree is ", findCount(root))
