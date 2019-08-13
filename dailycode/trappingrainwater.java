class trappingrainwater {
    public static void main(String[] args) {

        int[] height = {100, 2,3,4,1,5,3,2,1,3,1, 50};

        if (height.length<3) { 
            System.out.println("Zero"); 
            return; 
        }
        
        int iMax=0;
        // find the max height bar id
        for (int i=1; i<height.length; i++) {
            if(height[iMax] < height[i]) iMax = i;
        }
        
        int right = parseRight(iMax, height);
        int left = parseLeft(iMax, height);
        // given bar recursively find the next higher bar finding the area in between
        System.out.println("The max area traped " + (right+left));
    }

    static int parseRight(int iLeft, int[] height) {
        if (iLeft == height.length-1 || iLeft == height.length-2) return 0;
        
        int iRight = height.length-1;
        
        for (int i = height.length-2; i> iLeft;i--) {
            if(height[iRight] < height[i]) iRight = i;
        }
        
        int iMax = height[iRight];
        int iNewLeft = iRight;
            
        int area = 0;
        
        
        while (iRight - iLeft >1) {
            
            area+= iMax-height[iLeft+1];
            iLeft++; 
        }
        
       return area + parseRight(iNewLeft, height);
    }
    
    static int parseLeft(int iRight, int[] height) {
        if(iRight == 0 || iRight == 1) return 0;
        
        int iLeft = 0;
        
        for (int i = 1; i< iRight;i++) {
            if(height[iLeft] < height[i]) iLeft = i;
        }
        
        int iMax = height[iLeft];
        int iNewRight = iLeft;
            
        int area = 0;
        
        
        while (iRight - iLeft >1) {
            
            area+= iMax-height[iLeft+1];
            iLeft++;
               
        }
        
       return area + parseLeft(iNewRight, height);
    }
}