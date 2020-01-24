import java.util.*;

class maxSquare {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1,0,1,0},
            {1,0,1,1},
            {1,0,1,1},
            {1,1,1,1}
            // {1,0,1,0,0},
            // {1,0,1,1,1},
            // {1,0,1,1,1}
        };

        System.out.println(maximalSquare(matrix));
    }
    static int maximalSquare(int[][] matrix) {
        
        if(matrix == null || matrix.length ==0 || matrix[0].length== 0) return 0;
        
        int[] histo = new int[matrix[0].length];
        for(int i=0; i<matrix[0].length; i++) {
            histo[i] = matrix[0][i];
        }
        
        int maxSquare = maxHistoSquare(histo);
        
        if(matrix.length==1) return maxSquare;
        
        for(int j=1; j< matrix.length; j++) {
            for(int i=0; i<matrix[j].length; i++) {
                int val = matrix[j][i];
                if(val == 0) {
                    histo[i] = 0;    
                }
                else {
                    histo[i] = val + histo[i];
                }
            }
            
            maxSquare = Math.max(maxSquare, maxHistoSquare(histo));
        }
        
        return maxSquare;
    }
    
    static int maxHistoSquare(int[] histo) {
        
        int maxSquareSide = 0;
        Stack<Integer> st = new Stack<>();
        
        st.add(0);
        
        // todo handle edge case where only 1 element
        int i = 0;
        for(i=1; i<histo.length; i++) {
            int itop = st.peek();
            
            if(histo[itop] <= histo[i]) {
                st.add(i);
            }
            else {
                
                while(!st.empty()) {
                    itop = st.peek();     
                    if(histo[itop] > histo[i]) {

                        int dist = i - itop;
                        int valAtiTop = histo[itop];
                        maxSquareSide = Math.max(maxSquareSide, Math.min(dist, valAtiTop));
                        st.pop();
                        continue;
                    }

                    break;
                }
                
                st.add(i);
            }
        }
        
        int itop =0 ;
        
        
        while(!st.empty()) {
            itop = st.pop();
            int dist = i-itop;
            int valAtiTop = histo[itop];
            
            maxSquareSide = Math.max(maxSquareSide, Math.min(dist, valAtiTop));
            
        }
        
        return maxSquareSide;
        
    }
}