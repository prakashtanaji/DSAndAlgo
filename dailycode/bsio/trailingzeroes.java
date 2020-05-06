import java.util.*;

public class trailingzeroes {

    public static void main(final String[] args) {
        int n = 95;

        System.out.println("trailing zeros " + solve(n));
    }

    static int solve(int k) {
        // Write your code here
        int[] nums = new int[k];
        
        for(int i=0; i<k; i++) {
            nums[i] = i+1;
        }
        for(int i =1; i<k-1; i++) {
            for(int j = i+1; j<k; j++) {
                if(nums[j]%nums[i] == 0) {
                    nums[j] = nums[j]/nums[i];
                }
            }
        }
        int res = 1;
        for(int i =0; i<k; i++) {
            res*=nums[i];
        }
        //return res;
        
        //1470800. 1
        // 147080. 2
        // 14708
        int count = 0;
        while(res%10==0) {
            count++;
            
            res = res/10;
            
            //return res;
            
        }
        
        return count;
        
    }
}