public class SingalCircleList{
    private Node nil;

    public SingalCircleList(){
        nil = new Node();
        nil.next = nil;
    }

    /*
    * 头插法，时间O(1)
    */
    public void insert(Node n){
        n.next = nil.next;
        nil.next = n;
    }

    /*
    * 删除指定结点，需要找到结点前的那一个结点，时间O(n)
    */
    public void delete(Node x){
        Node head = nil;
        while (head.next != x){
            head = head.next;
        }
        head.next = head.next.next;
    }

    /*
    * 时间O(n)
    */
    public Node search(int k){
        Node head = nil.next;
        nil.key = k;
        while (head.key != k){
            head = head.next;
        }
        nil.key = -1;
        return head;
    }

    @Override
    public String toString(){
        Node head = nil.next;
        String str = "";
        while (head!= nil){
            str += head.key + " -> ";
            head = head.next;
        }
        return str + " null ";
    }

    public static void main(String[] args) {
        SingalCircleList scl = new SingalCircleList();
        for (int i = 0;i < 5; i++){
            scl.insert(new Node(i));
        }
        System.out.println(scl);
        Node n = scl.search(3);
        scl.delete(n);
        System.out.println(scl);
    }
}