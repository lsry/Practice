import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode0015 {
    public List<List<Integer>> threeSum(int[] nums) { 
        // 1. sorted first       
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i < size - 2 && nums[i] <= 0;i++){             
            int twoSum = 0 - nums[i];
            int j = i + 1;
            int k = size - 1;
            // 双指针遍历，计算两个指针对应位置和
            while (j < k){
                if (nums[j] + nums[k] == twoSum){
                    List<Integer> ai = new ArrayList<>();
                    ai = Arrays.asList(nums[i], nums[j], nums[k]);
                    if (!result.contains(ai)){  // 判断是否含重复元组
                        result.add(ai);
                    }
                } else if (nums[j] + nums[k] < twoSum){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        
    }
}