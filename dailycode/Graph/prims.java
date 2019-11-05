import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.*;

class prims {
    public static void main(String[] args) {

        GraphP gp = new GraphP(5);

        gp.addEdge(0, 1, 4);
        gp.addEdge(0, 2, 2);
        gp.addEdge(2, 0, 2);
        gp.addEdge(2, 3, 6);
        gp.addEdge(2, 4, 5);
        gp.addEdge(1, 0, 4);
        gp.addEdge(1, 3, 2);
        gp.addEdge(3, 2, 6);
        gp.addEdge(3, 1, 2);
        gp.addEdge(4, 2, 5);

        int vertexStart = 4;

        PriorityQueue<Map.Entry<Integer, EdgeP>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, EdgeP>>() {

                @Override
                public int compare(Map.Entry<Integer, EdgeP> e1, Map.Entry<Integer, EdgeP> e2) {
                    return e1.getValue().wt - e2.getValue().wt;
                }
            });
        Set<Integer> st = new HashSet<Integer>();
        Set<EdgeP> resultEdges = new HashSet<>();

        //Map.Entry<Integer, Integer> entry0= new AbstractMap.SimpleEntry<>(1,1);
        
        pq.add(new AbstractMap.SimpleEntry<Integer, EdgeP>(vertexStart, new EdgeP(vertexStart, 0)));

        while(!pq.isEmpty() && st.size()!= gp.V) {
            Map.Entry<Integer, EdgeP> entry = pq.poll();
            resultEdges.add(new EdgeP(entry.getKey(), entry.getValue().dest));

            for(EdgeP edge: gp.getEdges(entry.getKey())) {
                if(st.contains(edge.dest)) continue;
                pq.add(new AbstractMap.SimpleEntry<Integer, EdgeP>(edge.dest, new EdgeP(entry.getKey(), edge.wt)));
            }

            st.add(entry.getKey());
        }

        Iterator it = resultEdges.iterator();
        while(it.hasNext()) {
            EdgeP ep = (EdgeP)it.next();
            // note: we repurposed EdgeP !
            System.out.println(":"+ep.dest+":"+ep.wt);
        }
    }
}

class GraphP {
    int V;
    List<EdgeP> lst[];

    public GraphP(int v) {
        V = v;
        lst = new List[v];

        for(int i =0; i<v; i++) {
            lst[i] = new ArrayList<>();
        }
    }

    public List<EdgeP> getEdges(int v) {
        return lst[v];
    }

    public void addEdge(int v, int e, int wt) {
        lst[v].add(new EdgeP(e, wt));
    }
}

class EdgeP {
    int dest;
    int wt;
    public EdgeP(int _d, int _w) {
        dest = _d;
        wt = _w;
    }
}