import java.util.ArrayList;
import java.util.List;

public class LeetCode0037{
    class Pair{
        public int x;
        public int y;

        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public boolean grid(char[][] board,int r,int c){
        int[] arr = new int[10];
        for (int i = 0;i < 10;i++){
            arr[i] = 0;
        }
        int r0 = r / 3 * 3;
        int c0 = c / 3 * 3;
        for (int i = 0;i < 3;i++){
            for (int j = 0;j < 3;j++){
                char ch = board[r0+i][c0+j];
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

    public boolean fill(char[][] board,List<Pair> lp,int n) {
        printBoard(board);
        boolean flag = true;
        Pair p = lp.get(n);
        int x = 1;
        for (;x <= 9;x++){
            char charx = (char)('0' + x);
            board[p.x][p.y] = charx;
            if (grid(board, p.x,p.y) && row(board, p.x) && column(board, p.y) 
                && (n+1 == lp.size() || fill(board,lp,n+1))){
                    break;
            } else {
                board[p.x][p.y] = '.';
            }
        } 
        if (x > 9){
            flag = false;
        }      
        return flag;   
    }

    public void solveSudoku(char[][] board) {
        List<Pair> lp = new ArrayList<>();
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j <board[0].length;j++){
                if (board[i][j] == '.'){
                    lp.add(new Pair(i,j));
                }
            }
        }
        fill(board,lp,0);
    }

    public void printBoard(char[][] board){
        System.out.println("start: ");
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] b1 = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        LeetCode0037 l37 = new LeetCode0037();
        l37.solveSudoku(b1);
        l37.printBoard(b1);
    }
}