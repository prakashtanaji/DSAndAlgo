# Given a single linked list, reverse nodes in K groups, such that alternating node groups are reversed.
# [1,3,5,2,6,8,9,10,11,12,13] , k = 3
# result = [1,3,5,8,6,2,9,10,11,13,12]


# Given a single linked list, reverse nodes in K groups, such that alternating node groups are reversed.
# [1,3,5,2,6,8,9,10,11,12,13], k = 3
# result = [1,3,5,8,6,2,9,10,11,13,12]


from ast import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reverseKgroups(head, k):
    # TODO: implement — reverse alternating groups of k nodes

    if k <=1:
        return head

    sentinal = ListNode(-float('inf'))
    sentinal.next = head

    # Here the revere happens
    #[1, 3, 5, 2, 6, 8, 9, 10, 11, 12, 13])
    #     prev curr
    prev = sentinal
    curr = head

    while curr != None:
        count = k
        while curr != None and count!=0:
            prev = curr
            curr = curr.next
            count-=1
        
        print("itr1")
        if curr == None:
            break;
        
        prevforRev = None

        revHead = curr

        count = k
        while curr != None and count !=0:
            temp = curr.next
            curr.next = prevforRev
            prevforRev = curr
            curr = temp
            count-=1
        
        prev.next = prevforRev
        revHead.next = curr

        print("itr2")

    return sentinal.next


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
    head = build_list([1, 3, 5, 2, 6, 8, 9, 10, 11, 12, 13])  # 11 nodes
    k = 3

    print("before:")
    print_list(head)

    head = reverseKgroups(head, k)
    print("after:")
    print_list(head)
    # expected: 1 -> 3 -> 5 -> 8 -> 6 -> 2 -> 9 -> 10 -> 11 -> 13 -> 12 -> None

