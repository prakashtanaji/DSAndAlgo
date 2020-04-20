import java.util.*;

public class treefrommatrix
{
    public static void main(String[] args) {

        int[][] mat = new int[][] {
            {0,0,0,0,0},
            {1,0,0,0,0},
            {0,0,0,1,0},
            {0,0,0,0,0},
            {1,1,1,1,0}
        };
        
        Map<Integer, List<Integer>> mp = new TreeMap<>();


        for(int i =0; i< mat.length; i++) {
            int sum = Arrays.stream(mat[i]).sum();

            if(!mp.containsKey(sum)) {
                mp.put(sum, new ArrayList<Integer>());
            }

            mp.get(sum).add(i);
        }


        Tree[] nodes = new Tree[mat.length];
        boolean[] foundParent = new boolean[mat.length];

        int last = 0;
        for(Map.Entry<Integer,List<Integer>> entry: mp.entrySet()) {
            for(int i: entry.getValue()) {
                nodes[i] = new Tree(i);

                last = i;

                if(entry.getKey()==0) continue;

                for(int curr =0; curr< mat.length; curr++) {
                    if(mat[i][curr] == 1 && foundParent[curr]== false) {

                        if(nodes[i].left == null) {
                            nodes[i].left = nodes[curr];
                        }
                        else {
                            nodes[i].right = nodes[curr];
                        }

                        foundParent[curr] = true;
                    }
                }

                //return nodes[last];

            }
        }

        Tree root = nodes[last];
        
        System.out.println("Created Tree" + root.val);

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