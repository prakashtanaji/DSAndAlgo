class interwaevingstrings {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "1234";
        String s3 = "a1b2cd34";

        boolean result = isInterleave(s1, s2, s3);

        System.out.println("The result is "+ result);
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length()+s2.length() != s3.length()) return false;
        
        if(s1 == null || s1.length()==0) { return s3.equals(s2); }
        if(s2 == null || s2.length()==0) { return s3.equals(s1); }
        
        boolean[][] result = new boolean[s1.length()+1][s2.length()+1];
        
        result[0][0] = true;
        
        for(int c = 1; c<=s1.length(); c++) {
            if(s1.charAt(c-1)== s3.charAt(c-1) && result[0][c])
            {
                result[0][c] = true;
            }
        }
        
        for(int r=1; r<=s2.length(); r++) {
            if(s2.charAt(r-1)== s3.charAt(r-1) && result[r][0])
            {
                result[r][0] = true;
            }
        }
        
        for(int i=1; i<=s2.length(); i++) {
            for(int j=1; j<s1.length(); j++) {
                if(s3.charAt(i+j-1) == s1.charAt(i-1)) {
                    result[i][j] = result[j-1][i];
                }
                else if(s3.charAt(i+j-1) == s2.charAt(j-1) && result[i][j] == false) {
                    result[i][j] = result[j][i-1];
                }
                else {
                    result[i][j] = false;
                }
            }
        }
        
        return result[s1.length()][s2.length()];
        
        
    }
}