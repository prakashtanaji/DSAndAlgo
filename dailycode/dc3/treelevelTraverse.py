class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    def print(self):
        print(self.val)

def levelTraverse(root):
    q = []
    q.append(root);

    lvlCount = 0;
    while q:
        lvlCount = len(q);
        while lvlCount>0:
            curr = q.pop(0);
            curr.print();
            if curr.left:
                q.append(curr.left);
            if curr.right:
                q.append(curr.right);
            lvlCount -= 1;

# The most effient way is to use two queues, one for current level and one for next level. When the current level queue is empty, we know we are done with that level and can swap the queues and increment the level count.
if __name__ == "__main__":
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    #root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)
    levelTraverse(root);