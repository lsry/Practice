import java.util.ArrayList;
import java.util.List;

public class LeetCode0051{
    private boolean[] visited;
    private List<List<String>> res = new ArrayList<>();
    private List<String> ls = new ArrayList<>();
    private int N = 0;

    public List<List<String>> solveNQueens(int n) {
        visited = new boolean[n];
        N = n;
        for (int i = 0;i < n;i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j < n;j++){
                if (j == i){
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            ls.add(sb.toString());
        }
        helper(new ArrayList<String>(), 0);
        return res;
    }

    public void helper(List<String> panel,int n) {
        if (n >= N){
            if (validate(panel)){
                res.add(new ArrayList<>(panel));
            }
        } else {
            for (int i = 0;i < N;i++){
                if (visited[i] == false){
                    visited[i] = true;
                    panel.add(ls.get(i));
                    helper(panel, n + 1);
                    panel.remove(panel.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    public boolean validate(List<String> panel) {
        for (int i = 0;i < N;i++){
            int x = i,y = 0;
            int count = 0;
            while (x < N && y < N){
                if (panel.get(y).charAt(x) == 'Q'){
                    count ++;
                }
                x++;
                y++;
            }
            if (count >= 2){
                return false;
            }
            x = i;
            y = 0;
            count = 0;
            while (x < N && y < N){
                if (panel.get(x).charAt(y) == 'Q'){
                    count ++;
                }
                x++;
                y++;
            }
            if (count >= 2){
                return false;
            }
            x = i;
            y = 0;
            count = 0;
            while (x >= 0 && y < N){
                if (panel.get(y).charAt(x) == 'Q'){
                    count++;
                }
                x--;
                y++;
            }
            if (count >= 2){
                return false;
            }
            x = i;
            y = N - 1;
            count = 0;
            while (x < N && y >= 0){
                if (panel.get(x).charAt(y) == 'Q'){
                    count++;
                }
                x++;
                y--;
            }
            if (count >= 2){
                return false;
            }
        }
        return true;
    }
}