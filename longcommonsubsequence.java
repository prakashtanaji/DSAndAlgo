import java.util.*;

public class longcommonsubsequence {

    static char[] s1 = {'c','d','c'};
    static char[] s2 = new String("c58965").toCharArray();
    static int iTotalCalls = 0;
    static int iPrintCalls = 0;
    static int[][] arr;

    static Set<String> st = new HashSet<>();
    public static void main(String[] args) {
        System.out.println("lc sub sequence");

        arr = new int[s1.length+1][s2.length+1];

        for(int[] a: arr) {
            Arrays.fill(a, -1);
        }

        //int iRet = lcsRecursive(s1.length-1, s2.length-1, 0);
        int iRet = lcsRecursiveIt(s1.length, s2.length);

        System.out.println("Max SubSeq ="+iRet + " , recurseCalls="+ iTotalCalls);
        
    }

    static int lcsRecursiveIt(int s1Size, int s2Size) {

        int iMax = 0;
        for(int i=0; i<=s1Size; i++){
            for(int j=0; j<=s2Size; j++){
                if(i==0 || j== 0){ arr[i][j] =0; continue; }

                iTotalCalls++;

                if(s1[i-1] == s2[j-1]) {
                    arr[i][j] = arr[i-1][j-1] +1;
                }
                else {
                    arr[i][j] = Math.max(arr[i][j-1],arr[i-1][j]);
                }
                iMax = Math.max(iMax, arr[i][j]);
            }
        }

        StringBuilder strBld = new StringBuilder();
        // Printing the total combinations
        for(int i=0; i<=s1Size; i++){
            for(int j=0; j<=s2Size; j++){
                if(i==0 || j== 0){ arr[i][j] =0; continue; }

                    //System.out.print(" " +arr[i][j]);
                    strBld.append(" "+arr[i][j]);
                    //System.out.println(strBld.toString());

            }

            System.out.println(strBld.toString());
            strBld.setLength(0);
        }

        // String str = printlcs(arr.length-1, arr[0].length-1, iMax);
        // System.out.println(" longest LCS is:"+str+": foundin steps"+iPrintCalls);

        printlcsAll(arr.length-1, arr[0].length-1, iMax, "");

        System.out.println(" longest LCS All:");
        for(String s: st) {
            System.out.println(s);
        }
        System.out.println(" longest LCS(all) found in steps"+iPrintCalls);

        return iMax;
    }

    // efficiency to get atlest one longest is m-k+n-k
    static void printlcsAll(int i, int j, int iMax, String ids) {

        if(iMax == 0) {

            st.add(ids);
            return;
        };

        if(arr[i][j]< iMax || (i<1 || j<1)) {
            return;//System.out.println("-Something wrong lcs");
        }



        iPrintCalls++;

        if(s1[i-1] == s2[j-1] && arr[i][j] == iMax) {
            printlcsAll(i-1, j-1, iMax-1, String.valueOf(i-1)+String.valueOf(j-1)+ids);
        }
        printlcsAll(i-1, j, iMax, ids);
        printlcsAll(i, j-1, iMax, ids);
    }

    // efficiency to get atlest one longest is m-k+n-k
    static String printlcs(int i, int j, int iMax) {

        if(iMax!=0 &&(i<1 || j<1)) {
            System.out.println("-Something wrong lcs");
        }

        if(iMax == 0) return "";

        //iPrintCalls++;

        if(s1[i-1] == s2[j-1]) {
            return printlcs(i-1, j-1, iMax-1) + s1[i-1];
        }
        if(arr[i-1][j]> arr[i][j-1]) {
            return printlcs(i-1, j, iMax);
        }
        return printlcs(i, j-1, iMax);
    }

    static int lcsRecursive(int i, int j, int count) {
        if(i<0 || j<0) return count;

        // top down approach with memoization
        if(arr[i][j] != -1) return arr[i][j];

        iTotalCalls++;// 28

        int iTemp = 0;
        if(s1[i]==s2[j]) {
            iTemp = lcsRecursive(i-1, j-1, count+1);
        }

        int l = lcsRecursive(i, j-1, count);
        int r = lcsRecursive(i-1, j, count);

        count = Math.max(iTemp, Math.max(l, r));

        arr[i][j] = count;

        return count;
    }

}