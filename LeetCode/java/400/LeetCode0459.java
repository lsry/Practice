public class LeetCode0459{
    public boolean repeatedSubstringPatternDoubleIter(String s) {
        String sub = "";
        for (int i = 1;2 * i <= s.length();i++){
            sub = s.substring(0, i);
            int j = i;
            while (j + i <= s.length()){
                if (!sub.equals(s.substring(j, j + i))){
                    break;
                }
                j += i;
            }
            if (j >= s.length()){
                return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern(String s) {
        
    }
}