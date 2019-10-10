import java.util.ArrayList;
import java.util.List;

public class LeetCode0017{
    public static final char[][] digLetter = {{' '},{' '},{'a','b','c'},{'d','e','f'},{'g','h','i'},
                          {'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    // 回溯法
    // 自底向上构造部分解，然后将当前解分配到已形成的部分解中
    public List<String> letterCombinations(String digits) {
        List<String> ls = new ArrayList<>();
        if (digits != null && digits.length() > 0){
            char c = digits.charAt(0);
            List<String> lt = letterCombinations(digits.substring(1));
            for (int i = 0;i < digLetter[c-'0'].length;i++){
                String s = String.valueOf(digLetter[c-'0'][i]);
                if (lt != null && lt.size() > 0){
                    for (String slt : lt){
                        ls.add(s + slt);
                    }
                } else {
                    ls.add(s);
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        
    }
}