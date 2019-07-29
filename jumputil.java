import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h){

        Stack<Integer> st = new Stack<Integer>();

        long largeArea = 0L;
        int iTrack =0;
        for(iTrack=0; iTrack<h.length; iTrack++) {
            if(iTrack ==0 || h[st.peek()]<=h[iTrack]) {
                st.push(iTrack);
            }
            else {
                while(!st.isEmpty() && h[st.peek()]>h[iTrack]) {
                    int popped = st.pop();
                    long area = (long)((iTrack-popped) * h[popped]);
                    largeArea = Math.max(area, largeArea);
                    
                }
                st.push(iTrack);
            }   
        }

        while(!st.isEmpty()) {
            int top = st.pop();
            long area2 = 0L;
            if(st.isEmpty()) {
                area2 = (long)(iTrack* h[top]);
            }
            else {
                area2 = (long)((iTrack-top)*h[top]);
            }
            largeArea = Math.max(area2, largeArea);
        }

        return largeArea;
    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("abc.txt"));

        // int n = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // int[] h = new int[n];

        // String[] hItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // for (int i = 0; i < n; i++) {
        //     int hItem = Integer.parseInt(hItems[i]);
        //     h[i] = hItem;
        // }

        int[] h = {11, 11, 10, 10, 10};
        long result = largestRectangle(h);

        System.out.println("result: "+ result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        // scanner.close();
    }
}
