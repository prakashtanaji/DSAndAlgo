import queue

class Node:
    val = 0
    left = 0
    right = 0

    def __init__(self, _val):
        self.val = _val
        self.left = None
        self.right = None

root = Node(1)
#root.val = 1
#root.left = Node(2)
#root.left.val = 2

root.right = Node(3)
#root.right.val = 3

#root.left.left = Node(4)
#root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)
root.right.left.left = Node(8)


def recurse(node, pos, dt):
    if node is None : return
    if dt.get(pos, None) == None:
        dt[pos] = node.val
    
    recurse(node.left, pos-1, dt)
    recurse(node.right, pos+1, dt)

def printfromdt(dt):
    kList = dt.keys()
    print(dt) , print(kList)
    kList = sorted(kList)
    print(kList)

    for k in kList:
        print (" ", dt.get(k), end = "")

def iterative(node) :
    q = queue.Queue()

    q.put((0,node))

    dt = dict()

    while q.qsize() > 0 :
        sz = q.qsize()

        while sz>0:
            n = q.get()
            if dt.get(n[0], None) is None:
                dt[int(n[0])] = n[1].val
            if n[1].left is not None:
                q.put((n[0]-1, n[1].left))
            if n[1].right is not None:
                q.put((n[0]+1, n[1].right))
            sz-=1
    return dt
    
print("Recursive")
dt = {}
recurse(root, 0, dt)
printfromdt(dt) 

print("Iterative")
dt = iterative(root)
printfromdt(dt) 