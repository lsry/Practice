public class LeetCode0700{
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null){
            if (cur.val == val){
                return cur;
            } else if (cur.val > val){
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }
}