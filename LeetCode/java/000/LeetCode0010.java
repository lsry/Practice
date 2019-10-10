public class LeetCode0010{
    public boolean isMatch(String s, String p) {
        int slength = s.length(),plength = p.length();
        boolean match[][] = new boolean[slength+1][plength+1];
        match[slength][plength] = true;
        for (int si = slength;si >= 0;si--){
            for (int pj = plength - 1;pj >= 0;pj--){
                boolean first = si < slength && (p.charAt(pj) == '.' || p.charAt(pj) == s.charAt(si));
                if (pj+1 < p.length() && p.charAt(pj+1) == '*'){
                    match[si][pj] = first && match[si+1][pj] || match[si][pj+2];
                } else {
                    match[si][pj] = first && match[si+1][pj+1];
                }
            }
        }
        return match[0][0];
    }

    public static void main(String[] args) {
        LeetCode0010 l10 = new LeetCode0010();
        System.out.println("1: " + (l10.isMatch("aa", "a") == false));
        System.out.println("2: " + (l10.isMatch("aa", "a*") == true));
        System.out.println("3: " + (l10.isMatch("ab", ".*") == true));
        System.out.println("4: " + (l10.isMatch("aab", "c*a*b*") == true));
    }
}