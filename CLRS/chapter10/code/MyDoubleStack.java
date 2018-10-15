public class MyDoubleStack 
{
    private static final int capacity = 100;      
    private int[] arr ;
    private int topHead;
    private int topTail;

     public MyStack(){
        arr = new int[capacity];
        topHead = -1;
        topTail = capacity;
    }

    public void pushHead(int x) throws FlowException{
        if (topHead+1 >= topTail)
        {
            throw new FlowException("overflow");
        }else{
            topHead++;
            arr[topHead] = x;
        }
    }

     public int popHead() throws FlowException{
        if (topHead == -1)
        {
            throw new FlowException("underflow");
        }else{
            top--;
            return arr[top+1];
        }
    }

    public void pushTail(int x) throws FlowException{
        if (topTail-1 <= topHead)
        {
            throw new FlowException("overflow");
        }else{
            topTail--;
            arr[topTail] = x;
        }
    }

    public int popTail() throws FlowException{
        if (topTail == capacity)
        {
            throw new FlowException("underflow");
        }else{
            topTail++;
            return arr[top-1];
        }
    }

    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
    }
}
