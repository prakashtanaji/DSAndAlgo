class LListNode {
    int val;
    LListNode next;

    public LListNode(int inputVal) {
        val = inputVal;
    }

    public LListNode() {
    }
}
class Solution {

    public static void main(String[] args){
        //1 -> 2 -> 5 -> 8
        LListNode root = new LListNode(1);
        root.next = new LListNode(2);
        root.next.next = new LListNode(5);
        root.next.next.next = new LListNode(8);
        root.next.next.next.next = new LListNode(10);

        printList(root);

        printList(solve(root));

    }

    static void printList(LListNode root) {

        LListNode curr = root;
        while(curr != null) {
            System.out.print(curr.val + " ");

            curr = curr.next;
        }

        System.out.println();
    }
    
    static LListNode head;
    static LListNode solve(LListNode node) {
        // Write your code here
        if(node == null) return null;
        if(node.next == null) return node;
        
        LListNode fwdCurr = new LListNode();
        fwdCurr.next = new LListNode(100);
        
        recurse(node, node.next, fwdCurr);
        
        return head;
    }
    
    static LListNode recurse(LListNode curr, LListNode fastCurr, LListNode fwdCurr) {
        LListNode currNode;
        if(fastCurr == null || fastCurr.next == null) {
            currNode = new LListNode();
            head = currNode;
            if(fastCurr != null) {
                currNode.val = curr.val + curr.next.val;
                fwdCurr.val = curr.next.next.val;
                fwdCurr.next = curr.next.next.next;
            }
            else {
                currNode.val = curr.val;
                fwdCurr.val = curr.next.val;
                fwdCurr.next = curr.next.next;
            }
        }
        else {
            currNode = recurse(curr.next, fastCurr.next.next, fwdCurr);
            LListNode nextNode = new LListNode();
            
            nextNode.val = 
                curr.val + fwdCurr.val;
            if(fwdCurr.next != null) {
                fwdCurr.val = fwdCurr.next.val;
                fwdCurr.next = fwdCurr.next.next;
            }
            
            currNode.next = nextNode;
            currNode = currNode.next;
        }
        
        return currNode;
    }
}