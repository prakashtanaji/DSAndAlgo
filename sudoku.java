import java.util.*;

class sudoku {

    static final int N = 4;
    static int i = 0, j=0;
    public static void main(String[] args) {

        int[][] matrix = new int[][] {
            {0,0,0,3},
            {4,0,0,0},
            {0,2,0,1},
            {1,0,2,0}
        };
        int[][] fixed = new int[][]{
            {0,0,0,1},
            {1,0,0,0},
            {0,1,0,1},
            {1,0,1,0}
        };

        printMatrix(matrix);


        if(solveSUDOKU(matrix, fixed)){
            printMatrix(matrix);
        }
        else {
            System.out.println("Sudoku not solvable");
        }

    }

    static boolean solveSUDOKU(int[][] matrix, int[][] fixed) {

        // assign the fist value to 
        while(fixed[i][j] == 1) {
            i++;
        }
        matrix[i][j] = 1;

        while(i <N && j< N) {

            if(isValid(matrix, fixed)) {
                i++;
                if(i ==N) {
                    i=0;
                    j++;
                }

                printMatrix(matrix);
            }

            if(-1==setNext(matrix, fixed)) {
                // the matrix could not be set as the cell had the last posible value = 9
                backtrack(matrix, fixed);
            }
        }

        return true;
    }

    static boolean isValid(int[][] matrix, int[][] fixed) {
        // evaluate row

        boolean[] isSet = new boolean[N+1];
        Arrays.fill(isSet, false);

        for(int c=0; c<N; c++) {
            if(isSet[matrix[i][c]] && matrix[i][c] != 0)
                return false;

            isSet[matrix[i][c]] = true;
        }

        // evaluate column
        Arrays.fill(isSet, false);

        for(int r=0; r<N; r++) {
            if(isSet[matrix[r][j]] && matrix[r][j] != 0)
                return false;
            
            isSet[matrix[r][j]] = true;

        }

        // evaluate inner square
        Arrays.fill(isSet, false);

        int sqrt = (int)Math.sqrt(N);

        int iStart = (i/sqrt)*sqrt;
        int jStart = (j/sqrt)*sqrt;

        for(int r=iStart; r<iStart+sqrt; r++) {
            for(int c=jStart; c<jStart+sqrt; c++) {
                if(isSet[matrix[r][c]] && matrix[r][c] != 0)
                return false;
            
                isSet[matrix[r][c]] = true;
            }
        }

        return true;
    }

    static int setNext(int[][] matrix, int[][] fixed) {
        while(fixed[i][j] == 1) {
            i++;
            if(i==N) {
                i=0;
                j++;
            }
        }

        if(matrix[i][j] == N) {
            return -1;
        }
        matrix[i][j]++;
        return 0;
    }

    static void backtrack(int[][] matrix, int[][] fixed) {

        while(fixed[i][j]== 1 && matrix[i][j] == N) {
            if(fixed[i][j] == 1) {
                i--;
                if(i<0) {
                    i=N-1;
                    j--;
                }
                continue;
            }
            else {
                matrix[i][j] =0;
            }

            i--;
            if(i<0) {
                i=N-1;
                j--;
            }

            if(j<0)
            {
                System.out.println("No possile solution, ABORT !!!");
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        System.out.println("Printing Matrix:");

        for(int r=0; r<matrix.length; r++){
            for(int c=0; c<matrix[0].length; c++)
            {
                System.out.print(" "+matrix[r][c]);
            }
        }
        System.out.println();
    }
}