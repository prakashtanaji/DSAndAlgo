class Solution {

    static String s2 = "yuwhxabdjkjsd";
    public static void main(String[] args) {
        String s1 = "bda";

        return isPermute(s1.toCharArray(), 0);
        
    }

    static boolean isPermute(char[] s1, int at) {
        if(at == s1.length) {
            return s2.contains(s1);
        }

        for(int i = at; i< s1.length; i++) {
            swap(s1, at, i);
            if(isPermute(s1, i+1)) return true;
            swap(s1, i, at);
        }

        return false;

    }

    static void swap(char[] arr, int 1, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}