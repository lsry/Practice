public class LeetCode0172{
    // TLE
    public int trailingZeroesTLE(int n) {
        int num = 0;
        for (int i = 5;i <= n && i + 5 > 0;i += 5){
           int five = 0;
           for (int j = i;j % 5 == 0;j = j / 5){
               five++;
           }
           num += five;
        }
        return num;
    }

    public int trailingZeroes(int n) {
        int num = 0;
        while (n >= 5){
            n /= 5;
            num += n;
        }
        return num;
    }
}