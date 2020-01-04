import java.util.HashMap;
import java.util.Map;

public class LeetCode1000{
    private int[] arrSum;
    private Map<String,Integer> dp = new HashMap<>();
    private int Ko = 0;

    public int mergeStones(int[] stones, int K) {
        if (stones.length <= 1){
            return 0;
        } else if ((stones.length - 1) % (K - 1) != 0){
            return -1;
        }
        Ko = K;
        arrSum = new int[stones.length + 1];
        arrSum[0] = 0;
        for (int i = 0;i < stones.length;i++){
            arrSum[i+1] = arrSum[i] + stones[i];
            //dp.put(i+ ":" + i + ":" + 1, 0);
        }
        return helper(0, stones.length - 1, 1);
    }

    public int helper(int start,int end,int K) {
        String key = start + ":" + end + ":" + K;
        if (dp.containsKey(key)){
            return dp.get(key);
        }
        if (K == 1){
            int value = helper(start, end, Ko);
            int sum = arrSum[end + 1] - arrSum[start];
            if (value + sum > 0){
                value += sum;
            }
            dp.put(key, value);
            return value;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start + K - 2;i < end;i++){
            int p1 = (i - start + 1 == K - 1 || i == start) ? 0 : helper(start, i, K - 1);
            int p2 = (i + 1 == end) ? 0 : helper(i + 1, end, 1);
            if (p1 != Integer.MAX_VALUE && p2 != Integer.MAX_VALUE){
                min = Math.min(min, p1 + p2);
            }
            
        }
        dp.put(key, min);
        return min;
    }
    public static void main(String[] args) {
        LeetCode1000 l = new LeetCode1000();
        System.out.println(l.mergeStones(new int[]{6,4,9,3,1}, 3));
        System.out.println(1);
    }
}