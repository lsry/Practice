public class SingalListStack{
    private SingalList slist;

    public SingalListStack(){
        slist = new SingalList();
    }

    public void push(int x){
        slist.insertFromHead(new Node(x));
    }

    public int pop(){
        Node n = slist.delHeadNode();
        return n.key;
    }

    public static void main(String[] args){
        SingalListStack ss = new SingalListStack();
        for (int i = 0;i < 5;i++){
            ss.push(i);
        }
        for (int i = 0;i < 5;i++){
            System.out.print(ss.pop()+"\t");
        }
    }
}