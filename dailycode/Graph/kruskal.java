import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Set;

class WtEdge {
    int start;
    int end;
    int wt;

    public WtEdge(int _s, int _e, int _w) {
        start = _s;
        end = _e;
        wt = _w;
    }
}

class Edge {
    int dest;
    int wt;

    public Edge(int _d, int _w) {
        dest = _d;
        wt = _w;
    }
}

class GraphK {
    int V;
    ArrayList<Edge> adjList[];

    public GraphK(int v) {
        V = v;
        adjList = new ArrayList[v];

        for(int i=0; i<v; i++) {
            adjList[i] = new ArrayList<Edge>();
        }
    }

    public void addEdge(int v, int e, int w) {
        adjList[v].add(new Edge(e, w));
        adjList[e].add(new Edge(v, w));
    }

    public ArrayList<Edge> getEdges(int v) {
        return adjList[v];
    }
}

class UFNode {
    int data;
    int rank;
    UFNode parent;

    public UFNode(int _data) {
        data = _data;
        rank = 0;
        parent = this;
    }
}

class kruskal {

    static Map<Integer, UFNode> mp = new HashMap<>();

    static Set<Edge> finalEdges = new HashSet<>();
    static PriorityQueue<WtEdge> pq = new PriorityQueue<>(
        new Comparator<WtEdge>() {
            //@Override
            public int compare(WtEdge we1, WtEdge we2) {
                return we1.wt - we2.wt;
            }
        }
    );

    public static void main(String[] args) {
        GraphK g = new GraphK(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 3, 1);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 4, 3);

        for(int i=0; i<g.V; i++) {
            makeSet(i);
        }

        for(int i=0; i<g.V; i++) {
            ArrayList<Edge> edges = g.getEdges(i);
            for(int j = 0; j<edges.size(); j++) {
                pq.add(new WtEdge(i,edges.get(j).dest, edges.get(j).wt));
            }
        }

        while(!pq.isEmpty()) {
            WtEdge we = pq.poll();

            UFNode p1 = find(we.start);
            UFNode p2 = find(we.end);

            if(p1.data == p2.data) continue;

            finalEdges.add(new Edge(we.start, we.end));

            union(we.start, we.end);
        }

        System.out.println("The final edges in MST are");
        Iterator<Edge> it = finalEdges.iterator();
        while(it.hasNext()) {
            Edge e = it.next();
            /// The dest here represents start and wt represents end vertices.
            System.out.println(" "+e.dest+":"+ e.wt);
        }
    }

    static UFNode find(int vertex) {
        UFNode x = mp.get(vertex);

        while(x.parent !=x) {
            x = x.parent;

        }

        mp.get(vertex).parent = x;
        return x;
    }

    static void union(int a, int b) {
        UFNode p1 = find(a);
        UFNode p2 = find(b);

        if(p1.rank >= p2.rank) {
            if(p1.rank == p2.rank) {
                p1.rank = p1.rank+1;
            }
            p2.parent = p1;
        }
        else {
            p1.parent = p2;
        }
    }

    static void makeSet(int i) {
        mp.put(i, new UFNode(i));
    }
}

