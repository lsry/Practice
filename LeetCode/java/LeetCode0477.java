public class LeetCode0477{
    public int totalHammingDistance(int[] nums) {
        String[] bins = new String[nums.length];
        for (int i = 0;i < nums.length;i++){
            bins[i] = new StringBuilder(Integer.toBinaryString(nums[i])).reverse().toString();
        }
        int distance = 0;
        for (int i = 0;i < 32;i++){
            int ones = 0;
            for (int j = 0;j < nums.length;j++){
                if (i < bins[j].length() && bins[j].charAt(i) == '1'){
                    ones++;
                }
            }
            distance += ones * (nums.length - ones);
        }
        return distance;
        
    }

    public static void main(String[] args) {
        for (int i = 10;i < 20;i++){
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println(Integer.toBinaryString((int)Math.pow(10, 9)));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE).length());
    }
}