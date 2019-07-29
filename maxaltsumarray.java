import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class maxaltsumarray {

    static int[][] maxSum;
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        maxSum = new int[arr.length][2];
        for(int[] bol: maxSum) {
            Arrays.fill(bol, Integer.MIN_VALUE);
        }
        return maxSum(arr, arr.length-1, 1, 0);
    }

    static int maxSum(int[] arr, int iCurr, int canTake, int sum) {
        if(iCurr < 0) return sum;

        if(maxSum[iCurr][canTake] !=Integer.MIN_VALUE) return maxSum[iCurr][canTake];

        int a = 0;
        if(canTake == 1){
            a = arr[iCurr] + maxSum(arr, iCurr-1, 0, sum);
        }
        int b = maxSum(arr, iCurr-1, 1, sum);

        maxSum[iCurr][canTake] = Math.max(a,b);
        return (Math.max(a, b));
    }

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int n = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // int[] arr = new int[n];

        // String[] arrItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // for (int i = 0; i < n; i++) {
        //     int arrItem = Integer.parseInt(arrItems[i]);
        //     arr[i] = arrItem;
        // }
        int[] arr = new int[] {3, 7, 4, 6, 5};

        int res = maxSubsetSum(arr);

        System.out.println("max sum is:"+ res);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        //scanner.close();
    }
}
