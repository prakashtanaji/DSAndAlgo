class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    def print(self):
        print(self.val)

    #          1
    #     2           3
    # 4      5     6     7
    #    8       9

#TreeNode root;
root  = TreeNode(1);
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.right = TreeNode(4)
root.left.left = TreeNode(5)
root.right.left = TreeNode(6)
root.right.right = TreeNode(7)
root.right.left.left = TreeNode(8)


def findNodesAtDist(node, k, result):
    if not node:
        return;
    if k==0:
        result.append(node.val);
        return;

    findNodesAtDist(node.left, k-1, result);
    findNodesAtDist(node.right, k-1, result);

def treekdist(root, k, target, result):
    if not root:
        return -1;
    if root.val == target:
        findNodesAtDist(root, k-1, result);
        return 1;

    left = treekdist(root.left, k, target, result);

    if left != -1:
        if k-left == 0:
            result.append(root.val);
            return 0;
        else:
            findNodesAtDist(root.right, k-left-1, result);
            return left+1;

    right = treekdist(root.right, k, target, result);
    
    if right != -1:
        if k-right == 0:
            result.append(root.val);
            return 0;
        else:
            findNodesAtDist(root.left, k-right-1, result);
            return right+1;

    return max(right, left);





res = [];

treekdist(root, 5, 8, res)

print(res);