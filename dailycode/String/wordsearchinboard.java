import java.util.*;

class wordsearchinboard {

    static int counter = 0;

    static char[][] board = new char[][] {  {'a','a','a'},
                                            {'a','a','a'},
                                            {'a','a','b'}};

    static boolean[][] cellUsed = new boolean[board.length][board[0].length];

    static int[] rowWise = new int[] {-1,0,+1,0};
    static int[] colWise = new int[] {0,+1,0,-1};
    public static void main(String[] args) {

        for(boolean[] cells: cellUsed) {
            Arrays.fill(cells, false);
        }

        String strInput = "aaaaaaaaa";

        if(board == null || board.length==0 || board[0].length==0) {
            System.out.println("The boardi s invalid");
            return;
        }

        if(strInput ==null || strInput.length() ==0) {
            System.out.println("Invalid Input");
            return;
        }

        // iterate through the board and find teh first char match

        char[] inputC = strInput.toCharArray();

        for(int i=0; i<board.length; i++) {
            for(int j =0; j<board[0].length; j++) {
                if(board[i][j] ==inputC[0] && dfs(board, i, j, inputC, 0)) {
                    System.out.println("Word exists");
                    return;
                }  
            }
        }

        System.out.println("Word not found");

        System.out.println("Counter times" + counter);
    }

    static boolean dfs(char[][] board, int i, int j, char[] input, int curr) {
        counter++;
        if(curr == input.length) {
            // can track the path in a different Point array
            return true;
        }
        if(i<0 || i==board.length || j<0 || j==board[0].length || cellUsed[i][j] == true)
        return false;

        if(board[i][j] == input[curr]) {
            cellUsed[i][j] = true;

            for(int sides=0; sides<rowWise.length; sides++) {
                if(dfs(board, i+rowWise[sides], j+colWise[sides], input, curr+1)) return true;
            }
            cellUsed[i][j] = false;
        }

        return false;
    }
}