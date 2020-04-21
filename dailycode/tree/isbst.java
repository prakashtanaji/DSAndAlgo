class isbst {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(Integer.MAX_VALUE);
        root.right.left = new TreeNode(6);

        System.out.println("Is tree BST:" + isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }


    static boolean isBst(TreeNode node, int min, int max) {

        if(node == null) return true;

        if(node.val>=max || node.val<=min) return false;

        return isBst(node.left, min, node.val)  && isBst(node.right, node.val, max);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int _val) {
        val = _val;
        left = null;
        right = null;
    }
}