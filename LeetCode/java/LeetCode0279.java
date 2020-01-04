public class LeetCode0279{
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2;i <= n;i++){
            dp[i] = -1;
        }
        return helper(dp, n);
    }

    private int helper(int[] dp,int n){
        if (dp[n] != -1){
            return dp[n];
        } 
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n){
            dp[n] = 1;
            return 1;
        }
        int min = Integer.MAX_VALUE;
        // 优化点：只用遍历每一个平方数即可
        for (int i = 1;i * i <= n / 2;i++){
            int num = 1 + helper(dp, n - i * i);
            if (num < min){
                min = num;
            }
        }
        dp[n] = min;
        return min;
    }
}