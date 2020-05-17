public class firstAndLastIndex {
    public static void main(String[] args) {
        int[] series = new int[] {1,1,2,2,2,4,4,4};
        //                        0 1 2 3 4 5 6 7

        int sIndex = startIndex(series, 3);
        int eIndex = endIndex(series, 3);

        System.out.println(sIndex + " " + eIndex);
    }

    static int startIndex(int[] series, int target) {
        int left = 0, right = series.length-1;
        int mid =0;
        while(left < right) {
            mid = (left + right)/2;
            if(series[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        if (series[left] == target) return left;
        return -1;
    }

    static int endIndex(int[] series, int target) {
        int left = 0, right = series.length-1;
        int mid =0;
        while(left < right) {
            mid = (left + right + 1)/2;
            if(series[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        if (series[left] == target) return left;
        return -1;
    }
    
}