import java.util.HashMap;
import java.util.Map;

class ElementNode {
    int data;
    int rank;
    ElementNode parent;

    public ElementNode(int _data, int _rank) {
        data = _data;
        rank = _rank;
        parent = this;
    }
}

class UnionFind {
    static Map<Integer, ElementNode> mp = new HashMap<>();

    public static void main(String[] args) {

        int size = 6;

        for(int i=0; i< size; i++) {
            makeSet(i);
        }

        union(mp.get(0), mp.get(1));
        union(mp.get(1), mp.get(3));
        union(mp.get(3), mp.get(0));
        union(mp.get(2), mp.get(4));
        union(mp.get(4), mp.get(5));
        union(mp.get(2), mp.get(5));

        for(ElementNode n: mp.values()){
            System.out.println("Data:"+n.data + ",parent:"+n.parent.data);
        }
    }

    static void makeSet(int id) {

        ElementNode n = new ElementNode(id, 0);

        mp.put(id, n);
    }

    static ElementNode find(ElementNode n) {

        ElementNode x = n.parent;

        while(x.parent != x) {
            x = find(x.parent);

            // path compression
            n.parent = x;
        }

        return x;
    }

    static void union(ElementNode n1, ElementNode n2) {

        ElementNode p1 = find(n1);
        ElementNode p2 = find(n2);

        if(p1.data == p2.data) return;
        if(p1.rank >= p2.rank) {
            p1.rank = p1.rank == p2.rank ? p1.rank + 1 : p1.rank; 
            p2.parent =  p1;
        }
        else {
            p1.parent =  p2;
        }
    }
}