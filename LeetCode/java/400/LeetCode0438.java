import java.util.ArrayList;
import java.util.List;

/**
 * 双指针
 * 1. 记录 p 中字符出现的次数
 * 2. 统计 s[left,right] 中字符数，和 p 相比较是否一致
 */
public class LeetCode0438 {
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> li = new ArrayList<>();
        int sl = s.length(), pl = p.length();
        if (s == null || sl < pl){
            return li;
        }        
        int[] pr = new int[26];
        int[] tr = new int[26];
        for (int i = 0;i < pl;i++) {
            pr[p.charAt(i) - 97] += 1;
        }
        for (int i = 0,j = 0;j < sl;){
            if (pr[s.charAt(j) - 97] == 0){
                tr = new int[26];
                j++;
                i = j;
            } else {
                tr[s.charAt(j) - 97] += 1;
                if (j - i + 1 > pl){
                    tr[s.charAt(i) - 97] -= 1;
                    i++;
                }
                if (j - i + 1 == pl && tr[s.charAt(j) - 97] == pr[s.charAt(j) - 97] && isEqual(pr, tr)){
                    li.add(i);
                }
                j++;
            }          
        }

        return li;
    }

    public boolean isEqual(int[] pr,int[] tr){
        for (int i = 0;i < pr.length;i++){
            if (pr[i] != tr[i]){
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> li = new ArrayList<>();
        int sl = s.length(), pl = p.length();
        if (s == null || sl < pl){
            return li;
        }        
        int[] pr = new int[26];
        int[] tr = new int[26];
        for (int i = 0;i < pl;i++) {
            pr[p.charAt(i) - 97] += 1;
        }
        int left = 0, right = 0;
        for (;right < pl;right++){
            tr[s.charAt(right) - 97] += 1;
        }
        if (isEqual(pr, tr)){
            li.add(0);
        }
        for (;right < sl;right++){
            tr[s.charAt(right) - 97] += 1;
            tr[s.charAt(left) - 97] -= 1;
            left++;
            if (isEqual(pr, tr)){
                li.add(left);
            }
        }
        return li;
    }
    public static void main(String[] args) {
        System.err.println("abc".substring(0, 6));
    }
}