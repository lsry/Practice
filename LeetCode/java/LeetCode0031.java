public class LeetCode0031{
    /**
     * 1. 从右到左寻找一个位置 i, 使得 a[i-1] < a[i] , 可以得到 a[i] ... a[n] 是递减序列
     * 2. 从 i 开始向右寻找一个位置 j，使得 a[j] = min{a[i], ... , a[n]} 且 a[j] > a[i] , 然后交换 a[i-1] ，a[j]   
     * 3. 逆序 a[i] ... a[n]  
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }
        int i = nums.length - 1;
        for (;i >= 1;i--){
            if (nums[i] > nums[i-1]){
                break;
            }
        }
        
        if (i != 0){
            int x = i;
            // 由于 a[i] ... a[n] 是递减序列，所以可得到若从 i,..., n 遍历，若a[j] > a[i-1] 是最小的那个，
            // 则a[j+1,...,n] 中不会存在大于 a[i-1]的值
            // 也可以从 n,...i开始遍历，寻找第一个大于 a[i-1] 的位置 j 
            for (int j = i;j < nums.length;j++){
                if (nums[j] > nums[i - 1]){
                    x = j;
                }
            }
            swap(nums, i-1, x);
        }
        
        reverseArr(nums, i, nums.length - 1);
    }

    public void reverseArr(int[] nums,int first,int last){
        while (first < last){
            swap(nums, first, last);
            first++;
            last--;
        }
    }

    public void swap(int[] nums,int one,int another){
        int temp = nums[one];
        nums[one] = nums[another];
        nums[another] = temp;
    }

    public void printArray(int[] nums){
        for (int n : nums){
            System.out.print(n + "\t");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        LeetCode0031 l31 = new LeetCode0031();
        for (int i = 0;i < 24;i++){
            l31.nextPermutation(nums);
            l31.printArray(nums);
        }
    }
}