public class LeetCode0400 {
    public int findNthDigit(int n) {
        long N = n;
        long sum = 0;
        int i = 0;
        while (sum < N) {
            sum += 9 * ((long)Math.pow(10, i)) * (i + 1);
            i++;
        }
        if (sum == N) {
            return 9;
        }
        long distance = N + (9 * ((long)Math.pow(10, i - 1)) * i) - sum;
        long num = (long)Math.pow(10, i - 1) + distance / i - 1;
        long mod = distance % i;
        if (mod == 0) {
            return String.valueOf(num).charAt(i - 1) - '0';
        } else {
            return String.valueOf(num + 1).charAt((int)(mod - 1)) - '0';
        }
    }
}