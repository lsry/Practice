public class LeetCode0883{
    public int projectionArea(int[][] grid) {
        int base = 0;
        int horizon = 0;
        int vertical = 0;

        for (int i = 0;i < grid.length;i++){
            int max = 0;
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] != 0){
                    base ++;
                }
                if (grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            vertical += max;
        }

        for (int j = 0;j < grid[0].length;j++){
            int max = 0;
            for (int i = 0;i< grid.length;i++){
                if (grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            horizon += max;
        }

        return base + horizon + vertical;
    }
}