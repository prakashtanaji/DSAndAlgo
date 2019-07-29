import java.util.*;

class bst {
    public static void main(String[] args) {
        TreeNode root = insert(9, null);
        insert(6, root);
        insert(8, root);
        insert(7, root);
        insert(15, root);
        insert(11, root);
        insert(18, root);
        insert(4, root);

        inOrder(root);

        delete(8, root);

        inOrder(root);

        delete(15, root);

        inOrder(root);

        delete(9, root);

        inOrder(root);


    }

    public static TreeNode delete(int val, TreeNode n) {
        if(n == null) return null;
        if(n.val == val) {
            if(n.right != null) {
                int min = findMin(n.right);
                n.val = min;
                n.right = delete(min, n.right);
            }
            else if(n.left != null) {
                int max = findMax(n.left);
                n.val = max;
                n.left = delete(max, n.left);
            }
            else {
                return null;
            }
        }
        else if(val > n.val) {
            n.right = delete(val, n.right);
        }
        else {
            n.left = delete(val, n.left);
        }

        return n;
    }

    public static int findMin(TreeNode n) {
        while(n.left != null) {
            n = n.left;
        }

        return n.val;
    }

    public static int findMax(TreeNode n) {
        while(n.right != null) {
            n = n.right;
        }

        return n.val;
    }

    public static TreeNode insert(int val, TreeNode n) {

        if(n == null) return new TreeNode(val);
        if(n.val > val) {
            if(n.left !=null) {
                insert(val, n.left);
            }
            else {
                n.left = new TreeNode(val);
            }
        }
        else {
            if(n.right !=null) {
                insert(val, n.right);
            }
            else {
                n.right = new TreeNode(val);
            }
        }

        return n;
    }

    public static void inOrder(TreeNode root) {

        if(root == null) return;

        boolean done = false;

        TreeNode n = root;

        Stack<TreeNode> st = new Stack<>();

        while(!done) {
            if(n != null && n.left !=null) {
                st.add(n);
                n = n.left;
            }
            else {
                if(n != null)
                    System.out.print(n.val + " ");

                if(st.isEmpty()) {
                    done = true;
                }
                else {
                    TreeNode top = st.pop();
                    System.out.print(top.val + " ");
                    n = top.right;
                }
            }
        }

        System.out.println();

    }

}

class Node
{
    int val;
    TreeNode left;
    TreeNode right;

    public Node(int _val) {
        val = _val;
    }


}