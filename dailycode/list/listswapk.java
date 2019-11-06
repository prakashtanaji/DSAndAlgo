import java.util.List;

class listswapK {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        root = swapk(root, 3);

        if(root != null)
            root.printList();
    }

    static ListNode swapk(ListNode root, int k) {

        if(root == null || root.next == null) return root;
        int kSet = k;
        ListNode prevSet = null;

        ListNode lastEnd = root;
        ListNode prev = null;
        ListNode curr = root;

        while(kSet>0 && curr != null) {
            kSet--;

            if(curr.next == null) {
                curr.next = prev;
                break;
            }
            ListNode temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;

            if(kSet == 0) {
                if(prevSet == null) {
                    root = prev;
                }
                else {
                    prevSet.next = prev;
                }
                prev = null;
                kSet = k;
                prevSet = lastEnd;
                lastEnd = curr;
            }
        }

        if(prevSet != null) {
            prevSet.next = curr;
        }
        else {
            root = curr;
        }

        return root;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int _val) {
        val = _val;
    }

    public void printList() {
        ListNode curr = this;
        while(curr != null) {
            System.out.print(" " + curr.val);
            curr = curr.next;
        }
    }
}