import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode0022 {
    /**
     * 假设对于 n - 1 的结果 {S}，n 的结果为 () 插入到 n - 1 结果字符串的每一个间隔中，然后去重
     */
    public List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        if (n == 0){
            ls.add("");
        } else if (n == 1){
            ls.add("()");
        } else {
            HashSet<String> hs = new HashSet<>();
            List<String> ls2 = generateParenthesis(n-1);
            for (String s : ls2){
                for (int i = 0;i < s.length();i++){
                    String t = s.substring(0, i+1) + "()" + s.substring(i+1);
                    hs.add(t);
                }
            }
            ls = new ArrayList<>(hs);
        }
        return ls;
    }

    public static void main(String[] args) {
        
    }
}