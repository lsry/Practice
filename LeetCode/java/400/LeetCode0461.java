public class LeetCode0461{
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0;i < 32;i++){
            int x1 = x & (1 << i);
            int y1 = y & (1 << i);
            if ((x1 == 0 && y1 == 0) || (x1 != 0 && y1 != 0)){
                count++;
            }
        }
        return 32 - count;
    }

    public static void main(String[] args) {
        
    }
}