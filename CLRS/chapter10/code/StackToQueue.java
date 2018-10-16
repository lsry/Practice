public class StackToQueue{
    private MyStack s1;
    private MyStack s2;
    
    public StackToQueue(){
        s1 = new MyStack();
        s2 = new MyStack();
    }

    /*
    * 用第一个栈来入队，所以最先进的元素在最下面
    * @param x 进队元素
    */
    public void enQueue(int x) throws FlowException{
        if (s1.isFull()){
            throw new FlowException("overflow");
        }else{
            s1.push(x);
        }
    }

    /*
    * (1) 如果两个栈均空，则表示没有元素
    * (2) 栈1不空栈2空，则将栈1元素移动到栈2，此时栈2从栈顶到栈尾为出队顺序，直接弹出栈即可
    * (3) 两个栈均不空，则直接栈2出栈
    */
    public int deQueue() throws FlowException{
        if (s2.isEmpty()&&s1.isEmpty()){
            throw new FlowException("underFlow");
        }else if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
        return s2.pop();
    }

    public static void main(String[] args){
        StackToQueue sq = new StackToQueue();
        try{    
            for (int i = 0;i < 5;i++){
                sq.enQueue(i);
            }
            for (int i = 0;i < 5;i++){
                System.out.println(sq.deQueue());
            }
            System.out.println();
        }catch(FlowException e){
            System.out.println(e.getMessage());
        }
        
    }
}