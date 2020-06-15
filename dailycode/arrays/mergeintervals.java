package arrays;

import java.util.*;

public class mergeintervals {
    public static void main(String[] args)
    {
        int[][] ranges = new int[][] {{0,3},{1,4},{5,6},{-2,-1}};

        printArray(ranges);

        sort(ranges);

        printArray(ranges);

        List<int[]> res = new ArrayList<>();
        int[] curr = ranges[0];

        for(int i = 1; i<ranges.length; i++){
            int[] next = ranges[i];
            if(curr[1]<next[0]) {
                res.add(new int[] {curr[0], curr[1]});
                curr = next;
            }
            else {
                curr[1] = Math.max(curr[1], next[1]);
            }
        }

        res.add(curr);

        int[][] result = new int[res.size()][2];
        int i = 0;
        for(int[] range: res) {
            result[i][0] = range[0];
            result[i][1] = range[1];
            i++;
        }

        printArray(result);
    }

    static void printArray(int[][] ranges) {
        for(int[] range: ranges) {
            System.out.print(" " + range[0] + ","+ range[1]+ "; ");
        }
        System.out.println();
    }

    static void sort(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            public int compare(int[] r1, int[] r2) {
                return r1[0]-r2[0];
            }
        });
    }
}