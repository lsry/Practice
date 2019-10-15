import java.util.List;

public class LeetCode0756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom == null || bottom.length() <= 1){
            return true;
        } else if (allowed.isEmpty()){
            return false;
        }
        return helper(bottom, allowed, 1, new StringBuilder());
    }

    public boolean helper(String bottom,List<String> allowed,int next,StringBuilder upper){
        if (bottom.length() <= 1){
            return true;
        } else if (next == bottom.length()){
            return helper(upper.toString(), allowed, 1, new StringBuilder());
        } 
        String target = "" + bottom.charAt(next - 1) + bottom.charAt(next);
        boolean suit = false;
        for (String allow : allowed){
            String two = allow.substring(0,2);
            if (two.equals(target)){
                upper.append(allow.charAt(2));
                suit = helper(bottom, allowed, next+1, upper);
                if (suit){
                    return true;
                } else {
                    upper.deleteCharAt(upper.length() - 1);
                }
            }
        }
        return suit;
    }
}