import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode0030{
    /**
     * 用 HashMap 记录下子串出现的频率，然后逐字符遍历整个字符串，找到相应字串的序列
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length <= 0 || s == null || s.length() <= 0
           || s.length() < words.length * words[0].length()){
            return result;
        } else if (words.length == 1 && s.equals(words[0])){  // 当数组中只有一个元素且等于整个字符串时
            result.add(0);
            return result;
        }
        Map<String,Integer> map = new HashMap<>();
        for (String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        int wordLen = words[0].length();
        // 每次比较 s 中子串 [i, i + words.length * wordLen) 是否和目标数组匹配
        for (int i = 0;i + words.length * wordLen < s.length();i++){
            Map<String,Integer> temp = new HashMap<>();
            int j = 0;
            for (;i + j * wordLen < s.length() && j < words.length;j++){
                int from = i + j * wordLen;        // 每次取 wordLen 长度的子串
                int to = from + wordLen;
                if (to > s.length()){
                    to = s.length();
                }
                String sub = s.substring(from,to);
                if (!map.containsKey(sub)){   // 该子串并不是目标数组中的
                    break;
                }
                temp.put(sub, temp.getOrDefault(sub, 0) + 1);
                if (temp.get(sub) > map.get(sub)){    // 该子串出现次数大于目标数组中出现的次数
                    break;
                }
            }
            if (j == words.length){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        
    }
}