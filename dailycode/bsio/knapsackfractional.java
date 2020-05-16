import java.util.*;

public class knapsackfractional {


    public static void main(String[] args) {
        int[] weights = new int[] { 5, 6, 2 };
        int[] values = new int[] {100, 100, 1};
        int capacity = 8;

        int res = solve(weights, values, capacity);

        System.out.println("Max value is " + res);
    }

    static int solve(int[] weights, int[] values, int capacity) {
        // Write your code here
        
        Ratio[] ratio = new Ratio[weights.length];
        for(int i =0; i< weights.length; i++) {
            ratio[i] = new Ratio((float)values[i]/weights[i], i);
        }
        
        Arrays.sort(ratio, new Comparator<Ratio>() {
            @Override
            public int compare(Ratio r1, Ratio r2) {
                return (r1.fraction <= r2.fraction) ? 1 : -1;




                
            }
        });
        
        float value=0, currCap =0;
        for(int i = 0; i< ratio.length; i++) {
            if(currCap>=capacity) break;
            
            Ratio currRatio = ratio[i];
            //int nextIndex = ratio[i].index;
            
            
            float availableCap = Math.min(weights[currRatio.index], capacity - currCap);
            
            float currVal = availableCap*currRatio.fraction;
            
            currCap = currCap + availableCap;
            
            value += currVal;
        }
        
        return (int)value;
    }



}

class Ratio {
    float fraction;
    int index;
    public Ratio(float frac, int ind) {
        fraction = frac;
        index = ind;
    }
}