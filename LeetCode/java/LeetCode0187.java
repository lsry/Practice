import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 11) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        HashMap<String,Integer> msi = new HashMap<>();
        for (int i = 0;i <= s.length() - 10;i++) {
            String st = s.substring(i, i + 10);
            msi.put(st, msi.getOrDefault(st, 0) + 1);
        }
        for (Map.Entry<String,Integer> entry : msi.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}