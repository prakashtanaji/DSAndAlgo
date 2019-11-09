/* Given a string pattern and a bigger string, find the staring index of the pattern in bigger string if exists, otherwise retrun -1;
*/

import java.util.*;
class strstr {

    static int timeCounter =0 ;
    
    public static void main(String[] args) {
        String pattern = "ababababababababacdcbabcefabc";
        String sentence = "abababababababababcabcdababababababababababababaababababababababababababababababbabababcbadaababababababababdsfbcefaklshababababababababababcdcbacdabcdabcdcbaababcdcbacabcdabcababcdcbacdabcababcdcbacdababcdcbacabcdabcabcdabcabcefSAabcdababababababababacdcbabcefabcabFGcefabcdabcASDefabcRTYdabcefabcdabceffkdhjkdhfjkhdjkfhjkhsdjkhsjadhhjghgdGHGHbcabcdasdfbcefabcadfbcdabcabcdabcefabcefabcabcdabcdcbabcefabcabcefadbcabcdasfbcefabcabcdabdfcefabc";

        if(pattern == null || pattern == "" || sentence == null || sentence=="" || pattern.length()>sentence.length()) {
            System.out.println("No  sub string possible");
        }

        timeCounter =0;

        int index = 0;
        index = startIndexNaive(pattern, sentence);

        System.out.println("The naive method returned " +  index + ", with time counter :" + timeCounter);


        timeCounter =0;

        index = startIndexKMP(pattern, sentence);

        System.out.println("The kmp algorithm method returned " +  index + ", with time counter :" + timeCounter);
    }

    static int startIndexKMP(String pattern, String sentence) {

        // just compare the string directly and return result
        if(pattern.length()<=2) return -1;

        // pre-processing the pattern to create the longest prefix suffix 

        char[] cPattern = pattern.toCharArray();
        int[] iPattern = new int[cPattern.length+1];
        Arrays.fill(iPattern, 0);
        int i = 1;
        int j =2;

        while(j<iPattern.length) {
            //timeCounter++;
            if(cPattern[i-1] == cPattern[j-1]) {
                iPattern[j] = iPattern[j-1] +1;
                i++;
                j++;
            }
            else {
                if(i==1) j++;
                else i = iPattern[i]+1;
            }
        }

        for(int lps: iPattern) {
            System.out.print(" "+ lps);
        }

        char[] cSentence = sentence.toCharArray();

        int iCursor = 0;
        int jCursor = 0;
        while(jCursor < cSentence.length)  {
            timeCounter++;

            if(iCursor== cPattern.length) {
                return jCursor-cPattern.length;
            }

            if(cPattern[iCursor] == cSentence[jCursor]) {
                iCursor++;
                jCursor++;
            }
            else {
                if(iCursor == 0) {
                    jCursor++;
                }
                else {
                    iCursor = iPattern[iCursor];
                }
            }
        }

        return -1;
    }

    static int startIndexNaive(String pattern, String sentence) {

        for(int i =0; i<=sentence.length()-pattern.length(); i++) {

            if(isMatch(pattern, sentence.substring(i, i+pattern.length()))) return i;
        }
        return -1;
    }

    static boolean isMatch(String pattern, String sentence) {

        char[] cPattern = pattern.toCharArray();
        char[] cSentence = sentence.toCharArray();

        for(int i =0; i<cPattern.length; i++) {
            timeCounter++;
            if(cPattern[i] != cSentence[i]) {
                
                return false;
            }
        }

        return true;
    }

}