class linkedlistquickpivot {

    public static void main(String[] args) {

        LListNode root = new LListNode(1);
        root.next = new LListNode(8);
        root.next.next = new LListNode(3);
        root.next.next.next = new LListNode(4);
        root.next.next.next.next = new LListNode(9);
        root.next.next.next.next.next = new LListNode(7);

        int k = 5;

        LListNode first = root;
        //LLNode second = root;

        LListNode curr = root;

        while(curr != null) {
            if(curr._val <= k) {
                swap(first, curr);
                curr= curr.next;
                first = first.next;
            }
            else {
                curr = curr.next;
            }
        }

        curr  = root;

        while(curr != null) {
            System.out.print(" " + curr._val);

            curr = curr.next;
        }
    }

    static void swap(LListNode n1, LListNode n2) {
        int temp = n1._val;
        n1._val = n2._val;
        n2._val = temp;
    }
}

class LLNode {
    int _val;
    LListNode next;

    public LLNode(int val) {
        _val = val;
    }
}