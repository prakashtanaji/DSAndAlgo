import static java.lang.System.out;

class rotatematrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2, 3, 10},
            {4, 5, 6, 11},
            {7, 8, 9, 12},
            {14, 15, 16, 13}
        };

        out.println("print matrix1");
        printMatrix(matrix);

        int topRight = 0;
        int rightDown = 0;
        int bottomLeft = matrix[0].length -1;
        int leftUp = matrix[0].length -1;
        while(topRight < bottomLeft) {
            rotateMatrix(matrix, topRight, rightDown, bottomLeft, leftUp);
            topRight++;
            rightDown++;
            bottomLeft--;
            leftUp--;

            out.println("print matrix2");
            printMatrix(matrix);
        }

        // out.println("print matrix2");
        // printMatrix(matrix);
    }

    static void printMatrix(int[][] matrix) {
        for(int i =0; i< matrix.length; i++) {
            for(int j =0; j< matrix.length; j++) {
                out.print(matrix[i][j] + " ");
            }
            out.println();
        }
    }

    static void rotateMatrix(int[][] matrix, int tR, int rB, int bL, int lU) {
        int tRFixed = tR;
        int bLFixed = bL;
        int rBFixed = rB;
        int lUFixed = lU;

        for(int i = tRFixed; i< bLFixed; i++) {
            int t1 = matrix[rBFixed][tR];
            int t2 = matrix[rB][bLFixed];
            int t3 = matrix[lUFixed][bL];
            int t4 = matrix[lU][tRFixed];

            matrix[rBFixed][tR] = t4;
            matrix[rB][bLFixed] = t1;
            matrix[lUFixed][bL] = t2;
            matrix[lU][tRFixed] = t3;

            tR++;
            rB++;
            bL--;
            lU--;
        }

        // printMatrix(matrix);
    }
}