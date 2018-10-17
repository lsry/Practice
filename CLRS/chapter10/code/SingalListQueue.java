public class SingalListQueue{
    private SingalList sList;

    public SingalListQueue(){
        sList = new SingalList();
    }

    public void enQueue(int x){
        sList.insertFromTail(new Node(x));
    }

    public int deQueue(){
        Node n = sList.delHeadNode();
        return n.key;
    }

    public static void main(String[] args){
        SingalListQueue sq = new SingalListQueue();
        for (int i = 0;i < 5;i++){
            sq.enQueue(i);
        }
        for (int i = 0;i < 5;i++){
            System.out.print(sq.deQueue()+"\t");
        }
    }
}