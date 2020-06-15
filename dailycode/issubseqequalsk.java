public class issubseqequalsk {

    public static void main(String[] args) {

        System.out.println("Result is " + isKSum(new int[] {5,2,8,3,6}, 0,13));
    }

    static boolean isKSum(int[]a, int st, int k) {
        if(k==0) return true;

        if(st == a.length) return false;

        for(int i = st; i<a.length; i++) {
            if(isKSum(a,i+1, k-a[i])) {
                return true;
            }
        }

        return false;
    }
    
}