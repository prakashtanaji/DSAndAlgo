public class sinknodetobottom
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
        postOrder(root);

        //    2
        // 0 

        
        System.out.println("Sink node cimpleted");

    }

    public static void postOrder(Tree curr) {
        if(curr == null) {
            return;
        }

        postOrder(curr.left);
        postOrder(curr.right);

        if(curr.val == 0) {
            sinkNode(curr);
        }
    }

    public static void sinkNode(Tree root) {
        if(root== null) return;

        if(root.left!=null && root.left.val!=0) {
            swap(root, root.left);

            sinkNode(root.left);
        }
        else if(root.right!=null && root.right.val!=0) {
            swap(root, root.right);

            sinkNode(root.right);
        }

        return;
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