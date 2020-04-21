//import static System.out;
import java.util.*;

class lis {

    static int iExeCount = 0;
    static int[] arrRes;
    static List<Integer>[] arrResLst;
    public static void main(String[] args) {
        int[] arr = { 10, 11, 12, 2, 18, 19, 4, 5,15};

        arrRes = new int[arr.length];

        arrResLst = new ArrayList[arr.length];
        // for(ArrayList<Integer> a: arrResLst) {
        //     a = new ArrayList<>();
        // }
        Arrays.fill(arrResLst, new ArrayList<Integer>());

        // for(int i =0; i< arr.length; i++) {
        //     arrResLst[i].add(arr[i]);
        // }

        System.out.println("Max increasing subsequence size is "+ lis3(arr, arr.length-1, Integer.MAX_VALUE));

        Arrays.fill(arrRes, 0);

        System.out.println("Max LIS is "+ lisutil(arr, arr.length-1, 0, Integer.MAX_VALUE)+ " :"+iExeCount);
        for(int i: arrRes) {
            System.out.print(":"+ i);
        }

        System.out.println();

        iExeCount = 0;

        int maxAt = lisutil2(arr);
        System.out.println("Max LIS2 is "+ maxAt + " :"+iExeCount);
        for(int i: arrRes) {
            System.out.print(":"+ i);
        }

        System.out.println();

        for(int i: arrResLst[maxAt]) {
            System.out.print(":"+ i);
        }


    }

    static int lisutil2(int[] arr) {
        Arrays.fill(arrRes, 1);

        int maxId = 0;

        for(int i = 1; i< arrRes.length; i++) {

            int iMaxId = i;
            for(int j = i-1; j>=0; j--) {
                iExeCount++;
                if(arr[i]>= arr[j] && arrRes[i]< arrRes[j]+1) {
                    arrRes[i] = 1+ arrRes[j];

                    iMaxId = j;
                    // arrResLst[i] = arrResLst[j];
                    // arrResLst[i].add(arr[i]);

                    //max = Math.max(maxId, arrRes[i]);
                }
            }

            if(iMaxId != i) {
                arrResLst[i] = arrResLst[iMaxId];
                arrResLst[i].add(arr[i]);
            }
        }

        for(int i =0; i<arrResLst.length; i++) {
            if(arrResLst[i].size() > arrResLst[maxId].size()) {
                maxId = i;
            }
        }

        return maxId;
    }

    static int lisutil(int[] arr, int curr, int maxCount, int lastMaxVal) {
        if(curr< 0) return 1;

        if(arrRes[curr] !=0) return arrRes[curr];

        iExeCount++;

        int iVal1 = Integer.MIN_VALUE;
        if(lastMaxVal >= arr[curr]) {
            iVal1 = 1 + lisutil(arr, curr-1, 0, arr[curr]);
        }
        int iVal2 = lisutil(arr, curr-1, 0, lastMaxVal);

        arrRes[curr] = Math.max(iVal1, iVal2);
        //arrRes[curr] = Math.max(1,Math.max(iVal1, iVal2));

        return Math.max(iVal1, iVal2);
    }

    static int lis3(int[] arr, int curr, int lastMax) {
        
        if(curr<0) return 0;

        int a = Integer.MIN_VALUE;
        if(arr[curr]<lastMax) {
            a = 1+ lis3(arr, curr-1, arr[curr]);
        }

        int b = lis3(arr, curr-1, lastMax);

        return Math.max(a, b);
    }
}