
import java.util.*;

public class kuniquestrings {

    // Given a string s of lowercase alphabet characters, and an integer k, return the minimum number of changes needed in the string (one change involves changing a single character to any other character) so that the resulting string has at most k distinct characters.
    
    // Count the number of the occurenace of each chars and find the chars with least occurence,
    // leaving out the k chars with highest occurance
    // The count of each char can be counted aginst the 26 length char array.
    // Then finding the least counted chars need to iterate over the array C - k times given C is unique characters
    // (C-k)*26 times, hence Final time complexity is n + (C-k)* 26. Space - 26

    // Current Attempt: We could also use a prority Q. Also use HashMap, but it neead to be sorted later and resort at each char count update which is too much
    // Just add the chars counts after initial parse.

    public static void main(final String[] args) {
        final String s = "ddaaabccc";
        final int k = 2;
        final Map<Character, Integer> mp = new HashMap<>();

        for (final char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        final PriorityQueue<Integer[]> que = new LinkedList<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // TODO Auto-generated method stub
                return 0;
            }
        });

        // C(unique chars) times C*logC
        for (final Map.Entry<Character, Integer> entry : mp) {
            que.add(new int[]{entry.getKey()-65, entry.getValue()});
        }

        int C = que.size();
        int result = 0;
        while(C != k) {
            result += que.remove()[1];
            C--;
        }

        System.out.println("Min number of chars to be removed is " + result);

    }

}