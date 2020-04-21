import java.util.*;

class operationMapSet {
    public static void main(String[] args) {

        Map<Integer, Character> mp = new HashMap<>();
        // Use TreeMap for sorted insertion
        // Use LinkedHashMap to maintain insertion order

        mp.put(6, 'c');
        mp.put(2, 'd');
        mp.put(5, 'd');

        //iterate map in in for loop
        for(Map.Entry<Integer,Character> entry : mp.entrySet()) {
            System.out.print(" " + entry.getKey());
            System.out.println(" " + entry.getValue());
        }

        // Iterate map keys
        for(int key : mp.keySet()) {
            System.out.print(" " + key);
        }

        System.out.println();

        // Iterate map value
        for(int val : mp.values()) {
            System.out.print(" " + (char)val);
        }

        System.out.println();

        // Map contains Key
        if(mp.containsKey(2)) {
            System.out.print("Contains value 2 ");
        }
        else {
            System.out.print("Doesn't contain value 2 ");
        }
        System.out.println();

        // Map contains Value
        if(mp.containsValue('t')) {
            System.out.print("Contains value c ");
        }
        else {
            System.out.print("Doesn't contain value c ");
        }
        System.out.println();

        // Other map operations
        //mp.replace(key, value) // .put will create duplicate
        System.out.println("Map forEach demo");
        // mp.forEach((Map.Entry<Integer,Character>)entry -> {
        //     Map.Entry<Integer, Character> en = (Map.Entry)entry;
        //     System.out.println("  :"+en.getKey());
        // });

        //iterate Set
        // Set<Map.Entry<Integer, Character>> st = mp.entrySet();
        // Iterator it = st.iterator();
        // while(it.hasNext()) {
        //     Map.Entry<Integer, Character> entry = (Map.Entry)it.next();
        //     System.out.print(" " + entry.getKey());
        //     System.out.println(" " + entry.getValue());
        // }

        mapWithArrayVal();
        setOperations();
    }

    public static void setOperations() {
        Set<Integer> st = new HashSet<>();
        st.add(25);
        st.add(26);

        if(st.contains(25)) {
            System.out.print(" Set contains 25 ");
        }
        if(!st.contains(33)) {
            System.out.print(" Set doesn't contains 33 ");
        }
        //st.remove(25);
        //st.addAll(new ArrayList());
        //st.toArray();
        //st.clear();
        //st.size();
        //st.iterator()
        System.out.println("Set forEachDemo");
        st.forEach(
            val -> {System.out.println(val);}
        );

        System.out.println();

    }


    public static void mapWithArrayVal() {
        Map<Integer, char[]> mpArr = new HashMap<>();

        mpArr.put(1, new char[] {'1','2','8'});
        mpArr.put(2, new char[] {'1','2','8','6'});

        // iterate map in in for loop
        for(Map.Entry<Integer,char[]> entry : mpArr.entrySet()) {
            System.out.print(" " + entry.getKey() + "    : ");
            for(char c : entry.getValue()) {
            System.out.print(" " + c);
            }
            System.out.println();
        }

        System.out.println();

    }
}