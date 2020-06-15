package arrays;

import java.util.*;

public class subrangehask {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 6, -2, 1, 5};

        System.out.println("the array has sum of k? "+ hasSumK(arr, 7));

        System.out.println("the array has sum of k(handle for negative items)? "+ hasSumK2(arr, 7));
    }

    // Will not work for negative number
    //  for array -> 3, 6, -2, 1, 5 and k = 7 => It will return  false, which is not correct
    static boolean hasSumK(int[] arr, int k) {
        int l = 0, r = 0;
        int sum = 0;

        while (r < arr.length) {
            sum+= arr[r];

            if(sum == k) return true;

            if(sum>k) {
                while(sum > k && l<=r) {
                    sum-=arr[l++];
                    if(sum == k) return true;
                }
            }
            r++;        
        }

        return false;
    }

    static boolean hasSumK2(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i< arr.length; i++) {
            sum+=arr[i];
            arr[i] = sum;
        }

        Set<Integer> st = new HashSet<>();
        st.add(0);
        for(int sumSoFar: arr ) {
            if(st.contains(sumSoFar-k)) return true;
            st.add(sumSoFar);
        }

        return false;
    }
}