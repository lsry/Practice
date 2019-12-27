public class LeetCode1275{
    public String tictactoe(int[][] moves) {
        if (moves.length < 5) {
            return "Pending";
        }
        int[][] grid = new int[3][3];
        for (int i = 0;i < moves.length;i++) {
            if (i % 2 == 0) {
                grid[moves[i][0]][moves[i][1]] = 1000;
            } else {
                grid[moves[i][0]][moves[i][1]] = -1;
            }
        }
        boolean flag = false;
        for (int i = 0;i < 3;i++){
            int rsum = 0,csum = 0;
            for (int j = 0;j < 3;j++) {
                rsum += grid[i][j];
                csum += grid[j][i];
                if (grid[i][j] == 0) {
                    flag = true;
                }
            }
            if (rsum == 3000 || csum == 3000) {
                return "A";
            } else if (rsum == -3 || csum == -3) {
                return "B";
            }
        }
        int posd = grid[0][0] + grid[1][1] + grid[2][2];
        int negd = grid[0][2] + grid[1][1] + grid[2][0];
        if (posd == 3000 || negd == 3000) {
            return "A";
        } else if (posd == -3 || negd == -3) {
            return "B";
        }
        return flag ? "Pending" : "Draw";
    }
}