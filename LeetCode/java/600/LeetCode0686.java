public class LeetCode0686{
    public int repeatedStringMatch(String A, String B) {
        int index = -1;
        StringBuilder sb = new StringBuilder(A);
        // 优化点：比较的最大长度 A'[AA....AA]A'
        int len = 2 * A.length() + B.length();
        int i = 1;
        while (sb.length() <= len){
            if (sb.lastIndexOf(B) != -1){ // indeOf -> lastIndexOf 效率大大提升 198ms to 3ms
                index = i;
                break;
            } else {
                i++;
                sb.append(A);
            }
        }
        return index;
    }
}