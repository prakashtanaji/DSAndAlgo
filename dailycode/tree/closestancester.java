import java.util.*;

class closestancester {
    public static void main(String[] args) {

        Tree root = new Tree(1);
        root.left= new Tree(2);
        root.right= new Tree(3);
        root.left.right= new Tree(4);
        root.left.left= new Tree(5);
        root.right.right= new Tree(6);
        root.right.left= new Tree(7);

        int first = 2, second = 2;

        System.out.println("closest ancester is "+ findlca(root, first, second));
    }

    static int findlca(Tree curr, int n1, int n2) {

        if(curr == null) return -1;
        if(curr.val == n1 || curr.val == n2) return curr.val;

        int valLeft = findlca(curr.left, n1, n2);
        int valRight = findlca(curr.right, n1, n2);

        if(valLeft != -1 && valRight!=-1) return curr.val;

        if(valLeft == -1) return findlca(curr.right, n1, n2);
        else if (valRight == -1) return findlca(curr.left, n1, n2);

        return -1;
    }
}

class Tree {
    int val;
    Tree left;
    Tree right;
    public Tree(int _val) {
        val = _val;
    }
}