package Operations;

import java.util.*;

public class operationStack {
    public static void main(final String[] args) {
        System.out.println("Stack testing");

        Stack<Integer> st = new Stack<>();

        addToStack(st);
        iterateStack(st);

        st.pop();
        st.add(89);
        st.push(87);
        iterateStack(st);

        int peekedItem = st.peek();

        System.out.println("peekedItem " + peekedItem);
    }

    static void addToStack(Stack<Integer> st) {
        st.add(23);
        st.add(54);
        st.add(27);
    }

    static void iterateStack(Stack<Integer> st) {
        Iterator<Integer> it = st.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();
    }
}