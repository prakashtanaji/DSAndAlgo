import java.util.*;

class unDirectedHasCycleDFS {
    public static void main(String[] args) {

        GraphUnDirected g = new GraphUnDirected(6);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(2,5);
        g.addEdge(2,0);
        g.addEdge(3,2);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(4,3);
        g.addEdge(5,4);
        g.addEdge(5,2);
        g.addEdge(1,0);

       System.out.println(hasCycle(g));
    }

    static boolean hasCycle(GraphUnDirected g) {
        boolean visited[] = new boolean[g.v];
        Arrays.fill(visited, false);

        for (int i =0; i< g.v; i++)
        {
            if(visited[i] == true) continue;

            if(lookForCycle(i, i, visited, g) == true) return true;
        }

        return false;
    }

    static boolean lookForCycle(int currVertex, int comingFrom, boolean[] visited, GraphUnDirected g) {
        visited[currVertex] = true;

        for(int edge: g.getEdges(currVertex)) {
            if(edge == comingFrom) continue;
            if(visited[edge] == true) return true;

            if(lookForCycle(edge, currVertex, visited, g) == true) return true;
        }

        return false;
    }
}

class GraphUnDirected {
    int v;
    ArrayList<Integer> vertices[];

    public GraphUnDirected(int _v) {
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