import java.io;
import java.lang;
import java.util.*;

class longcommonsubstring {
    static char[] s1;
    static char[] s2;
    static int maxLCS = 0;

    static List<String> strLst = new ArrayList<String>();

    static int[][] arr;

    static int iCountRecurseCall =0;

    public static void main(String[] args) {
        System.out.println("Longest Common SubString problem");

        s1 = new char[]{'l','i','q'};
        s2 = new String("liliq").toCharArray();

        arr = new int[s1.length][s2.length];

        for(int[] arrSub: arr) {
            Arrays.fill(arrSub, -1);
        }

        int i = 0;
        if (s1.length>0 && s2.length>0) {
            //maxLCS = lcs(s1.length-1, s2.length-1, 0);
            i = lcsIt(s1.length, s2.length);
        }

        System.out.println("LCS is "+i+" with R calls:"+iCountRecurseCall);

        for(String str: strLst) {
            System.out.println(str);
        }
    }

    static int lcs(int i, int j, int count){

        

        if(i<0 || j<0) return count;

        String str = String.valueOf(s1[i]); 
        str+= String.valueOf(s2[j]);
        strLst.add(str);

        //if(arr[i][j] != -1) return arr[i][j];

        iCountRecurseCall++;

        int tempCount =0;

        if(s1[i] == s2[j]) {
            tempCount = lcs(i-1,j-1, 1 + count);
        }

        count = Math.max(tempCount, Math.max(lcs(i, j-1, 0), lcs(i-1, j, 0)));

        arr[i][j] = count;
        return count;
    }

    static int lcsIt(int iLen, int jLen) {

        int[][] arr = new int[iLen+1][jLen+1];

        for(int i =0; i<iLen+1; i++){
            for(int j =0; j<jLen+1; j++) {
                if(i==0 || j==0) {
                    arr[i][j] = 0;
                    System.out.print(" "+ arr[i][j]);
                    continue;
                }

                if(s1[i-1]==s2[j-1]) {
                    arr[i][j] = 1 + arr[i-1][j-1];
                }
                else {
                    arr[i][j] = 0;
                }

                maxLCS = Math.max(maxLCS, arr[i][j]);

                System.out.print(" "+ arr[i][j]);
            }
            System.out.println(" ***");
        }
        return maxLCS;

    }
}