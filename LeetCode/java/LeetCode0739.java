import java.util.Stack;

public class LeetCode0739{
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length <= 0){
            return new int[]{};
        }
        int[] arr = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < T.length;i++){
            if (stack.empty()){
                stack.push(i);
            } else {
                while (!stack.empty() && T[i] > T[stack.peek()]){
                    int x = stack.pop();
                    arr[x] = i - x;
                }
                stack.push(i);
            }
        }
        while (!stack.empty()){
            int x = stack.pop();
            arr[x] = 0;
        }

        return arr;

    }

    public static void main(String[] args) {
        
    }
}