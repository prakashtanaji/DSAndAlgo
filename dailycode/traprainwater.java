class traprainwater {
    public static void main(String[] args) {
        System.out.println("test");

        int[] surface = new int[]{ 0,1,0,3,2,0,4,0,3};
        if(surface == null || surface.length<=2) return;

        System.out.println("Water trapped Brute Force method(n^2): ");
        int result = maxWaterTrappedMethod1(surface);
        System.out.println("    Water trapped  : " + result);

        System.out.println("Water trapped with improvement in time complexity(n) method: ");
        result = maxWaterTrappedMethod2(surface);
        System.out.println("    Water trapped  : " + result);

        System.out.println("Water trapped with improvement in space complexity(1) with time complexity - O(n) method: ");
        result = maxWaterTrappedMethod3(surface);
        System.out.println("    Water trapped  : " + result);
    }

    // for each array element find the max on its left and find teh max on its right and then take the least of both and find the difference
    static int maxWaterTrappedMethod1(int[] surface) {

        int elementAccessCounter = 0;

        int maxWater = 0;

        for(int i=1;i<surface.length-1; i++) {

            elementAccessCounter++;

            int iMaxLeft = 0;
            for(int j=0; j<i; j++) {
                iMaxLeft= Math.max(iMaxLeft, surface[j]);
                elementAccessCounter++;
            }
            int iMaxRight = 0;
            for(int j=surface.length-1; j>i; j--) {
                iMaxRight= Math.max(iMaxRight, surface[j]);
                elementAccessCounter++;
            }

            int minHt = Math.min(iMaxLeft, iMaxRight);

            if(minHt>surface[i]) {
                maxWater+= minHt-surface[i];
            }
        }

        System.out.println("    Accessed element times:"+ elementAccessCounter);
        return maxWater;
    }

    // Create two temp arrays with the prepopulated values of max on left and max on right at each item.
    // then use these temp arrays to find the max onn left and max on right, instead of parsing all teh items each time
    static int maxWaterTrappedMethod2(int[] surface) {

        int elementAccessCounter = 0;

        // Find the max on left at each item starting from the Left
        int[] maxOnleft = new int[surface.length];
        
        maxOnleft[0] = surface[0];
        for(int j=1; j<maxOnleft.length; j++) {
            maxOnleft[j]= Math.max(maxOnleft[j-1], surface[j]);
            elementAccessCounter++;
        }

        // Find the max on right at each item starting from the Right
        int[] maxOnRight = new int[surface.length];

        maxOnRight[maxOnRight.length-1] = surface[maxOnRight.length-1];
        for(int j=maxOnleft.length-2; j>=0; j--) {
            maxOnRight[j]= Math.max(maxOnRight[j+1], surface[j]);
            elementAccessCounter++;
        }

        int maxWater = 0;

        for(int i=1;i<surface.length-1; i++) {

            elementAccessCounter++;

            int iMaxLeft = maxOnleft[i];
            int iMaxRight = maxOnRight[i];

            int minHt = Math.min(iMaxLeft, iMaxRight);

            if(minHt>surface[i]) {
                maxWater+= minHt-surface[i];
            }
        }

        System.out.println("    Accessed element times:"+ elementAccessCounter);
        return maxWater;
    }

    // Although the above method2 shows improvement in the run time, but it needs O(n) extra space( O(2n) to be precise))
    // The space can be improved by adopting another algorithm which tries to find just the least water level surface possible at each item, 
    // rather then trying to find the max left and max right and then getting the min of both.
    // For this to work there needs to be two pointer each starting from the edges
    // The principle behind why this will work is, if you carefully observe the water level in the middle portain of the surface will be higher than the edges.
    static int maxWaterTrappedMethod3(int[] surface) {

        int maxWater = 0;
        int elementAccessCounter = 0;

        int iLeft = 0;
        int iRight = surface.length-1;

        int iLeftMaxVal=surface[iLeft];
        int iRightMaxVal=surface[iRight];

        // Start from the edges amd work towards tehe middle by increasing the max maxLeftVal and maxRightVal
        while(iLeft<=iRight) {

            elementAccessCounter++;

            if(surface[iLeft]<surface[iRight]) {
                if(surface[iLeft]>iLeftMaxVal) {
                    // there is new leftMaxVal
                    iLeftMaxVal = surface[iLeft];
                }
                else {
                    // Use the higher water level to get the water trapped
                    maxWater+=iLeftMaxVal - surface[iLeft];
                }

                // Move right as this item area is consumed
                iLeft++;
            }
            else {
                if(surface[iRight]>iRightMaxVal) {
                    // there is new leftMaxVal
                    iRightMaxVal = surface[iRight];
                }
                else {
                    // Use the higher water level to get the water trapped
                    maxWater+=iRightMaxVal - surface[iRight];
                }

                // Move left as this item area is consumed
                iRight--;
            }
        }

        System.out.println("    Accessed element times:"+ elementAccessCounter);
        return maxWater;
    }
}