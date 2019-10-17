import com.sun.javafx.iio.ios.IosDescriptor;

class scramblestring {

    static int counter = 0;

    public static void main(String[] args) {

        String str1 = "abcde";
        String str2 = "caebd";
        if(str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            System.out.println("Invalid input");
        }

        if(str1.length() != str2.length()) {
            System.out.println("Not scramble");
            return;
        }

        if(isScrambledString(str1, str2) == true) {
            System.out.println(" Is scramble");
        }
        else {
            System.out.println(" Is not scramble");
        }

        System.out.println("Total counter:" + counter);
    }

    static boolean isScrambledString(String str1, String str2) {
        counter++;
        if(str1.equals(str2)) return true;

        int len = str1.length();

        for(int i =0; i< str1.length()-1; i++) {
            if(
                (isScrambledString(str1.substring(0, i+1),str2.substring(0, i+1)) 
                    && isScrambledString(str1.substring(i+1),str2.substring(i+1)))
             ||  (isScrambledString(str1.substring(0, i+1), str2.substring(len-i-1))
                    && isScrambledString(str1.substring(len-i-1), str2.substring(0,i+1))))
                    {
                        return true;
                    }
        }

        return false;
    }

}