public class LeetCode0486{
    
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length <= 2 || nums.length % 2 == 0){
            return true;
        }
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        int[][] arr = new int[nums.length + 1][nums.length + 1];
        for (int i = 0;i < nums.length;i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            for (int j = 0;j < nums.length;j++){
                if (i == j){
                    arr[i + 1][j + 1] = nums[i];
                } else {
                    arr[i + 1][j + 1] = -1;
                }
            }
        }
        getPriorMaxScore(nums, 1, nums.length, arr, prefixSum);
        return arr[1][nums.length] * 2 >= prefixSum[nums.length];
    }

    /**
     * 获得先手最大分数 = 获得端点的数字 与 剩余选择的后手最大分数
     */
    public int getPriorMaxScore(int[] nums,int left,int right,int[][] arr,int[] preSum){
        if (left < 1 || left > right || right > nums.length){
            return 0;
        } if (arr[left][right] != -1){
            return arr[left][right];
        }
        arr[left][right] = Math.max(
            nums[left - 1] + (preSum[right] - preSum[left]) - getPriorMaxScore(nums,left + 1,right,arr,preSum)
            , 
            nums[right - 1] + (preSum[right - 1] - preSum[left - 1]) - getPriorMaxScore(nums,left,right - 1,arr,preSum)
            );
        return arr[left][right];
    }
}