import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LeetCode0753{ 
    public String crackSafe(int n, int k) {
        Set<String> permut = new LinkedHashSet<>();
        StringBuilder res = new StringBuilder();
        int nums = (int)Math.pow(k, n);
        for(int i = 0;i < n;i++){
            res.append('0');
        }
        for (int i = 0;i < nums;i++){
            String cur = res.substring(res.length()- n + 1, res.length());
            for (int j = k - 1;j >= 0;j--){
                String key = cur + j;
                if (!permut.contains(key)){
                    res.append(j);
                    permut.add(key);
                    break;
                }
            }
        }
        return res.substring(1);     
    }

    public static void main(String[] args) {
        Set<Integer> si = new LinkedHashSet<>();
        Set<Integer> sx = new HashSet<>();
        for (int i = 0;i < 10;i++){
            si.add(i);
            sx.add(i);
        }
        for (Integer i : si){
            System.out.println("si: " + i);
            System.out.println("sx: " + i);
        }
    }
}