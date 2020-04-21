class linkedlistquickpivot {

    public static void main(String[] args) {

        LLNode root = new LLNode(1);
        root.next = new LLNode(8);
        root.next.next = new LLNode(3);
        root.next.next.next = new LLNode(4);
        root.next.next.next.next = new LLNode(9);
        root.next.next.next.next.next = new LLNode(7);

        int k = 5;

        LLNode first = root;
        //LLNode second = root;

        LLNode curr = root;

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

    static void swap(LLNode n1, LLNode n2) {
        int temp = n1._val;
        n1._val = n2._val;
        n2._val = temp;
    }
}

class LLNode {
    int _val;
    LLNode next;

    public LLNode(int val) {
        _val = val;
    }
}