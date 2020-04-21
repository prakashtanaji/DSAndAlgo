class Solution
{

    static int find = 15;

    static int[][] twoDArray = new int[][] {{1,2,9},{2,3,15},{16,17,18}};
    public static void main(String[] args) {
        

        //int find = 15;

        System.out.println("The result is" + findTarget(0, twoDArray.length-1, 0, twoDArray[0].length));
    }

    static boolean findTarget(int top, int down, int left, int right) {

        int row = top;
        int col = left;
        while(row<=down && col <=right) {

            if(twoDArray[row][col] == find) return true;

            if(twoDArray[row][col] > find) 
                return findTarget(top, row-1, col, right) || findTarget(row, down, left, col-1);
            row++;
            col++;

        }

        return false;
    }
}