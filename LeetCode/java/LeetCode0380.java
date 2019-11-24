public class LeetCode0380{
    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        boolean res = set.insert(1);
        System.out.println(res);
        res = set.remove(2);
        System.out.println(res);
        res = set.insert(2);
        System.out.println(res);
    }
}

class Node implements Comparable<Node>{
    public int val;
    public Node next;
    public int positive = 1;

    public Node(int val){
        positive = (val >= 0) ? 1 : -1;
        this.val = Math.abs(val);
        next = null;
    }

    public int getValue(){
        return val * positive;
    }

    @Override
    public int compareTo(Node n) {
        if (this.positive  == 1 && n.positive == 1){
            return this.val - n.val;
        } else if (this.positive == 1 && n.positive == -1){
            return 1;
        } else if (this.positive == -1 && n.positive == 1){
            return -1;
        } else {
            return n.val - this.val;
        }
    }
}

class RandomizedSet {

    private Node[] data;

    private int capacity = 8;
    private int size = 0;

    private double loadFactor = 0.75;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        data = new Node[capacity];
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if ((capacity * loadFactor < (size + 1)) && (Integer.MAX_VALUE >> 1 > capacity)){
            capacity = capacity << 1;
            Node[] dataTemp = new Node[capacity];
            for (int i = 0;i < data.length;i++){
                if (data[i] != null){
                    Node node = data[i];
                    while (node != null){
                        insertToArray(dataTemp, node.getValue());
                        node = node.next;
                    }
                }
            }
            data = dataTemp;
        }
        boolean res = insertToArray(data, val);
        if (res){
            size--;
        }
        return res;
    }

    private boolean insertToArray(Node[] nodes,int val){
        Node n = new Node(val); 
        int pos = n.val % nodes.length;
        if (nodes[pos] == null){
            nodes[pos] = n;
            return true;
        } else {
            if (n.compareTo(nodes[pos]) < 0){
                n.next = nodes[pos];
                nodes[pos] = n;
                return true;
            } else if (n.compareTo(nodes[pos]) == 0){
                return false;
            } else {
                Node pNode = nodes[pos];
                while (pNode.next != null && pNode.next.compareTo(n) < 0){
                    pNode = pNode.next;
                } 
                if (pNode.next != null && pNode.next.compareTo(n) == 0){
                    return false;
                } else {
                    n.next = pNode.next;
                    pNode.next = n;
                    return true;
                }                
            }
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (capacity * loadFactor > (size - 1) && capacity >= 16){
            capacity = capacity >> 1;
            Node[] dataTemp = new Node[capacity];
            for (int i = 0;i < data.length;i++){
                if (data[i] != null){
                    Node node = data[i];
                    while (node != null){
                        insertToArray(dataTemp, node.getValue());
                        node = node.next;
                    }
                }
            }
            data = dataTemp;
        }
        boolean res = removeData(val);
        if (res){
            size--;
        }
        return res;
    }

    private boolean removeData(int val){
        Node n = new Node(val);
        int pos = n.val % capacity;
        if (data[pos] == null || data[pos].compareTo(n) > 0){
            return false;
        } else if (data[pos].compareTo(n) == 0){
            data[pos] = data[pos].next;
            return true;
        } else {
            Node cur = data[pos];
            while (cur.next != null && cur.next.compareTo(n) < 0){
                cur = cur.next;
            }
            if (cur.next == null || cur.next.compareTo(n) > 0){
                return false;
            } else {
                cur.next = cur.next.next;
                return true;
            }
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int x = 0;
        do {
            x = getScopeRandom(0, capacity);
        } while (data[x] == null);
        int len = getLinkLength(data[x]);
        int pos = getScopeRandom(0, len);
        Node cur = data[x];
        while (pos > 0){
            cur = cur.next;
            pos--;
        }
        return cur.getValue();
    }

    private int getScopeRandom(int x1,int x2){
        double f = Math.random() / Math.nextDown(1.0);
        return (int)(x1 * (1.0 - f) + x2 * f);
    }

    private int getLinkLength(Node node) {
        if (node == null){
            return 0;
        } 
        int len = 0;
        Node cur = node;
        while (cur != null){
            cur = cur.next;
            len++;
        }
        return len;
    }
}
