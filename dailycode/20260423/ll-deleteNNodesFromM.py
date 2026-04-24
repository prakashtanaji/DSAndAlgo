"""

10:40
Q:
    what of element are < m <n < m+n ? work wiuth whats left and possible
    return Head? yes

10:42

Logic :
    step 1: iterate until m node , track the prevM link
    Step 2: iterate through n node, track the prevN  link:
    Step 3: PrevM.next = prevN.next
    step 4: return Head


Run Time: O(m+n)
Space : O(1)



ex: 1-> 2-> 3-> 4-> 5->NULL

 m = 2 return 2
 n = 3  return 5
"""

import copy;


class Node :
    def __init__(self, val):
        self.val = val;
        self.next = None;

    def printList(self):
        curr = self
        while curr:
            print(curr.val , " ")
            curr = curr.next



def RemoveNAfterM(headIn,m,n):

    head = headIn;

    if head is None:
        return None;

    if m == 0:
        prevN = skipNodes(head, n)

        if prevN == None:
            return None;
        else:
            return prevN.next;
    else:
        prevM = skipNodes(head, m)
        if prevM is None:
            return None;
        prevN = skipNodes(prevM.next, n)
        if prevN == None:
            prevM.next = None;
        else:
            prevM.next = prevN.next;
        
    return head;

        


    # #For case to skip 0
    # if prevM == None: 
    #     head = None;

    # # if reached end of list
    # if prevM is not None and prevM.next == None:
    #     return head;

    # prevN = head if prevM is None else prevM,n)
    # # if prevN.next == None:
    # #     return head;


    # if head == None:
    #     return prevN.next;

    # prevM.next = prevN.next;

    # return head

def skipNodes(node, skipCount):
    #1-> 2-> 3-> 4-> 5->NULL
    #skipCount = 2

    if skipCount == 0:
        return None;

    while node is not None and skipCount>1:
        node = node.next;
        skipCount -=1;
    return node;

def printList(node):
    if node is None:
        print("Empty List")
        return;
    node.printList();


root = Node(1)
root.next = Node(2)
root.next.next = Node(3)
root.next.next.next = Node(4)
root.next.next.next.next = Node(5)

res = RemoveNAfterM(copy.deepcopy(root), 2, 3)
printList(res)
print("Test------")

printList(root)

res = RemoveNAfterM(None, 2, 1)
printList(res)
print("Test------2")

res = RemoveNAfterM(copy.deepcopy(root), 0, 1)
printList(res)
print("Test------3")


res = RemoveNAfterM(copy.deepcopy(root), 1, 2)
printList(res)
print("Test------4")

res = RemoveNAfterM(copy.deepcopy(root), 8, 1)
printList(res)
print("Test------5")

res = RemoveNAfterM(copy.deepcopy(root), 2,3)
printList(res)

