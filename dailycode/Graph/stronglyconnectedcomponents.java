import java.util.*;

public class stronglyconnectedcomponents {

    static Graph g;// = new Graph(size);
    static List<List<Integer>> connectedComps;
    static int currIndex = 0;
    public static void main(String[] args) {

        int size = 7;


        int[] index = new int[size]; 
        Arrays.fill(index, -1);
        boolean[] onStack = new boolean[size];
        int[] lowLink = new int[size];

        Stack<Integer> st = new Stack<>();
        
        g = new Graph(size);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(1,3);
        //g.addEdge(4,1);
        g.addEdge(1,4);
        g.addEdge(3,4);
        g.addEdge(4,3);
        //g.addEdge(4,5);
        g.addEdge(5,3);
        g.addEdge(6,0);

        connectedComps = new ArrayList<>();

        for(int i=0; i< g._v; i++) {
            if(index[i]==-1) {
                scc(i, index, lowLink, onStack, st);
            }
        }

        System.out.println("Strongly connected comps are ");
        Iterator<List<Integer>> it = connectedComps.iterator();
        while(it.hasNext()){
            List<Integer> comp = it.next();
            for(int node: comp) {
                System.out.print(" " + node);
            }
            System.out.println();
        }
    }

    static void scc(int node, int[] index, int[] lowLink, boolean[] onStack, Stack<Integer> st) {
        index[node] = currIndex;
        lowLink[node] = currIndex++;
        st.add(node);
        onStack[node] = true;

        for(int edge: g.getEdges(node)) {

            if(index[edge] == -1) {
                scc(edge, index, lowLink, onStack, st);
                lowLink[node] = Math.min(lowLink[node], lowLink[edge]);
            }
            else if(onStack[edge] == true) {
                lowLink[node] = Math.min(lowLink[node], lowLink[edge]);
            }
        }

        if (lowLink[node] == index[node]) {
            List<Integer> newComp = new ArrayList<>();
            connectedComps.add(newComp);

            int popped = -1;
            do {
                popped = (int)st.pop();
                onStack[popped] = false; // This is needed to avoid already picking the lowlink of already chosen connected comp
                newComp.add(popped);

            } while(index[popped] !=  lowLink[popped]); // other way is the node == popped
        }
    }
}

class Graph {
    int _v;
    List<List<Integer>> vertices;

    public Graph(final int v) {
        _v = v;
        vertices = new ArrayList<List<Integer>>();
        for(int i =0; i< v; i++) {

            ArrayList<Integer> vertex = new ArrayList<Integer>();
            vertices.add(vertex);
        }
    }

    public ArrayList<Integer> getEdges(final int v) {
        return (ArrayList<Integer>)vertices.get(v);
    }

    public void addEdge(final int v, final int dest) {
        ((ArrayList<Integer>)vertices.get(v)).add(dest);
    }
}