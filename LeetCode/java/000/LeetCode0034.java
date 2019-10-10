public class LeetCode0034{
    /**
     * 首先用二分查找找到对应值的位置，然后向两边扩展即可
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int left = 0;
        int right = nums.length;
        int mid = 0;
        while (left < right){
            mid = left + (right - left) / 2;
            if (target == nums[mid]){
                break;
            } else if (target > nums[mid]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left < right){
            res[0] = mid;
            res[1] = mid;
            while (res[0] - 1 >= 0 && nums[res[0] - 1] == target){
                res[0]--;
            }
            while (res[1] + 1 < nums.length && nums[res[1]+ 1] == target){
                res[1]++;
            }
        }
        return res;
    }
}