from nt import dup


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def removeDuplicates(head):
    # TODO: implement — remove all nodes whose val appears more than once

    prevHead = ListNode(-100000, head)
    prev = prevHead;

    curr = head

    while curr != None and curr.next != None:
        if curr.val == curr.next.val:
            dupBegin = curr
            while curr.next != None and dupBegin.val == curr.next.val:
                curr = curr.next
            prev.next = curr.next
            curr = curr.next

        else:
            prev = curr
            curr = curr.next


    return prevHead.next


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
    # 1 -> 2 -> 3 -> 2 -> 4 -> 2 -> 5  (2 appears 3 times)
    #head = build_list([1, 1,3, 3, 3, 6, 6, 9, 9])
    head = build_list([-1, -1,1,1,2])
    print("before:")
    print_list(head)

    head = removeDuplicates(head)
    print("after:")
    print_list(head) 