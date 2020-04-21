import java.util.*;
public class nqueen {
    public static void main(String[] args) {
        int N = 4;

        if(N<4) {
            System.out.println("Not possible");
            return;

        }

    
       int[][] mat = new int[N][N];

       for(int[] row: mat) {
           Arrays.fill(row, 0);
       }

       Integer c=0, r=0;
       boolean res = false;
       while(c<N && r<N) {

            mat[r][c]=1;
            res = isValid(mat, c, r);

            if(res == true) {
                progress(N, c, r);
            }
            else {
                backtrack(mat, c, r);
            }
       }
       if(res == true) {
           print(mat);
       }
       else {
           System.out.println("N queen cannot be solved");
       }
    }

    static void print(int[][]mat) {
        for(int i=0; i< mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                System.out.print(" "+ mat[i][j]);
            }
            System.out.println();
        }
    }

    static boolean isValid(int[][] mat, int c, int r) {
        int rCurr = r-1, cCurr =c-1;
        while(rCurr>=0 && cCurr>=0) {
            if(mat[rCurr][cCurr] == 1)
                return false;
            rCurr--; cCurr--; 
        }

        rCurr = r+1; cCurr =c-1;
        while(rCurr<mat.length && cCurr>=0) {
            if(mat[rCurr][cCurr] == 1)
                return false;
            rCurr++; cCurr--; 
        }

        rCurr = r; cCurr =c-1;
        while(cCurr>=0) {
            //if(cCurr == c) continue;
            if(mat[rCurr][cCurr] == 1)
                return false;
            cCurr--;
        }

        rCurr = 0; cCurr =c;
        while(rCurr<mat.length) {
            if(rCurr == r) {
                rCurr++;
                continue;
            }
            if(mat[rCurr][cCurr] == 1)
                return false;
            rCurr++;
        }

        return true;
    }

    static void progress(int N, Integer c, Integer r) {
        r++;
        c = 0;
    }

    static void backtrack(int[][] mat, Integer c, Integer r) {
        Arrays.fill(mat[r], 0);
        c++;
        while(c==mat.length) {
            r--;
            Arrays.fill(mat[r], 0);
            for(int i = 0; i<mat.length; i++) {
                if(mat[i][c] == 1) {
                    c = i;
                    break;
                }
            }
            // get curr c in this row and increment
            c++;
        }
    }
}