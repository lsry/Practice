class Node {
    public int key;
    public Node next;
    public Node prev;

    public Node(int k){
        key = k;
        next = prev = null;
    }

    public Node(){}
}

public class SingalList{
    public Node nil;

    public SingalList(){
        nil = new Node();
    }

    public void insert(Node n){
        n.next = nil.next;
        n.prev = nil;
        nil.next = n;
    }

    @Override
    public String toString(){
        Node head = nil.next;
        String res = "";
        while (head != null){
            res += head.key + " -> ";
            head = head.next;
        }
        res += "null";
        return res;
    }

    public static void main(String[] args){
        SingalList sl = new SingalList();
        for (int i = 0;i < 5; i++){
            sl.insert(new Node(i));
        }
        System.out.println(sl);
    }
}