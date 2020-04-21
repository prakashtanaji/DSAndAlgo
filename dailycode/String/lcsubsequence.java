import java.util.*;

import System.out;

class lcsubsequence {

    static int counter = 0;
    static char[] char1; 
    static char[] char2;

    //static int[][] matrix;

    public static void main(String[] args) {
        String s1 = "4jkdac";
        String s2 = "nsbnc";

        char1 = s1.toCharArray();
        char2 = s2.toCharArray();

        int[][] matrix = new int[s1.length()][s2.length()];

        for(int[] row: matrix) {
            Arrays.fill(row, -1);
        }

        int max = lcs(matrix, 0, char1.length-1, char2.length-1);

        System.out.println("Longest Common Subsequence is"+ max);
        System.out.println("total time:"+ counter);

        for(int[] row: matrix) {
            for(int i: row)
                System.out.print(" "+i);
            System.out.println();
        }

        printLCS(matrix);
    }

    static void printLCS(int[][] matrix) {
        int val = matrix[matrix.length-1][matrix[0].length-1];

        int i = matrix.length-1;
        int j = matrix[0].length-1;
        while(val>0) {
            System.out.print(" "+char2[j]);
            j--;
            i--;

            val--;
            while(j-1>=0) {
                if(matrix[i][j-1] != val) break;
                j--;
            }
            while(i-1>=0) {
                if(matrix[i-1][j] != val) break;
                i--;
            }
        }
    }

    static int lcs(int[][] matrix, int count, int c1, int c2) {
        counter++;
        if(c1<0 || c2<0) return count;
        if(matrix[c1][c2] !=-1) {
            return matrix[c1][c2];
        }

        int a=0, b=0, c=0;

        if(char1[c1]==char2[c2]) {
            a = 1 + lcs(matrix, count, c1-1, c2-1);
        }

        b = lcs(matrix, count, c1-1, c2);
        c = lcs(matrix, count, c1, c2-1);

        int maxHere = Math.max(a, Math.max(b,c));
        matrix[c1][c2] = maxHere;
        return matrix[c1][c2];
    }
}