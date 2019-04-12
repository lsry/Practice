import java.util.HashMap;

/**
 * LeetCode 0001
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */

public class TwoSum{
    /**
     * 以哈希表做基础，将第一个元素存入哈希表，
     * 从数组第二个开始遍历，查找需要的差值是否在表中，在，则返回对应索引，否则将当前数字存入表中。
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> ins = new HashMap<>();
        ins.put(nums[0], 0);
        for (int i = 1;i < nums.length;i++){
            int other = target - nums[i];
            if (ins.containsKey(other)){
                return new int[]{ins.get(other),i};
            } else {
                ins.put(nums[i], i);
            }
        } 
        return new int[]{};
    }
}