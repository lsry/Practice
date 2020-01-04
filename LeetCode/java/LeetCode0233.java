public class LeetCode0233{
    /**
     * 1. 只承受得住千万级别
     */
    public int countDigitOne1(int n) {
        int count = 0;
        for (int i = 1;i <= n;i++){
            count += ones(i);
        }
        return count;
    }

    public int ones(int n){
        String num = String.valueOf(n);
        int count = 0;
        for (int i = 0;i < num.length();i++){
            if (num.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }

    public int countDigitOne(int n) {
        return 0;
    }
}