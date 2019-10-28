import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode0402{
    public String removeKdigits(String num, int k) {
        if (num == null || num.isEmpty() || k < 0 || k >= num.length()){
            return "0";
        } else if (k == 0){
            return num;
        }
        Deque<Character> stack = new ArrayDeque<>();
        stack.addFirst(num.charAt(0));
        int index = 1;
        for (;index < num.length() && k > 0;index++){
            char c1 = stack.getFirst();
            char c2 = num.charAt(index);
            if (c1 > c2){
                while (!stack.isEmpty() && k > 0){
                    char ct = stack.removeFirst();
                    if (ct <= c2){
                        stack.addFirst(ct);
                        break;
                    } else {
                        k--;
                    }
                }
                stack.addFirst(c2);
            } else {
                stack.addFirst(c2);
            }
        }

        while (k != 0){
            stack.removeFirst();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        while (index < num.length()){
            sb.append(num.charAt(index));
            index++;
        }
        return removeZero(sb.toString());  
    }

    public String removeZero(String num) {
        int index = 0;
        while (index < num.length() && num.charAt(index) == '0'){
            index++;
        }
        return (index >= num.length()) ? "0" : num.substring(index);
    }
}