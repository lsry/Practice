public class LeetCode0064 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1;i < grid[0].length;i++) {
            dp[i] = dp[0] + grid[0][i];
        }
        for (int i = 1;i < grid.length;i++) {
            dp[0] += grid[i][0];
            for (int j = 1;j < grid[0].length;j++) {
                dp[j] = Math.min(dp[j],dp[j - 1]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }
}