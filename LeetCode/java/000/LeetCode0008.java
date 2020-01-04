public class LeetCode0008{

    public int myAtoi(String str) {
        // 消除空串情况
        if (str == null || str.length() <= 0){
            return 0;
        }
        char[] ichar = str.toCharArray();
        int index = 0;
        int len = ichar.length;
        // 跳过字符串前为空值
        while (index < len && ichar[index] == ' '){
            index++;
        }
        // 开头不是 + 、- 、0-9的字符
        if (index >= len || ichar[index] != '-' && ichar[index] != '+' && (ichar[index] < '0' || ichar[index] > '9')){
            return 0;
        }
        // 负数标志
        boolean isPos = false;
        if (index <len && ichar[index] == '-'){
            isPos = true;
        }
        // 跳过前面的正负号
        if (index < len && (ichar[index] == '-' || ichar[index] == '+')){
            index++;
        }
        // 数字的计算过程，只计算只包括 0-9 的部分当字符串末尾或者遇到非0-9结束
        int num = 0;   // num 只可能为正值
        while (index < len && ichar[index] >= '0' && ichar[index] <= '9'){
            if (num * 10 / 10 != num){ // 判断是否越界
                return isPos ? -2147483648 : 2147483647;
            }
            num = num * 10 + (ichar[index] - '0');
            // 上面这步计算后仍可能越界
            if (num < 0){
                return isPos ? -2147483648 : 2147483647;
            } else {               
                index++;
            }
        }
        return isPos ? -num : num;
    }
    public static void main(String[] args) {
        LeetCode0008 l8 = new LeetCode0008();
        System.out.println(l8.myAtoi("42"));
        System.out.println(l8.myAtoi("   42"));
        System.out.println(l8.myAtoi("-42"));
        System.out.println(l8.myAtoi("4193 with words"));
        System.out.println(l8.myAtoi("words and 987"));
        System.out.println(l8.myAtoi("-91283472332"));
        System.out.println(l8.myAtoi("+-98"));
        System.out.println(l8.myAtoi("+") == 0);
        System.out.println(l8.myAtoi("2147483648") == 2147483647);
    }
}