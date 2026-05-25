from ast import List
import heapq;

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def kMergeSortedLists(lists, k):
    # TODO: implement — merge k sorted linked lists; return merged head
    if not lists:
        return None

    sentinal = ListNode(-float('inf'))
    prev = sentinal

    pq = []
    count = 0
    for lst in lists:
        if lst != None:
            count+=1
            heapq.heappush(pq, (lst.val, count, lst))

    while pq:
        (min, id, lst) = heapq.heappop(pq)
        prev.next = lst
        prev = prev.next
        prev.next = None

        if lst.next is not None:
            count+=1
            heapq.heappush(pq, (lst.next.val, count, lst.next))

    return sentinal.next;


def build_list(vals):
    if not vals:
        return None
    head = ListNode(vals[0])
    curr = head
    for v in vals[1:]:
        curr.next = ListNode(v)
        curr = curr.next
    return head


def build_lists(arrays):
    return [build_list(a) for a in arrays]


def print_list(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")


if __name__ == "__main__":
    # k sorted lists (same idea as ll-mergeKsorted.py mat = [[1,2,4],[2,5,8],[1,9]])
    arrays = [[1, 2, 4], [2, 5, 8], [1, 9]]
    k = 3
    lists = build_lists(arrays)

    print("input lists:")
    for i, head in enumerate(lists):
        print(f"  list {i}: ", end="")
        print_list(head)

    head = kMergeSortedLists(lists, k)
    print("merged:")
    print_list(head)
    # expected: 1 -> 1 -> 2 -> 2 -> 4 -> 5 -> 8 -> 9 -> None