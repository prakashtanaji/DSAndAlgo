import java.util.*;

import javafx.scene.control.ListView.EditEvent;

class directedTopologicalSort {
    public static void main(String[] args) {

        GraphDirected g = new GraphDirected(9);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,6);
        g.addEdge(2,3);
        g.addEdge(3,5);
        g.addEdge(4,2);
        //g.addEdge(6,4);

        //g.addEdge(7,8);
        g.addEdge(8,7);
        

        topoSort(g);
    }

    static void topoSort(GraphDirected g) {

        Stack<Integer> st = new Stack<>();
        boolean[] stacked = new boolean[g.v];

        for(int i = 0; i< g.v; i++) {
            if(stacked[i] == true) continue;
            recurse(g, i, stacked, st);
        }

        //print stack for the order of deployments
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

    static void recurse(GraphDirected g, int i, boolean[] stacked, Stack<Integer> st) {


        // for edges iterate if not already stacked
        for(int iEdges: g.getEdges(i))
        {
            if(stacked[iEdges] == true) continue;
            recurse(g, iEdges, stacked, st);
        }

        st.push(i);
        stacked[i] = true;
    }
}

class GraphDirected {
    int v;
    ArrayList<Integer> vertices[];

    public GraphDirected(int _v) {
        v = _v;
        vertices = new ArrayList[v];
        for(int i=0; i<v; i++) {
            vertices[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int edge) {
        vertices[v].add(edge);
    }

    public List<Integer> getEdges(int v) {
        return vertices[v];
    }
}