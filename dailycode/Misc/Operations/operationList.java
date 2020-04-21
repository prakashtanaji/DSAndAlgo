import java.util.*;

class operationList {
    public static void main(String[] args) {

        //arrayToList();
        //listToArray();
        //listSortReverse();
        listTypes();

    }

    public static void listToArray()
    {
        List<String> lstStr = Arrays.asList("First", "Second");

        for(String i: lstStr) {
            System.out.print(" "+ i);
        }
        System.out.println();

        List<Integer> lst = new ArrayList<>();
        lst.add(12);
        lst.add(24);
        lst.add(5);
        //lst.remove(24); -- EXCEPTION look for index not object
        lst.remove(lst.indexOf(24)); // indexOf return -1 if not found
        lst.set(lst.indexOf(5), 45);

        for(int i: lst) {
            System.out.print(" "+ i);
        }
        System.out.println();

        lst.add(89);
        lst.add(50);

        List<Integer> subList = lst.subList(1, 2);
        for(int i: subList) {
            System.out.print(" "+ i);
        }
        System.out.println();

        Object[] arr = lst.toArray(); // int[] Doesn't WORK
        for(int i =0; i< arr.length; i++) {
            System.out.print(" "+ arr[i]);
        }
        System.out.println();

    }

    public static void arrayToList()
    {
        int[] arr = new int[] {10, 23, 15};
        //Arrays.fill(a, val);
        List<Object> lstObj = Arrays.asList(arr); // List<Integer> return exception
        // CANT ADD item after the asList So use below
        // Integer[] values = { 1, 3, 7 };
        // List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

        System.out.println(" ArrayToList");
        for(int i =0; i<lstObj.size(); i++) {
            System.out.print(" "+ lstObj.get(i).toString()); // This DOESn't WORK as expected better to user for look and manually copy one by one
        }
        System.out.println(" ArrayToList-END");
    }
    public static void listSortReverse()
    {

        List<String> lstStr = Arrays.asList("First", "Second", "Apple");

        for(String i: lstStr) {
            System.out.print(" "+ i);
        }
        System.out.println();

        Collections.sort(lstStr);


        System.out.println("Sorted");
        for(String i: lstStr) {
            System.out.print(" "+ i);
        }

        Collections.sort(lstStr, Collections.reverseOrder());


        System.out.println("Sorted-reverse");
        for(String i: lstStr) {
            System.out.print(" "+ i);
        }
        System.out.println();

        // ARRAY SORT

        int[] arr = new int[] {5,2,7,1,9};

        System.out.println("Array:");
        for(int i: arr) {
            System.out.print(" "+ i);
        }
        System.out.println();

        System.out.println("Array Sorted:");
        Arrays.sort(arr);
        for(int i: arr) {
            System.out.print(" "+ i);
        }
        System.out.println();

        // Arrays.sort(arr, new Comparator<Integer> () {
        //     public int compare(Integer a, Integer b) {
        //         return b-a;
        //     }
        // });
        //Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Array:");
        for(int i: arr) {
            System.out.print(" "+ i);
        }
        System.out.println();


    }

    public static void listTypes()
    {

        // Linked List is faster as it doesnt need to reallocate memory
        List<Integer> lst = new LinkedList<>();
        List<Object> vect = new Vector<>();
        vect.add(24);
        vect.add("45");
        vect.add("24");
        vect.add(24);

        for(int i =0; i< vect.size(); i++) {
            System.out.print(" "+vect.get(i));

        }
        System.out.println();

        vect.remove((Integer)24); // casting is neccessary to avoid IndexOutOfBound as input may be asumed as the index rather than Object in the vector

        for(int i =0; i< vect.size(); i++) {
            System.out.print(" "+vect.get(i));

        }

        System.out.println();

    }
}