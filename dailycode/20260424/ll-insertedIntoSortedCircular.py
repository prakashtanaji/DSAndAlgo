


class Node:
    val = None
    next = None
    def __init__(self,val):
        self.val = val
        self.next = None

    def printNodes(self):
        startVal = self.val

        print(startVal, " ")
        curr = (Node)(self.next)

        while curr.val != startVal :
            print(curr.val, " ")
            curr = curr.next

def insertCLL(head, target):

    curr = head;
    
    if curr == curr.next:
        curr.next = Node(target)
        curr.next.next = curr;
        return

    inserted = False

    currNode = head;

    while True:
        if currNode.val <= currNode.next.val:
            if currNode.next.val >= target and currNode.val <= target :
                insertHelper(currNode, target)
                break;

        else : # breaking point
            if currNode.next.val >= target or currNode.val <= target :
                insertHelper(currNode, target)
                break;
        currNode = currNode.next;
        

def insertHelper(node, target):
    nxtNode = node.next;
    node.next = Node(target);
    node.next.next = nxtNode;


head = Node(30)
head.next = Node(3)
head.next.next = Node(7)
head.next.next.next = Node(11)
head.next.next.next.next = Node(13)
head.next.next.next.next.next = Node(18)
head.next.next.next.next.next.next = head

target = 35

insertCLL(head, target)

print("Done")
itr = head

while itr.next != head:
    print(itr.val, " ")
    itr = itr.next;

print(itr.val, " ")



