public class LeetCode0416{
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums){
            sum += n;
        }
        if (sum % 2 == 1){
            return false;
        }
        int half = sum >> 1;
        int[] arr = new int[half + 1];
        for (int i = 0;i < nums.length;i++){
            for (int j = half;j - nums[i] >= 0;j--){
                int curSum = nums[i] + arr[j - nums[i]];
                if (curSum == half){
                    return true;
                }
                if (curSum <= j){
                    arr[j] = curSum;
                }
            }
        }
        return false;
    }
}