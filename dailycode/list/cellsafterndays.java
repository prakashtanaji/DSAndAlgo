// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.*;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
class CellsAfternDays
{    
    public static void main(String[] args) {

        int[] input = new int[] {1,1,1,0,1,1,1,1};

        List<Integer> res = cellCompete(input, 2);

        System.out.println("done:" + res.size());

    }    
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
        
        // WRITE YOUR CODE HERE
        
        HashSet<String> st = new HashSet<>();
        HashMap<Integer, int[]> mp = new HashMap<>();
        
        String hash = getHash(states);
        st.add(hash);
        mp.put(0, states);
        //boolean done = false;
        
        while(true) {
            int[] next = getNewState(states);
            hash = getHash(next);
            if(st.contains(hash)) {
               //done = true;
               break;
            }
            
            st.add(hash);
            mp.put(mp.size(), next);
            states = next;
        }
        
        int mpSize = (int)mp.size();
        
        int index = (Integer) (days%mpSize);
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int val: mp.get(index)) {
            res.add(val);
        }
        
        res.add(mpSize);
        res.add(index);
        return res;
        
        
    }
  // METHOD SIGNATURE ENDS
  
  public static int[] getNewState(int[] state) {
      int[] next = new int[state.length];
      
      // can safely assume that there are 8 homes as given in the problem statement
    //   for(int i=0; i< state.length; i++) {
    //       next[i] = state[i];
    //   }
    Arrays.fill(next, 0);
      
      if(state[1] == 0) {
          next[0] = 0;
      }
      else 
        next[0] = 1;
        
      if(state[state.length-2] == 0) {
          next[state.length-1] = 0;
      }
      else 
        next[state.length-1] = 1;
      
    //   if(state.length <3) {
    //       return next;
    //   }
      for(int i=1; i< state.length-1; i++) {
          if((state[i-1] == 1 && state[i+1]==1) || (state[i-1] == 0 && state[i+1]==0))
            next[i] = 0;
          else 
            next[i] = 1;
      }
      
      return next;
      
  }
  
    public static String getHash(int[] curr) {
        StringBuilder sb = new StringBuilder();
        
        for(int currVal: curr) {
            sb.append(currVal);
        }
        
        return sb.toString();
    }
}