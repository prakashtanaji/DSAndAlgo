class anagrams {

    static int counter = 0;
    public static void main(String[] args) {

        String str = "abac";

        char[] c = str.toCharArray();

        anagram(c, 0);

        System.out.println("Total iterations:"+ counter);
    }

    static void anagram(char[] temp, int p1) {
        if(p1== temp.length-1) {
            
            System.out.println(String.valueOf(temp));
            return;
        }

        for(int i=p1; i<temp.length; i++) {

            if(p1!=i && temp[i] == temp[p1]) continue;
            counter++;
            swap(temp, p1, i);
            anagram(temp, p1+1);
            swap(temp, p1, i);
        }
    }

    static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}