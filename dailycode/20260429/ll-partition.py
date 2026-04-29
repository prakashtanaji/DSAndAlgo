class Node:
    def __init__(self, val, next = None):
        self.val = val
        self.next = next

    def print(self):
        curr = self
        while curr:
            print(curr.val, " ")
            curr = curr.next;

def partition(root, target):
    dummy = Node(100);
    dummy.next = root;

    left = dummy;
    right = root;

    while right:
        if right.val <= target:
            temp = right.val;
            right.val = left.next.val
            left.next.val = temp

            left = left.next
            right = right.next;

        else:
            right = right.next;
        
    return left;

# t = 4
# dummy -> 1, 3, 2, 2 ,6, 5
#                         r
#                   l

root = Node(5)
root.next = Node(8)
root.next.next = Node(7)
root.next.next.next = Node(5)
root.next.next.next.next = Node(6)
root.next.next.next.next.next = Node(8)
target = 10

partitionLastNode = partition(root, target)


if partitionLastNode.next == None:
    partitionLastNode.next = Node(1000000)

print(partitionLastNode.val, ":", partitionLastNode.next.val)
print(root)
root.print()
