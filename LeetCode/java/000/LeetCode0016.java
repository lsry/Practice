import java.util.Arrays;

public class LeetCode0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int cloest = nums[0] + nums[1] + nums[2];
        for (int i = 0;i < size - 2;i++){             
            int twoSum = target - nums[i];
            int j = i + 1;
            int k = size - 1;
            boolean flag = false;
            while (j < k){
                if (nums[j] + nums[k] == twoSum){
                    cloest = target;
                    flag = true;
                    break;
                } else if (nums[j] + nums[k] < twoSum){
                    if ((twoSum - nums[j] - nums[k]) < Math.abs(target - cloest)){
                        cloest = nums[i] + nums[j] + nums[k];
                    }
                    j++;
                } else {
                    if ((nums[j] + nums[k] - twoSum) < Math.abs(target - cloest)){
                        cloest = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                }
            }
            if (flag){
                break;
            }
        }
        return cloest;
    }

    public static void main(String[] args) {
        
    }
}