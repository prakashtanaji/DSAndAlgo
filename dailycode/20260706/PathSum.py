class Node:
    def __init__(self, _val):
        self.val = _val
        self.left = None
        self.right = None

global result
def pathsum(curr: Node, res, sum, target):
    if sum+curr.val == target:
        res.append(curr.val)
        result.append(res)
        print(res)
        res.pop()
        return;
    elif sum+curr.val >target:
        return;
    else:
        res.append(curr.val)
        if curr.left:
            pathsum(curr.left, res, sum+curr.val, target)
        if curr.right:
            pathsum(curr.right, res, sum+curr.val, target)
        res.pop()



if __name__ == "__main__":

    root = Node(4)
    root.left = Node(5)
    root.right = Node(2)
    root.left.left = Node(6)
    root.right.left = Node(3)
    #         4
    #     5      2
    #  6      3

    result = []
    res = []
    pathsum(root, res, 0, target = 6)
    print(result)






