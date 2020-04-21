import java.util.*;
public class nodeAtDistFromLeaf
{
    public static void main(String[] args) {

        Tree root = new Tree(0);
        root.left = new Tree(1);
        root.right = new Tree(2);
        //root.left.left = new Tree(3);
        root.right.left = new Tree(4);
        root.right.right = new Tree(5);
        root.right.right.right = new Tree(6);
        //           0
        //     1          2
        // 3            4   5
        //                    6
        atDist(root, 4);

        //    2
        // 0 

        
        System.out.println("Dist from leaf node completed");

    }
    public static void atDist(Tree t, int dist) {
        
        Set<Integer> st = new HashSet<>();
        List<Integer> ls = new ArrayList<>();


        atDist(t, dist, st, ls);

        for(int item: st) {
            System.out.print(" "+ item);
        }
    }

    private static void atDist(Tree t, int dist, Set<Integer> st, List<Integer> ls) {
        if(t == null) return;

        if(t.left == null && t.right == null && ls.size()>=dist) {
            st.add(ls.get(ls.size()-dist));
            return;
        }

        ls.add(t.val);

        atDist(t.left, dist, st, ls);
        atDist(t.right, dist, st, ls);

        ls.remove(ls.size()-1);
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