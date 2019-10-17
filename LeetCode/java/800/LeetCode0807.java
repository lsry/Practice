public class LeetCode0807{
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] across = new int[grid.length];
        int[] vertical = new int[grid[0].length];
        for (int i = 0;i < grid.length;i++){
            across[i] = 0;
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] > across[i]){
                    across[i] = grid[i][j];
                }
            }
        }
        for (int j = 0;j < grid[0].length;j++){
            vertical[j] = 0;
            for (int i = 0;i < grid.length;i++){
                if (grid[i][j] > vertical[j]){
                    vertical[j] = grid[i][j];
                }
            }
        }
        int add = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                add += Math.min(across[i],vertical[j]) - grid[i][j];
            }
        }
        return add;
    }
}