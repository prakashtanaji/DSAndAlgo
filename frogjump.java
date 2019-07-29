import java.util.*;
import java.math.*;

public class frogjump {

    static int counts = 0;
    static int[][] arr;;

    public static void main(String[] args) {

        System.out.println("No. of short steps for frog to jump.");
        int[] steps = new int[100];

        arr = new int[100][12];

        Arrays.fill(steps, 0);
        for(int[] a: arr) {
            Arrays.fill(a, -1);
        }

        int minSteps = jump(steps, 0, 0);

        

        System.out.println("the min. no of jumps frog could take is" + --minSteps + ", ran time-"+ counts);

        counts = 0;

        for(int[] a: arr) {
            Arrays.fill(a, -1);
        }

        int ways = jumpways(steps, steps.length-1);
        System.out.println("num of ways" + ways + ", ran time-"+ counts);
    }

    // 0 1 2 3
    // 0  0 1 2 3
    // 1  1 2 3 4
    // 2  2 

    // 0 2 3
    // 0 1 2 3
    // 0 1 3

    static int jump(int[] steps, int curr, int totalSteps) {
        if(curr >= steps.length) return  Integer.MAX_VALUE;

        if(arr[curr][totalSteps] != -1) return arr[curr][totalSteps];
        if(curr == steps.length-1) return 1;
        
        counts++;

        int step1 = jump(steps, curr+1, 0);
        int step2 = jump(steps, curr+2, 0);

        arr[curr][totalSteps] = Math.min(step1, step2) + 1;
        return arr[curr][totalSteps];
    }
    
    static int jumpways(int[] steps, int left){
        if(left<0) return 0;
        if(arr[left][0] != -1) return arr[left][0];
        if(left == 0) return 1;

        

        counts++;

        int step1 = jumpways(steps, left-1);
        int step2 = jumpways(steps, left-2);

        arr[left][0] = step1 + step2;
        return step1 + step2;
    }

    // static int jumpIt(int[] steps) {
    //     if(curr >= steps.length) return  Integer.MAX_VALUE;

    //     if(arr[curr][totalSteps] != -1) return arr[curr][totalSteps];
    //     if(curr == steps.length-1) return 1;
        
    //     counts++;

    //     int step1 = jump(steps, curr+1, 0);
    //     int step2 = jump(steps, curr+2, 0);

    //     arr[curr][totalSteps] = Math.min(step1, step2) + 1;
    //     return arr[curr][totalSteps];
    // }


}