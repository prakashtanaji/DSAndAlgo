from re import I


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
root.right.left.left = TreeNode(11)

# def inOrderRecurse(node):

#     if not node:
#         return;
#     inOrderRecurse(node.left)
#     print(node.val)
#     inOrderRecurse(node.right)

# print("InOrder")
# inOrderRecurse(root);

# def preOrderRecurse(node):

#     if not node:
#         return;

#     print(node.val)
#     preOrderRecurse(node.left)
#     preOrderRecurse(node.right)

# print("PreOrder")
# preOrderRecurse(root);

# def postOrderRecurse(node):

#     if not node:
#         return;
#     postOrderRecurse(node.left)
#     postOrderRecurse(node.right)
#     print(node.val)

# print("PostOrder")
# postOrderRecurse(root);

def inOrderIterative(node):
    res = []

    curr = node;

    if node == None:
        return;

    st = []

    while curr is not None or len(st)>0:
        if curr is None:
            top = st.pop(-1);
            res.append(top.val)

            if top.right is not None:
                curr = top.right;
            
            continue;

        if curr.left is not None:
            st.append(curr)
            curr = curr.left;
        else:
            res.append(curr.val);
            curr = None

    return res;

def preOrderTraverse(node):

    if not node:
        return None;

    st = []
    res = []

    st.append(node)

    while st:
        top = st.pop(-1)
        res.append(top.val)
        if top.right:
            st.append(top.right)
        if top.left:
            st.append(top.left)

    return res;

def postOrderTraverse(node):

    if not node:
        return None;

    st = []
    res = []

    prev = None;
    curr = node;

    st.append(node);

    while st:
        curr = st[-1]
        if prev is None or (curr.left!= prev and curr.right != prev):
            if curr.left:
                st.append(curr.left);
                #curr = curr.left;
            elif curr.right:
                st.append(curr.right);
            else:
                res.append(curr.val);
                prev = curr;
                st.pop(-1)
        elif prev == curr.left:
            if curr.right:
                st.append(curr.right)
            else: 
                res.append(curr.val);
                prev = curr
                st.pop(-1)
        else:
            res.append(curr.val);
            prev = curr;
            st.pop(-1)
    return res;



                
result = postOrderTraverse(root)
print(result)