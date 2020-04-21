import java.util.*;

class undirectedadjmatrix {
    public static void main(String[] args) {
        // int n = 5;
        int[][] adjmatrix = new int[][] {   {0,1,0,0,1},
                                            {1,0,0,1,0}, 
                                            {0,0,0,1,1}, 
                                            {0,1,1,0,0}, 
                                            {1,0,1,0,0}};

        int start = 1, end = 4;

        // if(start >= adjmatrix.length || end >= adjmatrix.length) {
        //     System.out.println("Invalid input");
        //     return;
        // }

        System.out.println("The BFS is" + bfs(adjmatrix, start, end)); // runtime efficiency V^2, space V

        System.out.println("The DFS is" + dfs(adjmatrix, start, end)); // runtime efficiency V^2, space V
    }

    static int bfs(int[][] adjmatrix, int start, int end) {
        int elementAccessCounter = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        Queue<Integer> dist = new LinkedList<Integer>();

        boolean[] visited= new boolean[adjmatrix.length]; // false by default

        que.add(start);
        dist.add(0);
        visited[start] = true;

        int closestDist = -1;

        while(!que.isEmpty()) {
            elementAccessCounter++;

            int iCurr = que.poll();
            int currDist = dist.poll();

            if(iCurr == end) { closestDist = currDist; break; }

            for(int i=0; i< adjmatrix.length; i++) {
                elementAccessCounter++;

                if(adjmatrix[iCurr][i] == 1 && visited[i] == false) {
                    que.add(i);
                    dist.add(currDist+1);

                    visited[i] = true;

                }
            }
        }

        System.out.println("Total node access:" + elementAccessCounter);

        return closestDist;
    }

    static int dfs(int[][] adjmatrix, int start, int end) {
        int elementAccessCounter = 0;

        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> dist = new Stack<Integer>();

        boolean[] visited= new boolean[adjmatrix.length]; // false by default

        st.add(start);
        dist.add(0);
        visited[start] = true;

        int closestDist = -1;

        while(!st.isEmpty()) {
            elementAccessCounter++;

            int iCurr = st.pop();
            int currDist = dist.pop();

            if(iCurr == end) { closestDist = currDist; break; }

            for(int i=0; i< adjmatrix.length; i++) {
                elementAccessCounter++;

                if(adjmatrix[iCurr][i] == 1 && visited[i] == false) {
                    st.push(i);
                    dist.push(currDist+1);

                    visited[i] = true;

                }
            }
        }

        System.out.println("Total node access:" + elementAccessCounter);

        return closestDist;
    }
}