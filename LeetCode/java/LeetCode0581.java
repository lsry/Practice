import java.util.Arrays;

public class LeetCode0581{
    /**
     * 1. 确定左边和右边的范围，保证两边均有序
     * 2. 获得中间无序数组的最大和最小值
     * 3. 向两边扩展，直到 num.left <= num.middle <= num.right
     */
    public int findUnsortedSubarrayExtend(int[] nums) {
        if (nums == null || nums.length <= 1){
            return 0;
        }
        int left = 0,right = nums.length - 1;
        for (;left < nums.length - 1;left++){
            if (nums[left] >= nums[left+1]){
                break;
            }
        }
        for (;right > 0;right --){
            if (nums[right] <= nums[right-1]){
                break;
            }
        }
        if (right < left){
            return 0;
        }
        int[] arr = maxMin(nums, left, right);
        for (left = 0;left < nums.length;left++){
            if (nums[left] > arr[0]){
                break;
            }
        }
        for (right = nums.length-1;right >= 0;right--){
            if (nums[right] < arr[1]){
                break;
            }
        }
        return right - left + 1;
    }

    public int[] maxMin(int[] nums,int head,int last) {
        int[] ix = new int[]{nums[head],nums[last]};
        for (int i = head;i <= last;i++){
            if (nums[i] < ix[0]){
                ix[0] = nums[i];
            }
            if (nums[i] > ix[1]){
                ix[1] = nums[i];
            }
        }
        return ix;
    }

    /**
     * 运用排序，然后比较不同的个数
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] numCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numCopy);
        int left = 0, right = numCopy.length - 1;
        for (;left < numCopy.length;left++){
            if (numCopy[left] != nums[left]){
                break;
            }
        }
        for (;right >= 0;right--){
            if (numCopy[right] != nums[right]){
                break;
            }
        }
        return (left < right) ? (right - left + 1) : 0;
    }
}