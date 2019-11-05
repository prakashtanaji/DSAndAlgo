import java.util.HashSet;
import java.util.*;

class anagramslexiorder {
    
    public static void main(String[] args) {

        char[] str = {'b','c','a','c'};

        Map<Character, Integer> mp = new TreeMap<>();
        for(char c: str) {
            mp.put(c, mp.getOrDefault(c, 0) +1);
        }

        char[] chars = new char[mp.size()];
        int[] sizes = new int[mp.size()];

        int i = 0;

        for(Map.Entry<Character, Integer> entry: mp.entrySet()) {
            chars[i] = entry.getKey();
            sizes[i] = entry.getValue();

            i++;
        }

        char tempRes[] = new char[str.length];
        anagram(chars, sizes, tempRes, 0);
    }

    static void anagram(char[] letters, int[] size, char[] tempRes, int currPos) {

        if(currPos == tempRes.length) {
            System.out.println(String.valueOf(tempRes));
            return;
        }

        for(int i = 0; i< size.length; i++) {
            if(size[i]>0) {
                int times = size[i];
                for(int j=0; j<times; j++) {
                    tempRes[currPos] = letters[i];
                    size[i]--;
                    anagram(letters, size, tempRes, currPos+1);
                }

                size[i] = times;
            }
        }
    }
}