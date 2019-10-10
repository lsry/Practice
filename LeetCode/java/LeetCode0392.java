public class LeetCode0392{
    public boolean isSubsequence(String s, String t) {
        int sl = 0, tl = 0;
        while(sl < s.length() && tl < t.length()){
            if (t.charAt(tl) == s.charAt(sl)){
                sl++;
            }
            tl++;
        }
        return sl >= s.length();
    }
}