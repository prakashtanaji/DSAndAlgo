/*
Given a dictionary of valid words and a string,
find the longest possible meaningful sentence that can be formed from the string
*/

import java.util.*;

class wordbreak {

    static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {

        dictionary.add("i");
        dictionary.add("live");
        dictionary.add("in");
        dictionary.add("seattle");
        dictionary.add("a");
        dictionary.add("house");
        dictionary.add("near");

        String word = "ilivenearseattlearea";

        boolean[][] matrix = new boolean[word.length()-1][word.length()-1];

        for(boolean[] bol: matrix) {
            Arrays.fill(bol, false);
        }

        char[] cWord = word.toCharArray();

        // for each of the possible length of the sentence within the given word
        for(int i =1; i<=cWord.length; i++) {
            for(int j=0; j<cWord.length; j++) {
                String subword = String.copyValueOf(cWord, j, i);
                if(dictionary.contains(subword)) {
                    matrix[j][i-1] = true;
                }
                else {
                    // run sub string logic
                    // here we will divide the currently being evaluated subtring into two parts, 
                    // if first part is alreday true/meaningful, then teh 2nd part will be tested 
                    // to be meaningful from previous check. If both are true then the full substring will be true.
                    for(int p=j; p<j+i; p++) {
                        int maxlength=1;
                        while(maxlength < i) {
                            if(matrix[j][j+maxlength-1]== true) {
                                if(matrix[j+maxlength][j+maxlength+i-maxlength] == true) {
                                    matrix[j][i-1] = true;
                                    break;
                                }
                            }
                            maxlength++;
                        }
                        if(matrix[j][i-1] == true) 
                            break;
                    }
                }
            }
        }

        for(boolean[] bol: matrix) {
            for(boolean bolVal: bol) {
                System.out.print(" " + (bolVal? "T":"F"));
            }
            System.out.println();
        }
        
    }
}