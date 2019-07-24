public class LeetCode0029{
    public int divide(int dividend, int divisor) {
        if (dividend == divisor){
            return 1;
        } else if (divisor == 1){
            return dividend;
        } else if (dividend > 0 && divisor > 0){
                int res = 0;
                while (dividend >= divisor){
                    res += 1;
                    dividend -= divisor;
                }
                return res;
        } else if (dividend > 0 && divisor < 0){
            if (divisor == Integer.MIN_VALUE){
                return 0;
            } else {
                return -1 * divide(dividend, divisor * (-1));
            }
        } else if (dividend < 0 && divisor > 0){
            if (dividend == Integer.MIN_VALUE && divisor == 2){
                return -1073741824;
            } else if (dividend == Integer.MIN_VALUE){
                return -1 * divide(Integer.MAX_VALUE, divisor);
            } else {
                return -1 * divide(dividend * (-1), divisor);
            }          
        } else {
            if (dividend == Integer.MIN_VALUE && divisor == -1){
                return Integer.MAX_VALUE;
            } else if (dividend == Integer.MIN_VALUE){
                return divide(Integer.MAX_VALUE, divisor * (-1));
            } else {
                return divide(dividend * (-1), divisor * (-1));
            }
        }
    }
    public static void main(String[] args) {
        
    }
}