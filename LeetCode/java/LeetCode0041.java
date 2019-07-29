public class LeetCode0041{
    /**
     * (1) 可以先排序，然后寻找；
     * (2) 寻找最大值max，然后构造一个数组A[1,...max],如果存在 i，则令 A[i] = 1；寻找最小的那个不存在的数；
     * (3) 构造一个长度为输入数组长度 N 的数组，忽略大于 N 的数，因为如果存在大于 N 的数，则前面[1,...,N]中必然存在空；
     * (4) 利用原来的数组；
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 1;
        }
        for (int i = 0;i < nums.length;i++){
            if (nums[i] < 1 || nums[i] > nums.length){
                nums[i] = 0;
            }
            else {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
                if (nums[i] == temp && nums[i] - 1 != i){
                    nums[i] = 0;
                }
                if (nums[i] != 0 && nums[i] - 1 != i){
                    i--;
                }
            }
        }
        int res = 1;
        int i = 0;
        for (;i < nums.length;i++){
            if (nums[i] == 0){
                res = i + 1;
                break;
            }
        }
        if (i == nums.length){
            res = nums.length + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        LeetCode0041 l41 = new LeetCode0041();       
        System.out.println(1 == l41.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(3 == l41.firstMissingPositive(new int[]{2,1,0}));
        System.out.println(2 == l41.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(2 == l41.firstMissingPositive(new int[]{1,1}));
    }
}