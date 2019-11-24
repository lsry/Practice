public class LeetCode0565{
    public int arrayNesting(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0;i < dp.length;i++){
            dp[i] = -1;
        }
        boolean[] flags = new boolean[nums.length];
        int max = -1;
        for (int i = 0;i < nums.length;i++){
            max = Math.max(max, helper(nums,dp,flags,i));
        }
        return max;
    }

    private int helper(int[] nums,int[] dp,boolean[] flags,int index){
        if (dp[index] != -1){
            return dp[index];
        } else if (flags[index] == true){
            return 0;
        }
        flags[index] = true;
        int len = 1 + helper(nums, dp, flags, nums[index]);
        flags[index] = false;
        dp[index] = len;
        return len;
    }
}