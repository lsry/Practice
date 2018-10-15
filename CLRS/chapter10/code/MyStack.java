class FlowException extends Exception
{
    public FlowException(){}
    public FlowException(String msg){
        super(msg);
    }
}

public class MyStack 
{
    private static final int capacity = 100;      
    private int[] arr ;
    private int top;

    public MyStack(){
        arr = new int[capacity];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int x) throws FlowException{
        if (top+1 >= capacity)
        {
            throw new FlowException("overflow");
        }else{
            top++;
            arr[top] = x;
        }
    }

    public int pop() throws FlowException{
        if (top == -1)
        {
            throw new FlowException("underflow");
        }else{
            top--;
            return arr[top+1];
        }
    }

    public int length(){
        return top + 1;
    }

    @Override 
    public String toString(){
        String rs = "size :" + (top + 1) + "\n";
        for (int i = 0;i <= top;i++)
        {
            rs += arr[i] + "\t";
        }
        rs += "\n";
        return rs;
    }
    public static void main(String[] args) 
    {
        MyStack st = new MyStack();
        try
        {        
            System.out.println(st);
            st.push(40);
            System.out.println(st);
            st.pop();
            System.out.println(st);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
