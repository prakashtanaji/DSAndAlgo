import java.util.*;

class knapsack {
    public static void main (String[] args) {
        int[] wt = new int[] {2,1,3,4,2,3,2};

        int[] val = new int[] {1,2  ,3  ,2,1,4  ,1};

        int maxWt = 8;

        int[][] matrix = new int[wt.length][maxWt+1];
        
        for(int[] arr: matrix) {
            Arrays.fill(arr, 0);
        }

        // already sorted ids of Wt. array
        int[] sortedWt = new int[]{1,0,4,6,2,5,3};

        // for(int i = 0; i<matrix.length; i++) {
        //     matrix[i][0] = 0;
        // }
        
        for(int j = 1; j<matrix[0].length; j++) {
            if(wt[sortedWt[0]]<=j) {
                matrix[0][j] = val[sortedWt[0]];
            }
        }

        for(int i = 1; i< matrix.length; i++) {
            for(int j = 1; j<matrix[0].length; j++) {

                int valIncluding = 0;
                if(j>=wt[sortedWt[i]]) {
                    valIncluding = val[sortedWt[i]] + matrix[i-1][j-wt[sortedWt[i]]];
                }
                matrix[i][j] = Math.max(valIncluding, matrix[i-1][j]);
            }
        }


        int maxVal = matrix[wt.length-1][maxWt];

        System.out.println("max value is" + maxVal);

        System.out.println("Max value for Weights are");



        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

    }
}