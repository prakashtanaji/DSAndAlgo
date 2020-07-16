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
root.left = Node(2)
#root.left.val = 2

root.right = Node(3)
#root.right.val = 3

root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)

st = []
curr = root
# st.append(1)
# st.append(2)
# st.append(3)
# st.pop()

print('start')

while True:
    if curr is not None:
        #print(curr.val)
        st.append(curr)
        curr = curr.left
    else:
        # print('curr is null')
        if len(st) == 0:
            break
        else:
            top = st.pop()
            print(top.val, end=" ")
            curr = top.right


print()
    




