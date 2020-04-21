import java.util.*;

class longestvalidparen {
    public static void main(String[] args) {
        String paren = ")(((()))()))()";


        if(paren == null || paren == "" || paren.length() == 1) {
            return;
        }

        int countLongest = longestparen(paren);

        System.out.println("Longest valid parenthesis is "+ countLongest);
    }

    static int longestparen(String paren) {
        char[] cParen = paren.toCharArray();
        int[] iParen = new int[cParen.length];


        Arrays.fill(iParen, 0);

        for(int i = 1; i<iParen.length; i++) {

            if(cParen[i] == '(') continue;

            if(cParen[i-1] == '(') {
                if(i-1-1 >=0){
                    iParen[i] = iParen[i-1-1] +1;
                }
                else {
                    iParen[i] = 1;
                }
            }
            else {
                // when its ")"
                if(iParen[i-1]!=0) {
                    if(i-iParen[i-1]*2-1>=0) {
                        if(cParen[i-iParen[i-1]*2-1] == '(') {
                            iParen[i] = iParen[i-1]+1;
                        }
                    }
                }
            }
        }

        int max = 0;
        for(int i = 1; i<iParen.length; i++) {
            if(iParen[i] >max) max = iParen[i];
        }
        return max;
    }
}