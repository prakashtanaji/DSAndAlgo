import java.util.*;

class isomorphic {

    public static void main(String[] args) {

        System.out.println(isIsomorphic("add", "dgg"));

    }
    public static boolean isIsomorphic(String s, String t) {
        int[] charMapTo = new int[26];
        int[] charMapFrom = new int[26];
        Arrays.fill(charMapTo, -1);
        Arrays.fill(charMapFrom, -1);
        
        int iTo = -1, iFrom = -1;
        for(int i=0; i< s.length(); i++) {
            iTo = (int)s.charAt(i)-97;
            iFrom = (int)t.charAt(i)-97;
            
            if(charMapTo[iTo] == -1 && charMapFrom[iFrom] == -1) {
                charMapTo[iTo] = iFrom;
                charMapFrom[iFrom] = iTo;
            }
            else if(charMapTo[iTo] != -1 && charMapFrom[iFrom] != -1) {
                if(charMapTo[iTo] != iFrom || charMapFrom[iFrom] != iTo) return false;
            }
            else {
                return false;
            }
        }
        
        return true;
        
    }
}