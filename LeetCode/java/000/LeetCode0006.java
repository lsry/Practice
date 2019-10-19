public class LeetCode0006{
    /**
     * 创建相应行数的表保存对应行的字符，然后将序列按行连接在一起即可
     */
    public String convertAccumAction(String s, int numRows) {
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

    /**
     * 考虑按行存取字符，每一行对应字符序列中的索引如下:
     * gap = 2 * n - 2
     * 0： 0, gap - 2 * 0, 2 * gap, ... , k * gap  
     * 1:  1, 1 + gap - 2 * 1, 1 + gap, ... , 1 + k * gap - 2 * 1, 1 + k * gap 
     * ...
     * m:  m, m + gap - 2 * m, m + gap, ... , m + k * gap - 2 * m, m + k * gap
     * ...
     * n - 1: n - 1, n - 1 + gap, ... , n - 1 + k * gap
     */
    public String convert(String s, int numRows){
        if (s == null || s.length() <= numRows || numRows <= 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int gap = 2 * numRows - 2;
        for (int i = 0;i < numRows;i++){
            if (i == 0 || i == numRows - 1){
                for (int j = i;j < s.length();j += gap){
                    sb.append(s.charAt(j));
                }
            } else {
                int one = 2 * numRows - 2 * (i + 1);
                int another = gap - one;
                for (int j = i;j < s.length();){
                    sb.append(s.charAt(j));
                    j += one;
                    if (j < s.length()){
                        sb.append(s.charAt(j));
                        j += another;
                    } else {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0006 l6 = new LeetCode0006();
        System.out.println(l6.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(l6.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    }
}