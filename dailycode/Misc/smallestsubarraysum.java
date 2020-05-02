
public class smallestsubarraysum {
    public static void main(String[] args) {
        // : [2, 1, 5, 2, 3, 2], S=4. 
        // Given array and the sum(S) find the size of smallest subarray whose sum is greater then or equal to S
        int[] arr = new int[] {2, 1, 5, 2, 3, 2};
        int S = 7;
        int left = 0, right =0;
        int sum = 0;
        // sum+=arr[right];
        // while(sum>=S) {
        //     right++;
        //     sum+=arr[right];

        // }

        // left right sum
        // 0     0   0
        // 0     1   2
        // 0     2   3
        // 0     3   8  3
        // 1     3   6
        // 1     4   8  4
        // 2     4   7  2
        // 3     4   2
        // 3     5   5
        // 3     6   7  3

        int minLen = Integer.MAX_VALUE;
        // sum=arr[right];
        while(right<arr.length) {   
            if(sum >= S) {
                
                sum-=arr[left++];
            }
            else {
                sum+=arr[right];
                right++;
            }

            if(sum>=S) {
                minLen = Math.min(minLen, right-left);
            }
        }

        System.out.println("min length with max Sum is " + minLen);
    } 

}