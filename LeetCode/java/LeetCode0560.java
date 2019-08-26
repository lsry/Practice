import java.util.HashMap;

public class LeetCode0560{
    public int subarraySum1(int[] nums, int k) {
        int[] arr =new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1;i < nums.length;i++){
            arr[i] = arr[i-1] + nums[i];
        }

        int count = 0;
        for (int i = 0;i < arr.length;i++){
            for (int j = i;j < arr.length;j++){
                if (arr[j] - arr[i] + nums[i] == k){
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int[] arr =new int[nums.length + 1];
        arr[0] = 0;
        for (int i = 1;i < arr.length;i++){
            arr[i] = arr[i-1] + nums[i-1];
        }

        int count = 0;
        HashMap<Integer,Integer> hii = new HashMap<>();
        hii.put(arr[0], 1);
        for (int i = 1;i < arr.length;i++){
            int diff = arr[i] - k;
            if (hii.containsKey(diff)){
                count += hii.get(diff);
            } 
            if (hii.containsKey(arr[i])){
                hii.put(arr[i], hii.get(arr[i]) + 1);
            } else {
                hii.put(arr[i], 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        
    }
}