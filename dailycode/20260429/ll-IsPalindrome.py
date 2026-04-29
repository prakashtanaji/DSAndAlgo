from platform import node


class Node:
    def __init__(self, val, next = None):
        self.val = val
        self.next = next

    def print(self):
        curr = self
        while curr:
            print(curr.val, " ")
            curr = curr.next;



def recursiveCheck(start, end):
    if end == None or start == None:
        return (start, True);
    
    prevRes = recursiveCheck(start, end.next)

    currRes = False;

    
    if prevRes[1] and ((end.next is None and start.val == end.val) or (prevRes[0].val == end.val)):
        currRes = True;
    
    return (prevRes[0].next, currRes);




root = Node(1)
root.next = Node(2)
root.next.next = Node(3)
root.next.next.next = Node(3)
root.next.next.next.next = Node(2)
root.next.next.next.next.next = Node(1)

# res = recursiveCheck(root, root.next)

# print(res[1]);

# print(root);

# rc(1,2)
#    1,3
#      1, 3
#         1, 2
#            1, 1
#         2,2
#      3,3
#    3, 3
#   2, 2

def iterativeReverseCheck(root):

    midNode = findMid(root);


    root2 = reverse(midNode[0].next);


    curr2 = root2
    curr = root

    isPalindrome = True;
    while curr and curr2:
        if curr.val != curr2.val:
            isPalindrome = False;
            break;
        curr = curr.next;
        curr2 = curr2.next;

        # if midNode[1] and curr.next != None and curr.next.next is None:
        #     break;

    
    #Fix the list :
    root2 = reverse(root2)
    midNode[0].next = root2;

    return isPalindrome;

def findMid(head):
    if head is None or head.next is None:
        return head;
    slow = head
    fast = head;

    while fast.next is not None and fast.next.next is not None:

        slow = slow.next;
        fast = fast.next.next;

    isOdd = False;
    if fast.next is None:
        isOdd = True;

    return (slow, isOdd); # If Odd no need to compare the slow return/mid item


def reverse(nodeRev):
    prev = None;
    while nodeRev.next:

        nextNode = nodeRev.next;
        nodeRev.next = prev;
        prev = nodeRev;
        #nextNode.next = nodeRev;

        nodeRev = nextNode;

    nextNode.next = prev;

    return nodeRev;




print("before check")
root.print()

res =  iterativeReverseCheck(root)
print(res)

print("After check")
root.print()




#Slow is the last item of the 1st half

#1 2 3 4 5 6



