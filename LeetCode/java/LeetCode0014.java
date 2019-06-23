public class LeetCode0014{
    /**
     * 遍历第一个字符串，然后遍历之后的字符串对应位置是否有相同的字符
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0){
            return "";
        }
        int i = 0;
        for (;i < strs[0].length();i++){
            char c = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1;j < strs.length;j++){
                if (i >= strs[j].length() || strs[j].charAt(i) != c){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                break;
            }
        }
        return strs[0].substring(0, i);
    }
    public static void main(String[] args) {
        LeetCode0014 l14 = new LeetCode0014();
        System.out.println(l14.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(l14.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}