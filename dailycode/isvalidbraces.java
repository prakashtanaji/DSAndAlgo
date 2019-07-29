import java.util.*;

class isvalidbraces {
    public static void main(String[] args) {
        char[] braces = (new String("(()()(")).toCharArray();

        for(char c : braces) {
            System.out.print(":"+ c);
        }

        int[] arr = new int[braces.length];

        Arrays.fill(arr, 0);

        for(int i = 1; i< braces.length; i++) {


            if(braces[i] == '(') continue;

            if(braces[i] == ')' && braces[i-1] == '(') {
                if(i-2>=0) {
                    arr[i] = arr[i-2] +2;
                }
                else {
                    arr[i] = 2;
                }
            }
            else if(braces[i] == ')' && braces[i-1] == ')') {
                if(i-2>=0) {
                    if(braces[i-arr[i-2]-1] == '(') {
                        arr[i] = arr[i-1] + 2;
                    }
                }
            }
        }

        System.out.println();
        for(int i : arr) {
            System.out.print(":"+ i);
        }
    }
}