class subarraysequalstok {
    public static void main(String[] args) {
        System.out.prinln("subarraysequalstok");

        int[] arr = new int[]{3,4,2,5,3,3,1};
        int k =7;

        System.out.println("Finding the count of subarray equals K using method 1:");
        int count = checkAtEachElementMethod1(int[] arr, int k);
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
}