public class LeetCode0476{
    public int findComplement(int num) { 
        if (num == 0) {
            return 1;
        }
        int another = 0;       
        for (int i = 31;i >= 0 && num != 0;--i) {
            if ((num & 1) == 0) {
                another = (1 << (31 - i)) + another;
            } 
            num = num >>> 1;
        }
        return another;
    }
}