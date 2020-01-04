public class LeetCode0437{
    public int pathSum(TreeNode root, int sum) {
        return pathSumHelper(root, sum, sum) + (
         (root == null) ? 0 : pathSum(root.left, sum) + pathSum(root.right, sum));
    }

    public int pathSumHelper(TreeNode root,int curValue,int sum){
        if (root == null){
            return 0;
        }
        int num = 0;
        if (root.val == curValue){
            num += 1 + pathSumHelper(root.left, curValue - root.val,sum) 
            + pathSumHelper(root.right, curValue - root.val,sum);
        } else {
            num += pathSumHelper(root.left, curValue - root.val,sum) 
            + pathSumHelper(root.right, curValue - root.val,sum) ;
        }
        return num;
    }
}