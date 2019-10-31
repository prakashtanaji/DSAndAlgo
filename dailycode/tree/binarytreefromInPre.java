import java.util.*;

class btfip {
    public static void main(String[] args) {
        int[] in = new int[] {4,2,7,5,1,3,6};
        int[] pre = new int[] {1,2,4,5,7,3,6};

        TNode root = build(in, 0, in.length-1, pre, 0, pre.length-1);

        printLevels(root);

        printTopView(root);
    }

    static TNode build(int[] in, int inSt, int inEnd, int[] pre, int preSt, int preEnd) {
        if(inSt>inEnd) return null;

        int id = findValIdIn(in, inSt, inEnd, pre[preSt]);
        if(id == -1) {
            return null;
        }

        TNode node = new TNode(pre[preSt]);
        node.left = build(in, inSt, id-1, pre, preSt+1, preSt+(id-inSt));
        node.right = build(in, id+1, inEnd, pre, preSt+(id-inSt)+1, preEnd);

        return node;
    }

    static int findValIdIn(int[] inOrder, int st, int end, int val) {
        for(int i = st; i<=end; i++) {
            if(inOrder[i] == val) return i;
        }

        return -1;
    }

    static void printTopView(TNode root) {
        Queue<TNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        Map<Integer, Integer> mp = new TreeMap<>();

        q1.add(root);
        q2.add(0);

        while(!q1.isEmpty()) {
            TNode curr = q1.remove();
            int col = q2.remove();

            if(!mp.containsKey(col)) {
                mp.put(col, curr.val);
            }
            if(curr.left!=null) {
                q1.add(curr.left);
                q2.add(col-1);
            }
            if(curr.right!=null) {
                q1.add(curr.right);
                q2.add(col+1);
            }
        }

        Iterator it = mp.values().iterator();

        while(it.hasNext()) {
            int val = (int) it.next();

            System.out.print(" "+ val);
        }
    }

    static void printLevels(TNode root) {
        Stack<TNode> st1 = new Stack<>();
        Stack<TNode> st2 = new Stack<>();

        st1.push(root);

        while(!st1.isEmpty() || !st2.isEmpty()) {
            if(!st1.isEmpty()) {
                while(!st1.isEmpty()) {
                    TNode node = st1.pop();
                    System.out.print(" " + node.val);
                    if(node.right!=null) {
                        st2.push(node.right);
                    }
                    if(node.left!=null) {
                        st2.push(node.left);
                    }
                }
            } 
            else {
                while(!st2.isEmpty()) {
                    TNode node = st2.pop();
                    System.out.print(" " + node.val);
                    if(node.left!=null) {
                        st1.push(node.left);
                    }
                    if(node.right!=null) {
                        st1.push(node.right);
                    }
                }
            }

            System.out.println();
        }
    }
}

class TNode {
    int val;
    TNode left;
    TNode right;

    public TNode(int _val) {
        val = _val;
        left = null;
        right = null;
    }
}