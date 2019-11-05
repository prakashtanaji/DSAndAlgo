import java.util.*;

class subarraysequalstok {
    public static void main(String[] args) {
        System.out.println("subarraysequalstok");

        int[] arr = new int[]{3,4,2,5,3,3,1};
        int k =7;

        System.out.println("Finding the count of subarray equals K using method 1:");
        int count = checkAtEachElementMethod1(arr, k);
        System.out.println(" Count of subarrays:" + count);

        System.out.println("Finding the count of subarray equals K using method 2:");
        count = checkAtEachElementMethod1(arr, k);
        System.out.println(" Count of subarrays:" + count);
    }

    static int checkAtEachElementMethod1(int[] arr, int k) {

        int elementAccessCounter = 0;

        int countOfSubArray = 0;
        for(int i=0; i<arr.length; i++) {
            int toK = 0;
            for(int j = i; j<arr.length; j++) {
                elementAccessCounter++;
                toK+= arr[j];
                if(toK == k) {
                    countOfSubArray++;
                    break;
                }
            }
        }

        System.out.println("    Accessed element times:"+ elementAccessCounter);

        return countOfSubArray;
    }

    static int curSumApproachMethod2(int[] arr, int k) {

        int elementAccessCounter = 0;

        int countOfSubArray = 0;

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int currSum = 0;

        for(int i=0; i<arr.length; i++) {

            elementAccessCounter++;

            currSum+= arr[i];

            if(currSum == k) {
                countOfSubArray++;
            }

            if(mp.containsKey(currSum - k)) {
                //countOfSubArray++;
                // actually the subarray ending at this number is same as the previous occurance of diff in the map
                countOfSubArray+=mp.get(currSum - k);
            }

            mp.put(currSum, mp.getOrDefault(currSum, 0)+1);
        }

        System.out.println("    Accessed element times:"+ elementAccessCounter);

        return countOfSubArray;
    }
}