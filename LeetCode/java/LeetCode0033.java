public class LeetCode0033{
    /**
     * 分类讨论四种情况：（1）- （3） 左边值 >= 右边值 
     * （1） 中间值恰好为最大最小值，两边单调递增
     * （2） 中间值较小，左边先增加后减少，右边递增
     * （3） 中间值较大，左边递增，右边先增加到最大值，后从最小值递增
     * （4） 恰好有序递增序列
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int left = 0;
        int right = nums.length;
        int middle = 0;
        while (left < right){
            middle = left + (right - left) / 2;
            if (nums[middle] == target){
                return middle;
            } 
            if (nums[left] > nums[middle]){
                if (target > nums[middle] && target <= nums[right - 1]){
                    left = middle + 1;
                } else {
                    right = middle;
                }
            } else {
                if ((target < nums[middle] && nums[right - 1] < nums[left] && target <= nums[right - 1]) 
                || target > nums[middle]){
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LeetCode0033 l33 = new LeetCode0033();
        System.out.println(4 == l33.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(-1 == l33.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(3 == l33.search(new int[]{7,8,1,2,3,4,5,6}, 2));
        System.out.println(2 == l33.search(new int[]{5,1,3}, 3));
    }
}