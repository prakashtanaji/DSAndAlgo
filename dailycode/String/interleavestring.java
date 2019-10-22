import javax.print.attribute.standard.MediaSize.Engineering;

class interleavestring {
        static String s1 = "abcd3";
        static String s2 = "xyz14";
        static String sAll = "abcxyzd314";

        static char[] sTemp;

        static int iItemCounter=0;

    public static void main(String[] args) {

        sTemp = new char[sAll.length()];

        boolean result = isInterleave1(-1, -1, -1);

        System.out.println(" String is interleave?"+ result);
        System.out.println(" No. of iterations"+ iItemCounter);

        iItemCounter = 0;
        result = isInterleave2Matrix();
        System.out.println(" String is interleave2?"+ result);
        System.out.println(" No. of iterations"+ iItemCounter);


    }

    static boolean isInterleave1(int currRes, int s1Curr, int s2Curr) {

        iItemCounter++;
        if(currRes>=0 && !String.valueOf(sTemp).substring(0,currRes+1).equals(sAll.substring(0,currRes+1))) {
            return false;
        }
        if(currRes==sTemp.length-1) {
            if(sAll.equals(String.valueOf(sTemp))) return true;

            return false;
        }

        boolean b1=false, b2=false;

        if(s1Curr<s1.length()-1) {
            sTemp[++currRes] = s1.charAt(++s1Curr);
            b1 = isInterleave1(currRes, s1Curr, s2Curr);

            --currRes; --s1Curr;
        }

        if(s2Curr<s2.length()-1) {
            sTemp[++currRes] = s2.charAt(++s2Curr);
            b2 = isInterleave1(currRes, s1Curr, s2Curr);

            --currRes; --s2Curr;
        }

        return b1 || b2;
    }

    static boolean isInterleave2Matrix() {

        boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];
        matrix[0][0] = true;
        for( int i = 1; i<= s1.length(); i++) {
            iItemCounter++;
            if((sAll.charAt(i-1) == s1.charAt(i-1)) && matrix[0][i-1] == true)
                matrix[0][i] = true;
        }

        for( int i = 1; i<= s2.length(); i++) {
            iItemCounter++;
            if((sAll.charAt(i-1) == s2.charAt(i-1)) && matrix[i-1][0] == true)
                matrix[i][0] = true;
        }

        for(int i = 1; i<= s2.length(); i++) {
            for(int j =1; j<=s1.length(); j++) {
                iItemCounter++;
                if(sAll.charAt(i+j-1) == s1.charAt(j-1) && matrix[i][j-1]) {
                    matrix[i][j] = true;
                }

                if(!matrix[i][j]) {
                    if(sAll.charAt(i+j-1) == s2.charAt(i-1) && matrix[i-1][j]) {
                        matrix[i][j] = true;
                    }
                }
            }
        }

        return matrix[s2.length()][s1.length()];
    }
}