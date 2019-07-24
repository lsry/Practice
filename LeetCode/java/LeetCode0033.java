public class LeetCode0033{
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
            } else if (target < nums[middle] && nums[left] > target){
                left = middle + 1;
            } else {
                
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LeetCode0033 l33 = new LeetCode0033();
        System.out.println("test 4 = " + l33.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}