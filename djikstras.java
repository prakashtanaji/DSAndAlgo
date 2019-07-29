import java.util.Queue;

class djikstras {
    public static void main(String[] args) {

        GraphD gd = new GraphD(5);
        gd.addEdge(0,1,5);
        gd.addEdge(0,2,2);
        gd.addEdge(2,4,1);
        gd.addEdge(2,3,4);
        gd.addEdge(3,4,2);
        gd.addEdge(4,0,1);

        Comparator<EdgeDist> cmp = new Comparator<EdgeDist>() {

            @Override
            public int toCompare(EdgeDist ed1, EdgeDist ed2) {
                return ed1.d = ed2.d;
            }
        };
        Queue<EdgeDist> q = new PriorityQueue<>(cmp);
        q.offer(new EdgeDist(2, 0));

        int[] dists = new int[5];
        boolean[] visited = new boolean[5];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[2] = 0;

        while(!q.isEmpty()) {
            EdgeDist curr = q.poll();
            if(visited[curr.e] == true) continue;

            visited[curr.e] = true;

            for(EdgeDist edges: gd.getEdges(curr.e)) {
                if(visited[edges.e] == true) continue;

                if(dist[edges.e] > edges.d + dist[curr.e]) {
                    dist[edges.e] = edges.d + dist[curr.e];
                }

                q.add(new EdgeDist(edges.e, dist[edges.e]));
            }
        }

        // print the list with min. distances;

    }
}

class EdgeDist {
    int e;
    int d;
    EdgeDist(int edge, int dist) {
        e = edge;
        d = dist;
    }
}

class GraphD {
    ArrayList<EdgeDist>[] v;

    public GraphD(int vSize) {
        v = new ArrayList<>[vSize];

        for(ArrayList<> a: v) {
            a = new ArrayList<>();
        }
    }

    public void addEdge(int vi, int e, int d) {
        v[vi].add(new EdgeDist(e, d));
    }

    public ArrayList<EdgeDist> getEdges(int vi) {
        return v[vi];
    }
}