def bstMax(root):
    curr = root;

    if curr is None:
        return None;
    while curr.right:
        curr = curr.right;

    return curr.val;

class BSTNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
root = BSTNode(5)
root.left = BSTNode(3)
root.right = BSTNode(8)
root.left.right = BSTNode(4)
root.right.left = BSTNode(6)
root.right.right = BSTNode(10)

print(bstMax(root))