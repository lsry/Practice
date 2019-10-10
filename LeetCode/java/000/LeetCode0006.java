public class LeetCode0006{
    /**
     * 创建相应行数的表保存对应行的字符，然后将序列按行连接在一起即可
     */
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows <= 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0;i < numRows;i++){
            sbs[i] = new StringBuilder();
        }
        int len = s.length();
        for (int i = 0;i < len;){
            // 保存从上到下的字符 0 -- numRow-1
            for (int j = 0;j < numRows && i < len;j++){
                sbs[j].append(s.charAt(i));
                i++;
            }
            // 保存从下到上的字符 numRow-2 -- 1
            for (int k = numRows - 2;k > 0 && i < len;k--){
                sbs[k].append(s.charAt(i));
                i++;
            }
        }
        for (int i = numRows - 1;i > 0;i--){
            sbs[i - 1].append(sbs[i].toString());
        }
        return sbs[0].toString();
    }

    public static void main(String[] args) {
        LeetCode0006 l6 = new LeetCode0006();
        System.out.println(l6.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(l6.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    }
}