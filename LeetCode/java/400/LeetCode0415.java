public class LeetCode0415{
    public String addStrings(String num1, String num2) {
        String min, max;
        if (num1.length() < num2.length()) {
            min = num1;
            max = num2;
        } else {
            min = num2;
            max = num1;
        }
        int minLen = min.length();
        int maxLen = max.length();
        StringBuilder sBuilder = new StringBuilder();
        int C = 0;
        for (int i = min.length() - 1;i >= 0;i--) {
            int digitSum = min.charAt(i) + max.charAt(i + maxLen - minLen) - 2 * '0' + C;
            int mod = digitSum % 10;
            C = digitSum / 10;
            sBuilder.append(mod);
        }
        for (int i = maxLen - minLen - 1;i >= 0;i--) {
            int digitSum = max.charAt(i) - '0' + C;
            C = digitSum / 10;
            int mod = digitSum % 10;
            sBuilder.append(mod);
        }
        if (C > 0) {
            sBuilder.append(C);
        }
        return sBuilder.reverse().toString();
    }
}