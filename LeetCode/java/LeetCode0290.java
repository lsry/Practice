import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LeetCode0290{
    public boolean wordPattern(String pattern, String str) {
        int index = 1;
        int[] alpha = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char ch : pattern.toCharArray()){
            if (alpha[ch - 'a'] == 0){
                alpha[ch - 'a'] = index;
                index++;
            }
            sb.append(alpha[ch - 'a']);
        }
        String pa = sb.toString();

        String[] words = str.split(" ");
        sb = new StringBuilder();
        index = 1;
        Map<String,Integer> ms = new HashMap<>();
        for (String word : words){
            if (!ms.containsKey(word)){
                ms.put(word, index);
                index++;
            }
            sb.append(ms.get(word));
        }
        String strp = sb.toString();
        
        return Objects.equals(pa, strp);
        
    }
}