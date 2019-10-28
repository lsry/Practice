import java.util.ArrayList;
import java.util.List;

public class LeetCode0113{
    List<List<Integer>> result = new ArrayList<>();

    private int SUM;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        SUM = sum;
        List<Integer> temp = new ArrayList<>();
        helper(root, temp, 0);
        return result;
    }

    public void helper(TreeNode root,List<Integer> middle,int curSum) {
        if (root == null){
            return;
        }
        curSum += root.val;
        middle.add(root.val);
        if (root.left == null && root.right == null){
            if (curSum == SUM){
                result.add(new ArrayList<>(middle));
            }
        } 
        if (root.left != null){
            helper(root.left, middle, curSum);
        }  
        if (root.right != null){
            helper(root.right, middle, curSum);
        }
        middle.remove(middle.size()-1);
    }
}