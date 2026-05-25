class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def mergeListRecursive(head):
    # TODO: implement — merge sort on linked list; return sorted head

    if head == None or head.next == None:
        return head;

    print('finding mid')
    # find mid
    slow = fast = head

    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next

    l1 = head  
    l2 = slow.next;

    slow.next = None

    print('sep lists')

    l1 = mergeListRecursive(l1)
    l2 = mergeListRecursive(l2)

    print('recursively called l1 and l2')

    head = mergeTwoList(l1,l2)

    print('mergedList')




    return head


def mergeTwoList(l1, l2):
    # TODO: implement — merge two sorted lists; return new head

    sentinal = ListNode(-float('inf'))
    prev = sentinal

    while l1 and l2:
        if l1.val <= l2.val:
            prev.next = l1;
            l1 = l1.next
            prev = prev.next
            #prev.next = None
        else:
            prev.next = l2;
            l2 = l2.next
            prev = prev.next
            #prev.next = None
    if l1:
        prev.next = l1
    elif l2:
        prev.next = l2
    else:
        prev.next = None

    return sentinal.next; 
    #return l1 if l1 else l2


def build_list(vals):
    if not vals:
        return None
    head = ListNode(vals[0])
    curr = head
    for v in vals[1:]:
        curr.next = ListNode(v)
        curr = curr.next
    return head


def print_list(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")


if __name__ == "__main__":
    head = build_list([-10, 4, 2, 7, 1000, 1, 9, 3, 5, 6])
    print("before:")
    print_list(head)

    head = mergeListRecursive(head)
    print("after:")
    print_list(head)
    # expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 9 -> None