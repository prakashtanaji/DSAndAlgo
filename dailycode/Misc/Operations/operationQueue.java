import java.util.*;

class operationQueue {
    public static void main(String[] args) {
        QueueOp();


    }

    static void QueueOp() {

        // 'DECK' - double queue
        //Deque deque = new LinkedList();
        // add() addFirst() addLast()
        // remove() removeFirst() removeLast()
        // peekFirst() peekLast()

        Queue<Integer> qu = new LinkedList<>(); // not new Queue<>() which is abstract
        qu.add(24);
        qu.offer(34); // safe since it doesnt throw exception like add in case capacity restricted queue

        System.out.println("Print queue items");
        while(!qu.isEmpty()) {
            int peeked = qu.peek();
            System.out.print(" " + qu.remove()); // prefer poll() as it will not throw exception(but return null) when there are no items
        }
        //qu.size()
        //qu.forEach(action);

        // EXCEPTION       No EXCEPTION
        // qu.element();   peek
        // qu.add(e)       offer
        // qu.remove()     poll
    }
}