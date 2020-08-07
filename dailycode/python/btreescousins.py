import queue
import sys

class Node:
    val = 0
    left = 0
    right = 0

    def __init__(self, _val):
        self.val = _val
        self.left = None
        self.right = None

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)
root.right.left.left = Node(8)

def iterative(node, target) :
    #print(target)
    q = queue.Queue()
    foundNode = False

    q.put(node)

    while q.qsize() > 0 and foundNode ==  False:
        sz = q.qsize()

        while sz>0:
            n = q.get()
            sz-=1
            if n is None: continue

            if n.left is not None and n.left.val == target:
                foundNode = True
                continue
            if n.right is not None and n.right.val == target:
                foundNode = True
                continue
            
            q.put(n.left)
            q.put(n.right)
            
    return q
    # if foundNode : return q
    # else : return None

print("Iterative")
q = iterative(root, int(sys.argv[1]))
def printQ(q):
    while q.qsize() >0:
        curr = q.get()
        if curr is None: continue
        print(curr.val)
printQ(q)