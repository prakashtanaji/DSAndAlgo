class isRotatedPalindrome {
    public static void main(String[] args) {
        String str = "ba1ab";

        char[] chars = str.toCharArray();

        System.out.println("Is Rotated palindrome" + isrotatedpalin(chars));
    }

    static boolean isrotatedpalin(char[] chars) {
        if(ispalin(String.valueOf(chars))) return true;
        
        for(int i=0; i<chars.length-1; i++) {
            if(ispalin(String.copyValueOf(chars, i+1, chars.length-i-1)+String.copyValueOf(chars, 0, i+1))) return true;
        }

        return false;
    }

    static boolean ispalin(String str) {
        char[] chars = str.toCharArray();
        int i =0, j = chars.length-1;
        while(i<j) {
            if(chars[i] != chars[j]) return false;
            i++; j--;
        }

        return true;
    }
}