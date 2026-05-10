import sys;

class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    def print(self):
        print(self.val)

root  = TreeNode(10);
root.left = TreeNode(5)
root.right = TreeNode(15)
root.left.left = TreeNode(2)
root.left.right = TreeNode(7)
root.right.left = TreeNode(12)
root.right.right = TreeNode(18)
root.right.left.left = TreeNode(10)

def isBSTRecurse(node, leftMin, rightMax):
    if not node: return True;

    # lMin = -sys.maxsize
    # rMax = sys.maxsize

    lVal = rVal = node.val
    if node.left is not None:
        lVal = node.left.val
    if node.right is not None:
        rVal = node.right.val

    if not (lVal <= node.val <= rVal and lVal>=leftMin and rVal<=rightMax):
        return False;
    
    return isBSTRecurse(node.left, leftMin, node.val) and isBSTRecurse(node.right, node.val, rightMax)

#print(isBSTRecurse(root, -sys.maxsize, sys.maxsize))

def isBSTIterativeInOrder(root):
    



