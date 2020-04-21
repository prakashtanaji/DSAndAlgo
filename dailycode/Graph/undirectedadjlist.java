import java.util.*;

class undirectedadjlist {
    public static void main(String[] args) {
        int v = 5;

        Graph g = new Graph(v);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        
        int start = 1, end = 0;

        if(start >= g.V || end >= g.V) {
            System.out.println("Invalid input");
            return;
        }

        System.out.println("The BFS is" + bfs(g, start, end)); // runtime efficiency V^2, space V

        System.out.println("The DFS is" + dfs(g, start, end)); // runtime efficiency V^2, space V
    }

    static int bfs(Graph g, int start, int end) {
        int elementAccessCounter = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        Queue<Integer> dist = new LinkedList<Integer>();

        boolean[] visited= new boolean[g.V]; // false by default

        que.add(start);
        dist.add(0);
        visited[start] = true;

        int closestDist = -1;

        while(!que.isEmpty()) {
            elementAccessCounter++;

            int iCurr = que.poll();
            int currDist = dist.poll();

            if(iCurr == end) { closestDist = currDist; break; }

            for(int node: g.getEdges(iCurr)) {
                elementAccessCounter++;

                if(visited[node] == false) {
                    que.add(node);
                    dist.add(currDist+1);

                    visited[node] = true;

                }
            }
        }

        System.out.println("Total node access:" + elementAccessCounter);

        return closestDist;
    }

    static int dfs(Graph g, int start, int end) {
        int elementAccessCounter = 0;

        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> dist = new Stack<Integer>();

        boolean[] visited= new boolean[g.V]; // false by default

        st.add(start);
        dist.add(0);
        visited[start] = true;

        int closestDist = -1;

        while(!st.isEmpty()) {
            elementAccessCounter++;

            int iCurr = st.pop();
            int currDist = dist.pop();

            if(iCurr == end) { closestDist = currDist; break; }

            for(int node: g.getEdges(iCurr)) {
                elementAccessCounter++;

                if(visited[node] == false) {
                    st.push(node);
                    dist.push(currDist+1);

                    visited[node] = true;

                }
            }
        }

        System.out.println("Total node access:" + elementAccessCounter);

        return closestDist;
    }
}

class Graph {
    int V;
    ArrayList<Integer> adjList[];// = new ArrayList<Integer>[];

    public Graph(int v) {
        V = v;
        adjList = new ArrayList[v];

        for(int i=0; i<v; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int e) {
        adjList[v].add(e);
    }

    public ArrayList<Integer> getEdges(int v) {
        return adjList[v];
    }
}