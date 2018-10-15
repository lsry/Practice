public class MyQueue 
{
    private static final int capacity = 101;
    private int[] arr;
    private int head;
    private int tail;

    public MyQueue(){
        arr = new int[capacity];
        head = 0;
        tail = 0;
    }

    public void enQueue(int x) throws FlowException{
        if ((tail+1)%capacity == head)
        {
            throw new FlowException("overflow");
        }else{
            arr[tail] = x;
            tail = (tail + 1) % capacity;
        }
    }

    public int deQueue() throws FlowException{
        if (tail == head)
        {
            throw new FlowException("underflow");
        }else{
            int x = arr[head];
            head = (head + 1) % capacity;
            return x;
        }
    }

    public int length(){
        return (tail - head + capacity) % capacity;
    }

    @Override 
    public String toString(){
        String rs = "size :" + ((tail - head + capacity) % capacity) + "\n";
        for (int i = head;i != tail;i = (i+1)%capacity)
        {
            rs += arr[i] + "\t";
        }
        rs += "\n";
        return rs;
    }

    public static void main(String[] args) 
    {
        MyQueue qu = new MyQueue();
        try
        {
            qu.enQueue(20);
            System.out.println(qu);
            qu.enQueue(30);
            System.out.println(qu);
            qu.deQueue();
            System.out.println(qu);   
        }
        catch (FlowException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
