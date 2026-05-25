# Given a single linked list, intermix with the second part in reverse
# ex: [1,2,3,4,4.5,5,6,7,8] result: [1,8,2,7,3,6,4,5,4.5]

# Given a single linked list, intermix with the second part in reverse
# ex: [1,2,3,4,4.5,5,6,7,8] result: [1,8,2,7,3,6,4,5,4.5]


from heapq import merge


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reorderList(head):
    # TODO: implement — intermix first half with reversed second half

    #[1, 2, 3, 4, 4.5, 5, 6, 7, 8])

    slow = head
    fast = head

    while fast.next !=None and fast.next.next != None:
        slow = slow.next
        fast = fast.next.next

    l1= head
    l2 = slow.next
    slow.next = None

    l2 = reverseList(l2)

    print_list(l2)
    head = mergeList(l1,l2)

    return head


def reverseList(head):
    # TODO: implement — reverse list; return new head

    prev = None
    curr = head

    while curr != None:
        temp = curr.next
        curr.next = prev
        prev = curr
        curr = temp
    
    
    return prev


def mergeList(l1, l2):
    # TODO: implement — merge two lists; return new head

    sentinal = ListNode(-float('inf'))
    prev = sentinal

    while l1 and l2:
        prev.next = l1
        l1 = l1.next
        prev = prev.next

        prev.next = l2
        l2 = l2.next
        prev = prev.next

        prev.next = None
    
    if l1:
        prev.next = l1

    
    return sentinal.next#l1 if l1 else l2


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
    head = build_list([1, 2, 3, 4, 4.5, 5, 6, 7, 8])
    print("before:")
    print_list(head)

    head = reorderList(head)
    print("after:")
    print_list(head)
    # expected: 1 -> 8 -> 2 -> 7 -> 3 -> 6 -> 4 -> 5 -> 4.5 -> None

