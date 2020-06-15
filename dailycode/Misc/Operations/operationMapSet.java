package Operations;

import java.util.*;

import javax.swing.RowFilter.Entry;

class operationMapSet {
    public static void main(final String[] args) {

        System.out.println("Hashmap");
        // Default Hashmap stores in order if key, hence the entry SEt returns in the
        // order of keys
        final Map<Integer, Character> mp = new HashMap<>();
        setMapValues(mp);
        printMap(mp);

        System.out.println("LinkedHashMap");
        // Use LinkedHashMap to maintain insertion order
        final 
        
        Map<Integer, Character> mp2 = new LinkedHashMap<>();
        setMapValues(mp2);
        printMap(mp2);

        System.out.println("Treemap");
        // Treemap stores in the order of key by default but order can be changed by
        // providing custom comparator
        final Map<Integer, Character> mp3 = new TreeMap<>(Collections.reverseOrder());
        setMapValues(mp3);
        printMap(mp3);

        System.out.println("Treemap- compare by custom comparator");
        // Treemap stores in the order of key by default but order can be changed by
        // providing custom comparator
        Map<Integer, Character> mp4 = new TreeMap<>(new CustomCompare());
        setMapValues(mp4);
        printMap(mp4);

        // get first entry 
        // mp.firstEntry();
        //get last entry
        // mp.lastEntry();

        /*
        Sort by values
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        */


        // Iterate map keys
        for (final int key : mp.keySet()) {
            System.out.print(" " + key);
        }

        System.out.println();

        // Iterate map value
        for (final int val : mp.values()) {
            System.out.print(" " + (char) val);
        }

        System.out.println();

        // Map contains Key
        if (mp.containsKey(2)) {
            System.out.print("Contains value 2 ");
        } else {
            System.out.print("Doesn't contain value 2 ");
        }
        System.out.println();

        // Map contains Value
        if (mp.containsValue('t')) {
            System.out.print("Contains value c ");
        } else {
            System.out.print("Doesn't contain value c ");
        }
        System.out.println();

        // Other map operations
        // mp.replace(key, value) // .put will create duplicate
        System.out.println("Map forEach demo");
        // mp.forEach((Map.Entry<Integer,Character>)entry -> {
        // Map.Entry<Integer, Character> en = (Map.Entry)entry;
        // System.out.println(" :"+en.getKey());
        // });

        // iterate Set
        // Set<Map.Entry<Integer, Character>> st = mp.entrySet();
        // Iterator it = st.iterator();
        // while(it.hasNext()) {
        // Map.Entry<Integer, Character> entry = (Map.Entry)it.next();
        // System.out.print(" " + entry.getKey());
        // System.out.println(" " + entry.getValue());
        // }

        mapWithArrayVal();
        setOperations();
    }

    public static void setMapValues(final Map<Integer, Character> mp) {
        mp.put(6, 'c');
        mp.put(2, 'd');
        mp.put(5, 'a');
    }

    static void printMap(final Map<Integer, Character> mp) {
        // iterate map in in for loop
        for (final Map.Entry<Integer, Character> entry : mp.entrySet()) {
            System.out.print(" " + entry.getKey());
            System.out.println(" " + entry.getValue());
        }

        System.out.println("::::::");
    }

    public static void setOperations() {
        final Set<Integer> st = new HashSet<>();
        st.add(25);
        st.add(26);

        if (st.contains(25)) {
            System.out.print(" Set contains 25 ");
        }
        if (!st.contains(33)) {
            System.out.print(" Set doesn't contains 33 ");
        }
        // st.remove(25);
        // st.addAll(new ArrayList());
        // st.toArray();
        // st.clear();
        // st.size();
        // st.iterator()
        System.out.println("Set forEachDemo");
        st.forEach(val -> {
            System.out.println(val);
        });

        System.out.println();

    }

    public static void mapWithArrayVal() {
        final Map<Integer, char[]> mpArr = new HashMap<>();

        mpArr.put(1, new char[] { '1', '2', '8' });
        mpArr.put(2, new char[] { '1', '2', '8', '6' });

        // iterate map in in for loop
        for (final Map.Entry<Integer, char[]> entry : mpArr.entrySet()) {
            System.out.print(" " + entry.getKey() + "    : ");
            for (final char c : entry.getValue()) {
            System.out.print(" " + c);
            }
            System.out.println();
        }

        System.out.println();

    }
}

class CustomCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer en1, Integer en2) {
        //return en1-en2; // print in ascending
        //return en1.compareTo(en2); // print in ascending

        //return en2-en1; // print in descending
        return en2.compareTo(en1); // print in descending
        /*
            * @return  the value {@code 0} if the argument {@code Character}
            *          is equal to this {@code Character}; a value less than
            *          {@code 0} if this {@code Character} is numerically less
            *          than the {@code Character} argument; and a value greater than
            *          {@code 0} if this {@code Character} is numerically greater
            *          than the {@code Character} argument (unsigned comparison).
            *          Note that this is strictly a numerical comparison; it is not
            *          locale-dependent.
        */
        //return ((int)en2.getValue())-((int)en2.getValue()); // for ascending its en2-en1 returning positive value
    }
}