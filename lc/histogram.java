class jumputil {
    public static void main(String[] args) {


        

    }

    static int jump(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        return jumpUtil(0, nums, 0, nums.length-1);
    }
    
    public int jumpUtil(int curr, int[] nums, int jumps, int lastPos) {
        if(curr == lastPos) return jumps;
        
        int jumpsLocal = Integer.MAX_VALUE;
        for(int i = 1; i< Math.min(lastPos-curr+1, nums[curr]); i++) {
            jumpsLocal = Math.min(jumpUtil(curr+i, nums, jumps+1, lastPos), jumpsLocal);
        }
        
        return jumpsLocal;
    }
}