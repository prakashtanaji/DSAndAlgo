public class converttofulltree
{
    public static void main(String[] args) {

        Tree root = new Tree(0);
        root.left = new Tree(0);
        root.right = new Tree(4);
        root.left.left = new Tree(2);
        root.right.left = new Tree(0);
        root.right.right = new Tree(5);
        //           0
        //     0          4
        // 2            0   5
        fullTree(root);

        //    2
        // 0 

        
        System.out.println("To full tree node completed");

    }
    public static void fullTree(Tree t) {
        if(t == null) return;

        if(t.left == null && t.right == null) {
            return;
        }

        if(t.left == null) {
            swap(t.right, t);
            t.left = t.right.left;
            t.right = t.right.right;
        }
        else if(t.right == null) {
            swap(t.left, t);
            t.right = t.left.right;
            t.left = t.left.left;
        }

        fullTree(t.left);
        fullTree(t.right);
    }

    public static void swap(Tree node1, Tree node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    
}

class Tree {
    int val;
    Tree left;
    Tree right;

    public Tree (int _val) {
        val = _val;
    }
}