public class LeetCode0650 {
    public int minSteps5ms(int n) {
        if (n == 1) {
            return 0;
        }
        return helper5ms(1, n - 1, 0) + 1;
    }

    public int helper5ms(int cur,int remainder,int lastCopy) {
        if (remainder == 0) {
            return 0;
        } else if (lastCopy > remainder) {
            return -1;
        } else if (lastCopy == 0) {
            return helper5ms(cur, remainder, cur);
        }
        int step1 = Integer.MAX_VALUE;
        if (lastCopy != cur) {
            int x = helper5ms(cur, remainder, cur);
            if (x != -1 && x != Integer.MAX_VALUE) {
                step1 = x + 1;
            }
        }
        int step2 = Integer.MAX_VALUE;
        int y = helper5ms(cur + lastCopy, remainder- lastCopy, lastCopy);
        if (y != -1 && y != Integer.MAX_VALUE) {
            step2 = 1 + y;
        }
        return Math.min(step1, step2);
    }
}