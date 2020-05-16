import java.util.*;



// given the string with value r b and ., curr position, block, and empty space respectively.
// find if r can reach any of the edge, left or right.
class rbdot {

    public static void main(String[] args) {
        String s = "..B..R....";
        System.out.println("can rookie reach edge  " + ispossible(s));
    }
    static boolean ispossible(String s) {
        // . . . B R . . . .
        // 0 1 2 3 4 5 6 7 8

        int i = -1;
        while(i < s.length()-1) {
            i++;
            char c = s.charAt(i);
            if (c == '.') continue;
            if (c == 'B') break;
            if (c == 'R') return true;


        }
        i++;

        int j = s.length();

        while(j>i) {
            j--;
            char c = s.charAt(j);
            if (c == '.') continue;
            if (c == 'B') break;
            if (c == 'R') return true;

        }

        return false;
    }
}
