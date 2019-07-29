import static java.lang.System.out;

class rotatespiral {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2, 3, 10},
            {4, 5, 6, 11},
            {7, 8, 9, 12}
        };

        out.println("print matrix1");
        printMatrix(matrix);

        int topRight = 0;
        int rightDown = 0;
        int bottomLeft = matrix[0].length -1;
        int leftUp = matrix.length -1;
        while(topRight < bottomLeft && rightDown < leftUp) {
            printCircle(matrix, topRight, rightDown, bottomLeft, leftUp);
            topRight++;
            rightDown++;
            bottomLeft--;
            leftUp--;
        }
        if(topRight < bottomLeft) {
            printVertical(matrix, topRight, bottomLeft);
        }
        else if(rightDown < leftUp) {
            printHorizontal(matrix, rightDown, leftUp);
        }
    }

    static void printVertical(int[][] matrix, int topRight, int bottomLeft) {
        for(int i = topRight; i< bottomLeft; i++) {
            out.print(matrix[i][matrix[0].length/2] +" ");
        }
    }

    static void printHorizontal(int[][] matrix, int rightDown, int leftUp) {
        for(int i = rightDown; i< leftUp; i++) {
            out.print(matrix[matrix.length/2][i] +" ");
        }
    }

    static void printMatrix(int[][] matrix) {
        for(int i =0; i< matrix.length; i++) {
            for(int j =0; j< matrix[0].length; j++) {
                out.print(matrix[i][j] + " ");
            }
            out.println();
        }
    }

    static void printCircle(int[][] matrix, int tR, int rD, int bL, int lU) {
        // int tRFixed = tR;
        // int bLFixed = bL;
        // int rBFixed = rD;
        // int lUFixed = lU;

        for(int i = tR; i< bL; i++) {
            out.print(matrix[rD][i] +" ");
        }

        for(int i = rD; i< lU; i++) {
            out.print(matrix[i][bL] +" ");
        }

        for(int i = bL; i> tR; i--) {
            out.print(matrix[lU][i] +" ");
        }

        for(int i = lU; i> rD; i--) {
            out.print(matrix[i][tR] +" ");
        }
        // printMatrix(matrix);
    }
}