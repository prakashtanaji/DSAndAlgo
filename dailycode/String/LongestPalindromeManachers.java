import java.util.Arrays;

class LongestPalindromeManachers {
        static int timeCounter = 0;
        public static void main(String[] args) {

        //String str = "ba1aba1cbqbc1ab";
        //String str = "ba1abcggggh";
        String str = "kkkkjhgjhgjgjhghghghghghgkkhhjjjjjjk";



        char[] chars = str.toCharArray();

        System.out.println("Max Palin length in " + str.length()+" string is ");

        ManacherSol(chars);

        System.out.println("Times:" + timeCounter);
    }


    static void ManacherSol(char[] chars) { 
        // create an array to store the min palin length of 1 at ecah item.
        int size[] = new int[chars.length];
        Arrays.fill(size, 1);

        int curr = 0, left=0, right=0;

        while(curr<chars.length) {
            int currSize = getMaxPalinSizeBeyond(chars, curr, left, right);

            size[curr] = currSize;

            if(currSize==1) {
                curr = curr +1;
                left = curr; right = curr;
                continue;
            }

            int nextMaxSize=1;
            int nextMaxId=curr+1;

            for(int i =1; i<= (currSize/2); i++) {
                timeCounter++;
                int sizeOtherSide = size[curr-i];
                int maxLimit = ((currSize/2)-i)*2+1;

                int sizeThisSide = Math.min(sizeOtherSide, maxLimit);
                if(sizeThisSide >= nextMaxSize) {
                    nextMaxId = curr+i;
                    nextMaxSize =  sizeThisSide;
                }

            }

            curr = nextMaxId;
            left = nextMaxId-nextMaxSize/2;
            right = nextMaxId+nextMaxSize/2;
        }

        for(int i: size) {
            System.out.print(" "+ i);
        }
    }

    static int getMaxPalinSizeBeyond(char[] chars, int curr, int left, int right) {
        int currSize = right-left +1;
        right++;
        left--;
        while(left>=0 && right <chars.length) {
            timeCounter++;
            if(chars[left] == chars[right]) {
                currSize+=2;
            }
            else break;

            left--; right++;
        }

        return currSize;
    }
}