class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    def print(self):
        print(self.val)

def postOrderIterative(root):
    if root is None: return;
    
    prev = None;
    curr = None;
    stack = [];
    stack.append(root)

    while len(stack)>0:
        curr = stack[-1];
        if curr.left != None and (prev == None or curr.left != prev) and (curr.right == None or prev!= curr.right):
                stack.append(curr.left);
                #curr = curr.left;
        elif curr.right is not None and (prev == None or prev != curr.right):
                stack.append(curr.right);
                #curr= curr.right;
        else:
            curr.print()
            stack.pop();
            prev = curr;


def postOrder(root):
    if not root:
        return
    postOrder(root.left)
    postOrder(root.right)
    print(root.val)

if __name__ == "__main__":

    root = Node(1)
    root.left = Node(2) 
    root.right = Node(3)
    #root.left.left = Node(4)    
    #root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    postOrderIterative(root);

# /*

#             1
#         2       3
#       4   5   6   7 

# Stack : 1, 
# prev 4, 5, 2, 6, 7, 3, 1


# left parse: if has left and is not prev and prev is also not its right, then add to stack and go left
# else if has right if prev is not parent, enterright
# else no right no left pop and print and update prev.



# */