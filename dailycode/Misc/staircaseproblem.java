import java.util.*;

class staircaseproblem {
    public static void main(String[] args) {

        // given the no. of steps(n) in a stair case find the total number of ways to reach the nth steps given that we can either take 1 or 2 steps at a time
        int n =3;

        // This can be solved in the same we we find fibonacci numbers.
        // The total number of wasy to recah 1st steps is 1( 1 step)
        // The total number of ways to recah steps# 2 is 2 (1-1 steps or 2 step)
        // The total number of ways to reach step#3 is either from step#2 or from step#1, hence the total number of ways to reach step#3 is 1 + 2 = 3

        if(n<1|| n==1||n==2) return;

        int[] arr = new int[n];
        Arrays.fill(arr, 0);

        arr[0] = 1;
        arr[1] = 2;

        
        for(int i=3; i<=n; i++) {
            arr[i-1] = arr[i-1-2] + arr[i-1-1];
        }

        System.out.println(" Total no. of ways to reach nth step:" + arr[n-1]);
    }
}