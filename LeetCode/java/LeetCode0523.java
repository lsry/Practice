public class LeetCode0523{
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            dp[i] = dp[i-1] + nums[i];
        }
        for (int i = 0;i < nums.length - 1;i++){
            for (int j = i + 1;j < nums.length;j++){
                int sum = dp[j] - dp[i] + nums[i];
                if (sum == k || (k != 0 && sum % k == 0)){
                    return true;
                }
            }
        }
        return false;
    }
}