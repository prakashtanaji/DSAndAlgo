import java.util.*;

public class longestsubstrwithkmaxunique {
    public static void main(String[] args) {
        String s = "aabachdghg";
        int k = 2;

        int max = Integer.MIN_VALUE;

        // left   right   distinct 
        // 0  0    0
        // 0  1    1
    
        int left=0,right =0;
        int[] cCount = new int[26];
        Arrays.fill(cCount, 0);
        int distinctChars = 0;
        while(right < s.length()) {
            if(distinctChars<=k) {
                char curr = s.charAt(right);
                cCount[(int)curr-97]++;
                right++;
                if(cCount[(int)curr-97] == 1) {
                    distinctChars++;     
                }
            }
            else {
                char curr = s.charAt(left);
                cCount[(int)curr-97]--;
                left++;
                if(cCount[(int)curr-97] == 0) {
                    distinctChars--;
                }
            }
            if(distinctChars == k) {
                max = Math.max(max, right-left);
            }
        }

        System.out.println("max sub array with max k unique chars is "+ max);
        
    }

}