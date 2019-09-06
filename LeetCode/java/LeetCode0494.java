public class LeetCode0494{
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0,zeros = 0;
        for (int x : nums){
            sum += x;
            if (x == 0){
                zeros++;
            }
        }
        if ((S + sum) % 2 == 1 || sum < S){
            return 0;
        }
        int arr[] = new int[nums.length - zeros];
        for (int i = 0,j = 0;i < nums.length;i++){
            if (nums[i] != 0){
                arr[j] = nums[i];
                j++;
            }
        }
        int pos = (S + sum) >> 1;
        int[][] dp = new int[arr.length+1][pos+1];
        dp[0][0] = 1;
        for (int i = 1;i <= arr.length;i++){
            dp[i][0] = 1;
            for (int j = 1;j <= pos;j++){
                if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][pos] * (1 << zeros);
    }

    public static void main(String[] args) {
        
    }
}