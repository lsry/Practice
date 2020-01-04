import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode0225{}

class MyStack {
    private Deque<Integer> in;
    private Deque<Integer> out;
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        in.addLast(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int t = top;
        while (in.size() > 1){
            top = in.removeFirst();
            out.addLast(top);
        }
        in.removeFirst();
        Deque<Integer> temp = in;
        in = out;
        out = temp;
        return t;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
