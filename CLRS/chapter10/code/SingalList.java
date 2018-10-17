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
    public Node last;

    public SingalList(){
        nil = new Node();
        nil.next = nil;
        last = nil;
    }

    public void insertFromHead(Node n){
        n.next = nil.next;
        nil.next = n;
    }

    public Node delHeadNode(){
        Node n = nil.next;
        if (n.next == nil){
            last = nil;
        }
        nil.next = nil.next.next;
        return n;
    }

    public void insertFromTail(Node n){
        n.next = last.next;
        last.next = n;
        last = n;
    }

    /*
    * 10.2-7
    * 先提取nil,形成一个空链表，然后遍历每一个元素，用头插法插到该链表中
    */
    public void reverse(){
        Node head = nil.next;
        nil.next = nil;
        while (head != nil){
            Node temp = head.next;
            head.next = nil.next;
            nil.next = head;
            head = temp;
        }
    }

    @Override
    public String toString(){
        Node head = nil.next;
        String res = "";
        while (head != nil){
            res += head.key + " -> ";
            head = head.next;
        }
        res += "null";
        return res;
    }

    public static void main(String[] args){
        SingalList sl = new SingalList();
        for (int i = 0;i < 5; i++){
            sl.insertFromTail(new Node(i));
        }
        System.out.println(sl);
        sl.reverse();
        System.out.println(sl);
    }
}