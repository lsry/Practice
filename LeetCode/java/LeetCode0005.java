public class LeetCode0005{
    /**
     * 动态规划求最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0){
            return "";
        }
        // 以下至少保证含有一个字符
        int length = s.length();
        // 构建一个二维数组，b[i][j] == true 代表 S[i,...,j] 是回文串, 否则不是
        // boolean 数组默认值为 false
        boolean[][] arr = new boolean[length][length];
        for (int i = 0;i < length;i++){
            arr[i][i] = true;
            if (i + 1 < length && s.charAt(i) == s.charAt(i+1)){
                arr[i][i+1] = true;
            }
        }
        // 从第一个字符开始
        String maxStr = s.substring(0,1);
        // maxStr = maxLength{S[i,j],maxStr} , 0 <= i < S.length - 1
        for (int i = 0;i < length - 1;i++){
            // 以回文串含有奇数、偶数个字符两种情况
            int[] s1 = getMax(arr,i,i,s);
            int[] s2 = getMax(arr,i,i+1,s);
            int len1 = s1[1] - s1[0] + 1;
            int len2 = s2[1] - s2[0] + 1;
            if (len1 > len2 && len1 > maxStr.length()){
                maxStr = s.substring(s1[0],s1[1] + 1);
            } else if (len2 >= len1 && len2 > maxStr.length())
            {
                maxStr = s.substring(s2[0],s2[1] + 1);
            }
        }
        return maxStr;
    }

    /**
     * 返回回文串的首，尾字符索引
     * @param left,right 回文串中心字符索引
     * @param s 目标串
     * @return [0] 首索引，[1] 尾索引
     */
    public int[] getMax(boolean[][] brr,int left,int right,String s){
        int l = left;
        int r = right;
        // 以当前字符为中心逐步向外扩展
        while (l >= 0 && r < s.length()){
            if (brr[l][r]){
                l--;
                r++;
            } else {
                // b[l][r] == false 存在两种情况，
                // 1. 不是回文串，2. 还没有判定过
                if (s.charAt(l) == s.charAt(r)){
                    brr[l][r] = true;
                    l--;
                    r++;                    
                } else {
                    break;
                }
            }
        }
        // 上述循环结束可能 l , r 碰到边界值或者 S[l,...,r] 不是回文串
        if (l >= 0 && r < s.length() && brr[l][r]){
            return new int[]{l,r};
        }
        return new int[]{++l,--r};
    }

    public static void main(String[] args) {
        LeetCode0005 l5 = new LeetCode0005();
        System.out.println(l5.longestPalindrome("abcde"));
        System.out.println(l5.longestPalindrome("abbc"));
        System.out.println(l5.longestPalindrome("abcba"));
        System.out.println(l5.longestPalindrome("abcbc"));
        System.out.println(l5.longestPalindrome("a"));
    }
}