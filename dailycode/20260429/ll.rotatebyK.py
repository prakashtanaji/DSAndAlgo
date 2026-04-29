from hmac import new


class Node:
    def __init__(self, val, next = None):
        self.val = val
        self.next = next

    def print(self):
        curr = self
        while curr:
            print(curr.val, " ")
            curr = curr.next;

def rotate(head, k):
    # check if can be rotate k times. handle edge cases
    if k <1 or head == None:
        return head

    curr = head;
    szList = 1;
    while curr.next:
        szList+=1
        curr = curr.next
    
    if szList > k:
        k = k % szList
    
    curr.next = head;
    curr = curr.next

    for _ in range(k-1): # doing one less as we want to set lasts next to None
        curr = curr.next;

    res = curr.next

    curr.next = None

    return res;


root = Node(1)
root.next = Node(2)
root.next.next = Node(3)
root.next.next.next = Node(4)
root.next.next.next.next = Node(5)
root.next.next.next.next.next = Node(6)

newHead = rotate(root, -1)

newHead.print()

    
    
            