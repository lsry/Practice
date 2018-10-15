/*
 * 循环队列实现，
 * 空出一个格子以区别队头和尾
 */
public class MyDeQueue 
{
    private static final int capacity = 100;
    private int[] arr;
    private int head;
    private int tail;

    public MyDeQueue(){
        arr = new int[capacity];
        head = 0;
        tail = 0;
    }
    
    /*
    * 从尾部入队,同普通队列一样，向序号增加的方向扩展
    * @param x 入队元素
    */
    public void enQueueTail(int x)throws FlowException{
        if ((tail+1)%capacity == head){          
            throw new FlowException("overflow");
        }else{
            arr[tail] = x;
            tail = (tail + 1) % capacity;
        }
    }

    /*
    * 从头部出队,同普通队列一样
    */
    public int deQueueHead() throws FlowException{
        if (tail == head)
        {
            throw new FlowException("underflow");
        }else{
            int x = arr[head];
            head = (head + 1) % capacity;
            return x;
        }
    }
    
    /*
    * 从头部入队,应该向序号减少的方向扩展，
    * @param x 入队元素
    */
    public void enQueueHead(int x)throws FlowException{
        if ((head-1+capacity)%capacity == tail)
        {
            throw new FlowException("overflow");
        }else{
            head = (head - 1 + capacity) % capacity;
            arr[head] = x;
        }
    }

    /*
    * 从尾部出队,尾指针指向的序号并没有元素，有的是前一个序号
    */
    public int deQueueTail() throws FlowException{
        if (tail == head)
        {
            throw new FlowException("underflow");
        }else{
            tail = (tail - 1 + capacity) % capacity;
            return arr[tail];
        }
    }

    @Override
    public String toString(){
         String str = "";
         for (int i = head;i != tail;i = (i + 1) % capacity)
         {
             str += arr[i] + "\t";
         }
         str += "\n" + "head: " + head + ", tail: " + tail;
        return str;
    }

    public static void main(String[] args) 
    {
        MyDeQueue de = new MyDeQueue();
        try
        {
            for (int i = 0;i < 10;i++)
            {
                if (i%2 == 0)
                {
                    de.enQueueTail(i);
                    System.out.println(de);
                }else{
                    de.enQueueHead(i);
                    System.out.println(de);
                }
            } 
        }
        catch (FlowException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}
