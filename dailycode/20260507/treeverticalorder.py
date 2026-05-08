from logging import _levelToName


class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    def print(self):
        print(self.val)

root  = TreeNode(1);
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.left = TreeNode(6)
root.right.right = TreeNode(7)
root.right.left.left = TreeNode(8)

dict = {}

def verticalTraverse(root, hd, level, dict):
    if not root:
        return;

    hdData = dict.get(hd, [])
    hdData.append((root.val, level));
    dict[hd] = hdData;

    if root.left:
        verticalTraverse(root.left, hd-1, level+1, dict)

    if root.right:
        verticalTraverse(root.right, hd+1, level+1, dict)


def printVerticalLines():
    verticalTraverse(root, 0, 1, dict)

    sorted(dict)

    for k, v in sorted(dict.items()):
        print(k)
        v.sort(key=lambda x:x[1], reverse=True);
        for val in v:
            print("   ", val[0])

#printVerticalLines();

def bfsVertLines():
    q = []

    currVertical = 0;
    level = 0;
    q.append((root, 0, level));

    res = [[]]    

    mn = 0
    mx = 0

    while q:
        count = len(q);

        ln = [];

        while count > 0:
            ln = []
            nodeData = q.pop(0);

            mn = min(mn, nodeData[1])
            mx = max(mx, nodeData[1])

            ln.append((nodeData[0].val, nodeData[1]))

            if nodeData[0].left:
                q.append((nodeData[0].left, nodeData[1]-1, level+1))
            if nodeData[0].right:
                q.append((nodeData[0].right, nodeData[1]+1, level+1))

            count=-1;
        
        res.append(ln);

        level +=1;
        

    resSorted = [[]]*(mx-mn)
    verticalItems = {}

    for lvl in res:
        for rawData in lvl:
            if rawData is not None and rawData[1] is not None:
                arr = verticalItems.get(rawData[1], [])
                arr.append(rawData[0]);
                verticalItems[rawData[1]] = arr;

    for i in range(mn, mx+1):
        print(verticalItems[i])


    # print(verticalItems)

                #resSorted[rawData[1]-mn].append(rawData[0])
    
    # for i in range(len(resSorted)):
    #     print("Level : ", i+mn)
    #     if resSorted[i] is not []:
    #         arr = resSorted[i];
    #         # arr.sort(key=lambda x:x[1])
    #         for nodeVal in arr:
    #             print(" ", nodeVal);

bfsVertLines();
    







