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


head = Node(-1)
head.next = Node(3)
head.next.next = Node(13)
head.next.next.next = Node(-10)
head.next.next.next.next = Node(13)
head.next.next.next.next.next = Node(18)
head.next.next.next.next.next.next = Node(4)

def insertSort(root):

    sorted_list = None;

    curr = root;

    while curr is not None:

        nextCurr = curr.next; # we will not get oppurtunity to retrieve this once curr is added into sortedList

        sorted_list = insert_sort(sorted_list, curr)

        curr = nextCurr; 

    return sorted_list;

def insert_sort(sorting_list, newNode):

    if sorting_list is None:
        sorting_list = newNode;
        sorting_list.next = None;

        return sorting_list;
    elif sorting_list.val >= newNode.val:
        newNode.next = sorting_list; # add it before the sorted List
        return newNode;
    else: # mean it somewhere after the head of sorted list
        curr = sorting_list

        while curr is not None:
            if curr.val <= newNode.val and (curr.next is None or curr.next.val >= newNode.val):
                newNext = curr.next;
                curr.next = newNode
                newNode.next = newNext;
                break;
            curr = curr.next;
        return sorting_list;

sorted_head = insertSort(head)

curr = sorted_head

while curr is not None:
    print(curr.val, " ")
    curr = curr.next;

            
