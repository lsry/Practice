public class LeetCode0337{
    
    public int rob(TreeNode root) {
        return Math.max(treeSum2(root, true),treeSum2(root, false));
    }

    /**
     * Runtime: 1084 ms, faster than 5.01% 
     */
    private int treeSum2(TreeNode root,boolean selected) {
        if (root == null) {
            return 0;
        } else if (selected) {
            return root.val + treeSum2(root.left, !selected) + treeSum2(root.right, !selected);
        } else {
            return rob(root.left) + rob(root.right);
        } 
    }

    /**
     * 940ms 5.01% 
     */
    public int treeSum(TreeNode root,boolean selected) {
        if (root == null) {
            return 0;
        } else if (selected) {
            return root.val + treeSum(root.left, !selected) + treeSum(root.right, !selected);
        } else {
            int lefts = treeSum(root.left, true);
            int leftn = treeSum(root.left, false);
            int rights = treeSum(root.right, true);
            int rightn = treeSum(root.right, false);
            return Math.max(lefts, leftn) + Math.max(rights, rightn);
        } 
    }
}