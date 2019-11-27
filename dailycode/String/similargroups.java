import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

class similargroups {
    public static void main(String[] args) {

        // size of strings => 'n'
        String[] input = new String[] {"abc", "acb", "abcd" , "cbad", "dcba", "xyz", "bac"};

        // Approach 1: create a map of String(original strings in arrays) and Set<String>(similar strings)
        // Map<String, Set<String>> mp = new HashMap<>();
        // For each string try to match for other strings, after which point we have built a chain of words
        // create an array of type boolean to keep track of visited strings
        // Iterate through the mp and for each pair, also ierate through the values and mark as visited until there 
        // are no item chained.
        // Then try to find other pair in mp which is not yet visited, incrementing the group count each item as you iterate


        // Approach 2: use the union find algorithm, one node for each string.
        // if the two strings are same, perform union
        unionfind ufDS = new unionfind(input.length);

        // O(n^2)
        for(int i =0; i<input.length-1; i++) {
            for(int j = i+1; j< input.length; j++) {
                if(isSimilar(input[i], input[j])) {
                    ufDS.union(i, j);
                }
            }
        }

        // at this point, in the union find the unique parents indicate the distinct groups.
        Map<Integer, Set<String>> mp = new HashMap<>();
        // O(n)
        for(unionds dfNode: ufDS.uf) {
            Set<String> st;
            if(mp.containsKey(dfNode.parent)) {
                st = mp.get(dfNode.parent);
                st.add(input[dfNode.value]);
            }
            else {
                st = new HashSet<>();
                st.add(input[dfNode.value]);
                mp.put(dfNode.parent, st);
            }
        }

        // O(n)
        for(Set<String> group: mp.values()) {
            Iterator<String> it = group.iterator();
            while(it.hasNext()) {
                System.out.print(" "+ it.next());
            }
            System.out.println("\n");
        }
    }

    // O(k)
    public static boolean isSimilar(String i, String j) {
        if(i.equalsIgnoreCase(j)) return true;

        if(i.length() != j.length()) return false;
        int diff = 0;

        for(int curr =0; curr< i.length(); curr++) {
            if(i.charAt(curr) != j.charAt(curr)) {
                diff++;
            }
            if(diff > 2) return false;
        }

        return true;
    }
}

class unionds {
    int value;
    int rank;
    int parent;
}

class unionfind {

    unionds[] uf;
    public unionfind(int n) {

        uf = new unionds[n];

        for(int i=0; i< uf.length; i++) {
            unionds node = new unionds();
            node.parent = i;
            node.rank = 1;
            node.value = i;

            uf[i] = node;
        }
    }

    public void union(int i, int j) {
        int iParent = find(i);
        int jParent = find(j);

        if(iParent != jParent) {
            if(uf[iParent].rank > uf[jParent].rank) {
                uf[jParent].parent = iParent;
            }
            else {
                if(uf[iParent].rank == uf[jParent].rank) {
                    uf[jParent].rank = uf[jParent].rank +1;
                }
                uf[iParent].parent = jParent;
            }
        }
    }

    public int find(int i) {

        int orig = i;
        int currParent = uf[i].parent;

        if(i != currParent) {
            i = uf[i].parent;
        }

        uf[orig].parent = currParent;

        return currParent;
    }
}