import java.io.*;
import java.util.*;

class singlelistreverse {

    static int[][] dist;
    static int[] prev;

    static Node head = null;
    public static void main(String[] args) 
    {
        System.out.println("singlelisreverse");

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);

        if(root == null) {
            System.out.println("List is null");
        }

        Node curr = root;
        root = reverseIt(curr);
        printList(root);

        // root = new Node(1);
        // root.next = new Node(2);
        // root.next.next = new Node(3);
        // root.next.next.next = new Node(4);

        // Node head1 = null;
        // Node ret = reverseRecurse(root, head1);
        // ret.next = null;

        //printList(head);
    }

    static Node reverseRecurse(Node curr, Node head1){

        if(curr.next == null) {

            head = curr;
            return curr;
        }

        reverseRecurse(curr.next, head1);

        curr.next.next = curr;

        return curr;

    }

    static void printList(Node root) {

        Node curr = root;

        while(curr != null) {
            System.out.print(curr.value+ "->");

            curr = curr.next;
        }

        System.out.println("null");

    }

    static Node reverseIt(Node root) {
        Node curr = root;
        Node temp = null;
        Node prev = null;

        while(curr.next != null) {
            temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        curr.next = prev;

        return curr;
    }
}

class Node {
    int value;
    Node next;

    public Node(int val){
        value = val;
    }
}
