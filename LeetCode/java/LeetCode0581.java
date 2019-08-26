public class LeetCode0581{
    public int findUnsortedSubarray(int[] nums) {
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
}