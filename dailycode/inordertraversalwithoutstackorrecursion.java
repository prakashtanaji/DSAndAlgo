
class inordertraverse {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(9);
        root.left.right.left.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        // Actually Morris algorithm uses chained binary tree data structure where in 
        // there are two(may be one sometimes) additional pointers which point to the predeccesor and successor of the node.
        // predecessor if the left node is null and successor only of the right node is null.
        // In this program we try to avoid using the additional pointer altogether and manage with the 
        // left and right pointers to point to pred and succ, but reset as is, as we traverse.
        morrisTraverse(root);

    }

   static void morrisTraverse(TreeNode root) {
        if(root == null) System.out.println("No node to traverse");

        TreeNode curr = root;
        TreeNode prev=null;

        while(curr !=null) {
            if(curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
            else {
                // get the right most(no right node) of the left child and point it to current
                // only if not already current else reset to null
                
                prev = curr.left;

                // go to right most
                while(prev.right!=null && prev.right !=curr) {
                    prev = prev.right;
                }

                // set curr as the prev.right
                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else
                {
                    // this means the prev.rirght is pointing to its parent
                    // This portion is usually hit in the 2nd iteration
                    // Now its time to reset the right pointer to its original(null)
                    prev.right = null;

                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int _val) {
        val = _val;
        left = right = null;
    }
}