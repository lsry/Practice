public class QueueToStack{
    private MyQueue q1;
    private MyQueue q2;

    public QueueToStack(){
        q1 = new MyQueue();
        q2 = new MyQueue();
    }

    /*
    * 保证只有一个队列有元素
    * 均空，则进入第一个队列，否则进入有元素的那个队列
    */
    public void push(int x) throws FlowException{
        if ((q1.isEmpty()&&q2.isEmpty())){
            q1.enQueue(x);
        }else if (!q1.isEmpty()){
            if (q1.isFull()){
                throw new FlowException("overFlow");
            }else {
                q1.enQueue(x);
            }
        }else {
            if (q2.isFull()){
                throw new FlowException("overFlow");
            }else {
                q2.enQueue(x);
            } 
        }
    }

    /*
    * 将有元素的队列中的前length - 1个元素移动到空队列中，然后将最后一个弹出即可
    */
    public int pop() throws FlowException{
        if ((q1.isEmpty()&&q2.isEmpty())){
            throw new FlowException("underFlow");
        }else if (!q1.isEmpty()) {
            int len = q1.length();
            for(int i = 0;i < len - 1;i++){
                q2.enQueue(q1.deQueue());
            }
            return q1.deQueue();
        }else {
            int len = q2.length();
            for(int i = 0;i < len - 1;i++){
                q1.enQueue(q2.deQueue());
            }
            return q2.deQueue();
        }
    }

    public static void main(String[] args){
        QueueToStack qs = new QueueToStack();
        try{
            for(int i = 0;i < 5;i++){
                qs.push(i);
            }
            for(int i = 0;i < 5;i++){
                System.out.print(qs.pop()+"\t");
            }
        }catch(FlowException e){
            System.out.println(e.getMessage());
        }
    }
}