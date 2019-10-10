public class LeetCode0075{
    public void sortColors(int[] nums) {        
        int prev = -1;
        int last = nums.length;
        for (int i = 0;i < last && prev < last;){
            if (nums[i] == 0){
                prev++;
                int temp = nums[i];
                nums[i] = nums[prev];
                nums[prev] = temp;
                i++;
            } else if (nums[i] == 2){
                last--;
                int temp = nums[i];
                nums[i] = nums[last];
                nums[last] = temp;
            } else {
                i++;
            }
        }
    }

    public void printArray(int[] arr){
        for (int a : arr){
            System.out.print(a + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeetCode0075 l75 = new LeetCode0075();
        int nums[] = new int[]{1,2,2,0,1,2,0,1};
        l75.sortColors(nums);
        l75.printArray(nums);
        int nums1[] = new int[]{0};
        l75.sortColors(nums1);
        l75.printArray(nums1);
        int nums2[] = new int[]{0,0};
        l75.sortColors(nums2);
        l75.printArray(nums2);
        int nums3[] = new int[]{1,1,1};
        l75.sortColors(nums3);
        l75.printArray(nums3);
        int nums4[] = new int[]{2,2,2,2};
        l75.sortColors(nums4);
        l75.printArray(nums4);
        int nums5[] = new int[]{2,0,2,1,1,0};
        l75.sortColors(nums5);
        l75.printArray(nums5);
        int nums6[] = new int[]{0,1};
        l75.sortColors(nums6);
        l75.printArray(nums6);
    }
}