import java.util.*;

class minsubarray {

    static int iLastEver = Integer.MAX_VALUE;
    static int iMinEver = Integer.MAX_VALUE;
    static int executedMethod = 0;

    static int[] memoize;
    
    public static void main(String[] args) {
        String s1 = "ab1a";
        String s2 = "ab";

        Map<Character, Boolean> mp = new HashMap<>();

        for(char c: s2.toCharArray()) {
            mp.put(c, false);
        }

        memoize = new int[s1.length()];
        Arrays.fill(memoize, -1);

        //iList = s1.length-1;

        int iMinLen = getMinArray(mp, s1.toCharArray(), 0, s1.length()-1, s1.length()-1);

        for(int i = 0; i<s1.length(); i++) {
            System.out.print(" "+memoize[i]);
        }

        System.out.println("The min. length of the sub array"+ iMinLen +":"+iLastEver+":"+executedMethod);
    }

    static int getMinArray(Map<Character, Boolean> mp, char[] arr, int size, int iCurr, int iLast) {
    
        

        if(size == mp.size()) {
            int iLength = (iLast - iCurr);
            if(iLength < iMinEver) {
                iLastEver = iLast;
                iMinEver = iLength;
            }
            return (iLast - iCurr);
        }

        if(iCurr + 1 < mp.size()-size) return Integer.MAX_VALUE;

        //if(iCurr>=0 && memoize[iCurr] != -1) return memoize[iCurr];

        executedMethod++;

        int iNow1 = Integer.MAX_VALUE;
        int iNow2 = Integer.MAX_VALUE;
        if(mp.containsKey(arr[iCurr]) && mp.get(arr[iCurr]) == false) {
            mp.put(arr[iCurr], true);

            int last = iLast;
            if(size == 0) {
                last = iCurr;
            }
            iNow1 = getMinArray(mp, arr, size+1, iCurr-1, last);

            mp.put(arr[iCurr], false);
        }
        // else {
        //     iNow1 = getMinArray(mp, arr, size, iCurr-1, iLast);
        // }

        //if(size == 0) {
            iNow2 = getMinArray(mp, arr, size, iCurr-1, iLast);
        //}

        memoize[iCurr] = Math.min(iNow1, iNow2);
        return Math.min(iNow1, iNow2);
    }
}