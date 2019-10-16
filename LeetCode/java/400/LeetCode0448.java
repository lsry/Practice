import java.util.ArrayList;
import java.util.List;

public class LeetCode0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0;i < nums.length;i++){
            int x = nums[i];
            while (x != 0 && x != -1){
                nums[i] = -1;
                int t = x;
                x = nums[t - 1];
                nums[t - 1] = 0;
            }           
        }
        List<Integer> li = new ArrayList<>();
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == -1){
                li.add(i + 1);
            }
        }
        return li;
    }

    public static void main(String[] args) {
        
    }
}