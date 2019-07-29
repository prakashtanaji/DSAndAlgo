import static java.lang.System.out;

class mergetwosortedarrays {

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3, 5, 0, 0, 0, 0};
        int[] arr2 = new int[] {1, 4, 7, 9};
        int m = 3;
        int n = 4;

        int iEnd = m+n-1;
        

        m--;
        n--;

        int iMVal;
        int iNVal;
        for(int i: arr1) {
            System.out.print(" " + i);
        }
        System.out.println();


        while(iEnd>=0) {
            if(m<0) {
                iMVal = Integer.MIN_VALUE;
            }
            else {
                iMVal = arr1[m];
            }

            if(n<0) {
                iNVal = Integer.MIN_VALUE;
            }
            else {
                iNVal = arr2[n];
            }

            //
            if(iNVal > iMVal) {
                arr1[iEnd] = iNVal;
                n--;
            }
            else {
                arr1[iEnd] = iMVal;
                m--;
            }

            iEnd--;

            // for(int i: arr1) {
            //     System.out.print(" " + i);
            // }
            // System.out.println();
        }

        for(int i: arr1) {
            System.out.print(" " + i);
        }

    }
}