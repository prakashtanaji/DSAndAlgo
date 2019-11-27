import java.util.*;

class sumsubsets {
    // given an array of integers and value k, find out if there exists the combination of number from array which sum up to k
    public static void main(String[] args) {
        int[] arr = new int[] {4,4,2,6};
        int k = 14;

        Arrays.sort(arr);
        // 1 2 4 4 3,4,6,2

        boolean[][] bolExists = new boolean[arr.length][k+1];

        for(boolean[] bol: bolExists) {
            Arrays.fill(bol, false);
        }
        for(int i =0; i<arr.length; i++) {
            bolExists[i][0] = true;
        }

        // for(int j = 1; j<k+1; j++) {
        //     if(arr[0] == j) bolExists[0][j] = true;
        // }
        if(arr[0] <=k) bolExists[0][arr[0]] = true;

        if(arr.length > 1) {
            for(int i= 1; i<arr.length; i++) {
                for(int j = 1; j<k+1; j++) {
                    if(arr[i]>j) {
                        bolExists[i][j] = bolExists[i-1][j];
                    }
                    else {
                        bolExists[i][j] = bolExists[i-1][j-arr[i]];
                    }
                }
            }
        }

        for(int i = 0; i<arr.length; i++) {
            for(int j =0; j<k+1; j++) {
                System.out.print(" "+bolExists[i][j]);
            }
            System.out.println();
        }

        // the value at the bottom right indicates with sub set sum is equal to K
    }
}