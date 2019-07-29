import java.util.*;
import static System.out;

class greycode {
    public static void main(String[] args) {
        int size = 8;

        //if(size == 1) out.println("1");

        int iRunner =1;
        int bitPos = 0;

        //println("starting gerycode");

        List<Integer> lst = new ArrayList<>();
        List<String> lstBits = new ArrayList<>();

        int moveDir = 1;

        while(iRunner != 0) {
            lst.add(iRunner);
            lstBits.add(Integer.toBinaryString(iRunner));
            
            if(bitPos >=size-1) moveDir = -1;
            else if(bitPos<=0) moveDir = +1;
            bitPos = bitPos + moveDir;
            iRunner = iRunner ^ (1<<bitPos);
        }

        for(int i = 0; i<lst.size(); i++) {
            System.out.println(lstBits.get(i)+ ": "+lst.get(i));
        }
    }
}