import java.util.Stack;

public class LeetCode0032{
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 0){
            return 0;
        }
        int count = 0;
        int max = 0;
        Stack<Character> sc = new Stack<>();
        sc.push(s.charAt(0));
        for (int i = 1; i < s.length();i++){
            char c = s.charAt(i);
            if (c == '('){
                sc.push(c);
            } else {
                if (!sc.empty() && sc.peek() == '('){
                    count += 2;
                    sc.pop();
                } else {
                    sc.push(c);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        
    }
}