public class LeetCode0036{
    public boolean grid(char[][] board,int r,int c){
        int[] arr = new int[10];
        for (int i = 0;i < 10;i++){
            arr[i] = 0;
        }
        for (int i = 0;i < 3;i++){
            for (int j = 0;j < 3;j++){
                char ch = board[r+i][c+j];
                if (ch != '.'){
                    int num = ch - '0';
                    if (arr[num] == 1){
                        return false;
                    } else {
                        arr[num] = 1;
                    }
                }
            }
        }
        return true;
    }

    public boolean row(char[][] board,int r){
        int[] arr = new int[10];
        for (int i = 0;i < 10;i++){
            arr[i] = 0;
        }
        for (int j = 0;j < 9;j++){
            char ch = board[r][j];
            if (ch != '.'){
                int num = ch - '0';
                if (arr[num] == 1){
                    return false;
                } else {
                    arr[num] = 1;
                }
            }
        }
        return true;
    }

    public boolean column(char[][] board,int c){
        int[] arr = new int[10];
        for (int i = 0;i < 10;i++){
            arr[i] = 0;
        }
        for (int i = 0;i < 9;i++){
            char ch = board[i][c];
            if (ch != '.'){
                int num = ch - '0';
                if (arr[num] == 1){
                    return false;
                } else {
                    arr[num] = 1;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        // 九宫格
        for(int i = 0;i <= 6;i += 3){
            for (int j = 0;j <= 6;j += 3){
                if (!grid(board, i, j)){
                    return false;
                }
            }
        }
        // 行
        for (int i = 0;i < 9;i++){
            if (!row(board, i)){
                return false;
            }
        }
        // 列
        for (int j = 0;j < 9;j++){
            if (!column(board, j)){
                return false;
            }
        }
        return true;
    }
}