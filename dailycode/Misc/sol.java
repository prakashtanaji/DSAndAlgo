import java.util.*;
import java.util.List;
import java.util.ArrayList;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class sol
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNFeatures(int numFeatures, 
	                                         int topFeatures, 
                                             List<String> possibleFeatures, 
											 int numFeatureRequests, 
											 List<String> featureRequests)
    {
        // WRITE YOUR CODE HERE
        
        HashSet<String> stPossible = new HashSet<String>();
        for(String word: possibleFeatures) {
            stPossible.add(word.toLowerCase());
        }
        
        HashMap<String, Integer> globalCount = new HashMap<>();
        
        for(String featureRequest: featureRequests) {
            HashSet<String> localOccurance = new HashSet<>();
            
            String[] splitOccurances = featureRequest.split(" ");
            for(String occ: splitOccurances) {
                occ = occ.toLowerCase();
                if(stPossible.contains(occ)) {
                    localOccurance.add(occ);
                }
            }
            
            // add to global HashMap
            Iterator it = localOccurance.iterator();
            while(it.hasNext()) {
                String occ = (String)it.next();
                globalCount.put(occ, globalCount.getOrDefault(occ));
            }
        }
        
        // sort by reverse map use LinkedHashMap
        Map<String, Integer> revSortedmap = new LinkedHashMap<String, Integer>();
        
        
        // globalCount.entrySet().stream()
        //     .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //     .forEachOrdered(en->revSortedmap.put(en.getKey(), en.getValue()));
        
        
        List<String> res = ArrayList<String>();
        
        Iterator itMap = globalCount.entrySet().iterator();
        while(itMap.hasNext()) {
            res.add(itMap.next());
        }
        
        return res;
        
    }
    // METHOD SIGNATURE ENDS
}