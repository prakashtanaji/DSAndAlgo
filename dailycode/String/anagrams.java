class anagrams {

    static int counter = 0;
    public static void main(String[] args) {

        String str = "abc";

        char[] c = str.toCharArray();

        for(int i = 0; i<c.length; i++) {

            swap(c, 0, i);
            switchchars(c, 1);
            swap(c, 0, i);
        }

        System.out.println("Total anagrams:"+ counter);
    }

    static void switchchars(char[] c, int currPos) {
        counter++;

        String str = String.valueOf(c);
        System.out.println(str);
        
        if(currPos == c.length-1) return;

        for(int i = currPos+1; i< c.length; i++) {

            swap(c, currPos, i);
            switchchars(c, currPos+1);
            swap(c, currPos, i);
        }

    }

    static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}