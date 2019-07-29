import java.util.*;

class postorder {
    public static void main(String[] args) {
        System.out.println("Printing post order");

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        //     1
        //   2   3
        // 4  5   6


        printPost(root);

    }

    static void printPost(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        TreeNode prev = null;
        st.push(root);

        while(!st.isEmpty()) {
            curr = st.peek();

            if(prev == null
             || ((curr.left != prev) 
                && (curr.right != prev))) {
                 if(curr.left != prev && curr.left !=null) {
                     st.push(curr.left);
                 }
                 else if(curr.right != prev && curr.right !=null) {
                     st.push(curr.right);
                 }
                 else {
                        System.out.println(" "+curr.val);
                        st.pop();
                 }
            }
            else if(curr.left == prev) {
                if(curr.right != null && curr.right !=null) {
                    st.push(curr.right);
                }
                else {
                       System.out.println(" "+curr.val);
                       st.pop();
                }
            }
            else {
                System.out.println(" "+curr.val);
                st.pop();
            }
            
            prev = curr;
        }

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        val = value;
    }
}