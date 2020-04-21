import java.util.*;

class Solution {

    static char[] tempBuf;

    public static void main(String[] args) {

        char[] buffer = new char[1000];
        read(buffer, 1);
    }

    static int read4(char[] buf) {
        buf = new char[] {'a', 'b', 'c'};

        return 3;
    }
    
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public static int read(char[] buf, int n) {
        if(n<1) return 0;
        
        StringBuilder sb = new StringBuilder();
        int charsRead = 0;
        
        if(tempBuf != null && tempBuf.length>0) {
            sb.append(tempBuf, 0, Math.min(tempBuf.length, n));
            // reduce tempBuf by that much
            
            if(tempBuf.length> n) {
                tempBuf = Arrays.copyOfRange(tempBuf, n, tempBuf.length);
            }
            else {
                tempBuf = null;
            }
        }
        
        int nTemp = n;
        nTemp -= sb.length();
        charsRead = sb.length();
        int returned = 0;
        while(nTemp>0) {
            
            returned = read4(buf);
            
            if(returned  == 0) break;
            // copy either 4 or nTemp, which ever is min.
            int toCopy = Math.min(nTemp, returned);
            sb.append(buf, 0, toCopy);
            
            charsRead += returned;
            
            nTemp = nTemp-returned;
        }
        
        // store the additional read chars for next call use

        int sbLength = sb.length();
        sbLength = buf.length;

        if(sb.length()<charsRead) {
            tempBuf = Arrays.copyOfRange(buf, returned-(charsRead-sb.length()), returned-1);
        }

        String str1 = String.valueOf(tempBuf);
        String str2 = String.valueOf(buf);
        
        buf = sb.toString().toCharArray();
        return buf.length;
        
    }
}