
class maxareainkmatrix {
    static final int N = 4;
    static final int K = 3;
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                    {1,-5,8,4},
                    {-9,5,-6,3},
                    {-8,9,-2,7},
                    {-7,3,8,-2}
                };

        System.out.println("Find max area in size k"); 

        // find all horizonal 1 row sums of size k from 0,0 to (N-K),(N-K)
        int[][] horzSum = new int[N-K+1][N-K+1];

        calHorzSum(matrix, horzSum);




    }

    static void calHorzSum(int[][] matrix, int[][] horzSum) {
        for (int r=0; r<=N-K; r++) {
            // calculate for first left most 
        }
    }
}