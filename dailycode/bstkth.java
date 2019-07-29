import java.util.*;

public class bstkth {
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
        System.out.println(findKth(3, root));

        System.out.println(findKth(0, root));

        System.out.println(findKth(10, root));

        System.out.println(findKth(1, root));
    }

    public static int findKth(int k, TreeNode n) {
        if(k<1 || n == null) return -1;
        
        if(n.sleft+1 == k) return n.val;
        if(n.sleft+1 <k) {
            return findKth(k-n.sleft-1, n.right);
        }
        else {
            return findKth(k, n.left);
        }
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
                n.sleft -=1;
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
            n.sleft -=1;
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
            n.sleft = n.sleft + 1;
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

class TreeNode
{
    int val;
    int sleft;
    TreeNode left;
    TreeNode right;

    public TreeNode(int _val) {
        val = _val;
        sleft = 0;
    }
}