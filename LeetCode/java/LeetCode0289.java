public class LeetCode0289{
    // 非原址操作
    public void gameOfLife(int[][] board) {
        int[][] panel = new int[board.length][board[0].length];
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                int num = liveNum(board,i,j);
                if (board[i][j] == 1){
                    panel[i][j] = (num == 2 || num == 3) ? 1 : 0;
                } else {
                    panel[i][j] = (num == 3) ? 1 : 0;                   
                }
            }
        }
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                board[i][j] = panel[i][j];
            }
        }
    }

    public int liveNum(int[][] board,int x,int y){
        int nums = 0;
        for (int i = x - 1,j = y - 1;j <= y + 1;j++){
            if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 1){
                nums++;
            }
        }
        for (int i = x + 1,j = y - 1;j <= y + 1;j++){
            if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 1){
                nums++;
            }
        }
        if (x >= 0 && y - 1 >= 0 && x < board.length && y - 1 < board[0].length && board[x][y - 1] == 1){
            nums++;
        }
        if (x >= 0 && y + 1 >= 0 && x < board.length && y + 1 < board[0].length && board[x][y + 1] == 1){
            nums++;
        }
        return nums;
    }
}