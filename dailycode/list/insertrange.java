import java.util.*;

public class insertrange {
    public static void main(String[] args) {
        int[][] ranges = new int[][] {{1,3},{5,7},{8,9}};
        int[] newRange = new int[] {4,10};

        int[][] result = merge(ranges, newRange);
        for(int[] range: result) {
            System.out.println(range[0] + " " + range[1]);
        }
    }

    static int[][] merge(int[][] ranges, int[] newRange) {
        List<int[]> res = new ArrayList<>();

        int[] curr = new int[2];
        int currIndex = 0;
        boolean found = false;
        while(currIndex < ranges.length && found == false) {
            curr = ranges[currIndex];
            if(curr[1] < newRange[0]) {
                res.add(curr);
            }
            else {
                found = true;
                if (curr[0] > newRange[1]) {
                    res.add(newRange);
                }
                else {
                    curr[0] = Math.min(curr[0], newRange[0]);
                    curr[1] = Math.max(curr[1], newRange[1]);
                }
            }

            currIndex++;
        }
        if (found == false) {
            res.add(newRange);
        }
        else {
            while(currIndex < ranges.length) {
                int[] next = ranges[currIndex];
                if(curr[1] < next[0]) {
                    res.add(curr);
                    curr = next;
                }
                else {
                    curr[0] = Math.min(curr[0], next[0]);
                    curr[1] = Math.max(curr[1], next[1]);
                }

                currIndex++;
            }
            res.add(curr);
        }

        return res.stream().toArray(int[][]::new);
    }
    
}