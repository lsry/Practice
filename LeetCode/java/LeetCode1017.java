public class LeetCode1017{
    // 关键在于保证余数为{0,1}
    public String baseNeg2(int N) {
        if (N == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (N != 0){
            if ((N % (-2)) == 0){
                sb.append('0');
                N = N / (-2);
            } else {
                sb.append('1');
                /*
                 * N = N' * (-2) + 1
                 * N' = (N - 1) / (-2) 
                 */
                N = (N - 1) / (-2);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(11 % (-2));
        System.out.println(11 / (-2));
    }
}