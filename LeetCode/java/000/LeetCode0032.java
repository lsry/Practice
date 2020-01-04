import java.util.Stack;

public class LeetCode0032{
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 0){
            return 0;
        }
        Stack<Integer> si = new Stack<>();
        si.push(-1);
        int max = 0;
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if (c == '('){
                si.push(i);
            } else {
                si.pop();
                if (si.empty()){
                    si.push(i);
                } else {
                    max = Math.max(max, i - si.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode0032 l32 = new LeetCode0032();
        System.out.println(")()()) 4 : " + l32.longestValidParentheses(")()())"));
        System.out.println("(() 2 : " + l32.longestValidParentheses("(()"));
        System.out.println("()(() 2 : " + l32.longestValidParentheses("()(()"));
        System.out.println("()()))()(()()) 8 : " + l32.longestValidParentheses("()()))()(()())"));
        System.out.println("() 2 : " + l32.longestValidParentheses("()"));
    }
}