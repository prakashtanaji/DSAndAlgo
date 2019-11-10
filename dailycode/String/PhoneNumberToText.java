import java.util.Vector;

class phonenumbertotext {


    // 2 at 0 i.e., digit-2
    static String[] letterMap = new String[] { "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    static Vector<String> vect = new Vector<>();
    public static void main(String[] args) {

        // no zero and 1 in phone number
        String str = "425638327";

        // validate of all are digits

        for(char c: str.toCharArray()) {
            if(c >57 || c<50) {
                System.out.println("contains invalid digits for this problem");

                return;
            }
        }

        recurse(new char[str.length()], str.toCharArray(), 0);

        System.out.println("There are total of "+ vect.size());

        for(String res: vect) {
            System.out.println(res);
        }

    }

    static void recurse(char[] output, char[] digits, int curr) {
        if(curr == digits.length) {
            vect.add(String.valueOf(output)); return;
        }

        int digitInt = Character.getNumericValue(digits[curr]);

        for(char c: letterMap[digitInt-2].toCharArray()) {
            output[curr] = c;
            recurse(output, digits, curr+1);
        }
    }
}