import java.util.*;
import java.lang.*;

public class socialdist {
    public static void main(String[] args) {
        //System.out.println("result is "+ solve("x...x", 2));

        // System.out.println("result is "+ solveOptimalDecrease(new int[] {74, 80, 46, 74, 74, 29, 62, 68, 22, 82}, 10)); // 76
        //System.out.println("result is "+ solveOptimalDecrease(new int[] {84, 83, 87, 46, 90, 0, 38, 22, 12, 73}, 48)); // 74

        System.out.println("result is "+ invertedInv(new int[] {1, 2, 5, 4, 3}));
    }
    static boolean solve(String s, int k) {
        int left= -1 * k, right = 0;
        while(right < s.length()) {
            if(right - left == k*2) return true;
            
            if(s.charAt(right) == 'x') {
                left = right;
            }
            right++;
        }
        
        return right - left > k;
        
    }

    static int solveOptimalDecrease(int[] nums, int k) {
        // Write your code here
        
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        int remain = sum - k;
        int avg = remain / nums.length;
        int toDistCount = nums.length;
        int bottom = 0;
        boolean noOdd = false;
        while(noOdd == false) {
            noOdd = true;

            for(int i = 0; i< nums.length; i++) {
                if (nums[i] <= avg && nums[i] >= bottom) {
                    noOdd = false;
                    remain-= nums[i];

                    toDistCount--;
                }
            }

            bottom = avg;
            avg = remain / toDistCount;

        }
        
        int quo = remain/toDistCount;
        int remainder = remain % toDistCount > 0 ? 1 : 0;
        
        return quo + remainder;
    }

    static int invertedInv(int[] nums) {
        // Write your code here
        int[] top = new int[nums.length];
        int[] bottom = new int[nums.length];
        
        Arrays.fill(top, 0);
        Arrays.fill(bottom, 0);
        
        for(int i =1; i< nums.length-2; i++)
        {
            int countTop = 0;
            int countBottom = 0;
            for(int j = i-1; j>=0; j--) {
                if(nums[i] > nums[j]) countTop++;
            }
            top[i] = countTop;
            
            for(int j = i+2; j<nums.length; j++) {
                if(nums[i+1] > nums[j]) countBottom++;
            }
            bottom[i+1] = countBottom;
        }
        
        int modulo = 0;
        for(int i =1; i< nums.length-2; i++)
        {
            for(int j = i+1; j<nums.length-1; j++)
                modulo+= top[i] * bottom[j];
        }
        
        
        return modulo;
    }
}