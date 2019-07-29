import java.util.*;

class minsubarraymemo {

    static int iLastEver = -1;
    static int iMinEver = Integer.MAX_VALUE;
    static int executedMethod = 0;

    static int[] memoize;
    
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";

        System.out.println("The min. length of the sub array"+ minWindow(s1, s2));
    }
    static String minWindow(String s, String t) {

        // if(mp.size()>s.length()) {
        //     return "";
        // }
        
        
        int iMinForEver = Integer.MAX_VALUE;
        int iLeftForEver = 0;
        
        int iLeft = 0;
        int iRight = 0;
        char[] chars = s.toCharArray();
        
        Map<Character, Integer> mp = new HashMap<>();
        
        for(char c: t.toCharArray()) {
            mp.put(c, 0);
        }

        int iCount = mp.size();
        
        boolean isRightMoved = true;
        
        while(iRight<s.length()) {
            
           if(isRightMoved) {
                if(mp.containsKey(chars[iRight])) {
                    mp.put(chars[iRight], mp.get(chars[iRight]) +1);

                    if(mp.get(chars[iRight]) == 1) {
                        iCount--;
                    }
                }
            }
            else {
                if(mp.containsKey(chars[iLeft-1])) {
                    mp.put(chars[iLeft-1], mp.get(chars[iLeft-1]) - 1);

                    if(mp.get(chars[iLeft-1]) == 0) {
                        iCount++;
                    }
                }
            }
            
            if(iCount == 0) {
                if(iRight-iLeft+1 < iMinForEver) {
                    iMinForEver = iRight-iLeft+1;
                    iLeftForEver =  iLeft;
                }
                
                if(iLeft == iRight) {
                    iLeft++; iRight ++;
                    isRightMoved = true;
                }
                else {
                    iLeft++;
                    isRightMoved = false;
                }
            }
            else {
                isRightMoved = true;
                iRight++;
            }
            

        }
        if(iMinForEver != Integer.MAX_VALUE) {         
            return s.substring(iLeftForEver, iLeftForEver+iMinForEver);
        }
        else return "";
        
    }
}