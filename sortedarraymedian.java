class sortedarraymedian {
    public static void main(String[] args) {
        int[] a1 = new int[] {6,7,8,9,11,14,};
        int[] a2 = new int[] {2,3};

        // int totLen = a1.length + a2.length;

        double median = getMedian(a1, a2);

        System.out.println("Median:" + median);
    }

    static double getMedian(int[] input1, int[] input2) {
        if(input1.length>input2.length) {
            return getMedian(input2, input1);
        }

        int x = input1.length;
        int y = input2.length;

        int low =0, high = x;

        int partitionX;
        int partitionY;

        int maxLeftX = 0;
        int minRightX = 0;
        int maxLeftY = 0;
        int minRightY = 0 ;

        while(low < high) {

            partitionX = (high+low)/2; 
            partitionY = ((x+y+1)/2)-partitionX-1-1;

            if(partitionX<0) {
                maxLeftX = Integer.MIN_VALUE;
                minRightX = input1[0];
            }
            else if(partitionX>=x-1) {
                maxLeftX = input1[x-1];
                minRightX = Integer.MAX_VALUE;
            }
            else {
                maxLeftX = input1[partitionX];
                minRightX = input1[partitionX+1];
            }
    
            maxLeftY = input2[partitionY];
            minRightY = input2[partitionY+1];

            if(maxLeftX <=minRightY && maxLeftY <=minRightX) {
                if((x+y)%2 == 1) { // mean odd
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
                else {
                    return (double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2;
                }
            }
            else if(maxLeftX> minRightY) {
                high = partitionX-1;
            }
            else {
                low = partitionX+1;
            }
        }

        return -1;
    }
}