import java.io.*;
import java.util.*;

class graphshortestdist {

    static int[][] dist;
    static int[] prev;
    public static void main(String[] args) 
    {
        System.out.println("graphshortestdist");

        Graph2 graph = new Graph2(5);
        dist = new int[5][5];
        prev = new int[5];

        Arrays.fill(dist, -1);
        Arrays.fill(prev, -1);

        for(int i =0; i<graph.size; i++) {
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            //graph.addEdge(1, 3);
            //graph.addEdge(2, 4);
            graph.addEdge(4, 3);
            //graph.addEdge(0, 3);
        }  

        shortPath(graph, 0, 3);

        shortPathIt(graph, int start, int end);
    }

    static void shortPathIt() {

    }

    static void shortPath(Graph2 g, int start, int end) {
        int iSize = recurse(g, 0, start, end);

        if(iSize != Integer.MAX_VALUE)
        System.out.println("shortestpath is:" + iSize);
        else
        System.out.println("No path found");
    }

    static int recurse(Graph2 g, int cnt, int start, int end) {
        if(start == end) return cnt;

        int dist = Integer.MAX_VALUE;

        ArrayList<Integer> arr = g.getEdges(start);
        for(int next: arr) {
            dist = Math.min(dist, recurse(g, cnt+1, next, end));
        }

        return dist;
    }
}

class Graph2 {
    int size;
    ArrayList<Integer>[] v;// = null;

    public Graph2(int s) {
        size = s;
        v = new ArrayList[s];

        for(int i =0; i< size; i++) {
            v[i] = new ArrayList<>();
        }
    }

    // public void initGraph(int _s) {
    //     size = _s;
    //     v = new ArrayList<Integer>[size];
    // }

    public ArrayList<Integer> getEdges(int i) {
        return v[i];
    }

    public void addEdge(int i, int dest) {

        if(!v[i].contains(dest)) {
            v[i].add(dest);
        }
    }
}
