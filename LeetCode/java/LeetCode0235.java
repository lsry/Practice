public class LeetCode0235{
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        } else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor1(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor1(root.left, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null){
            if (node.val < p.val && node.val < q.val){
                node = node.right;
            } else if (node.val > p.val && node.val > q.val){
                node = node.left;
            } else {
                break;
            }
        }
        return node;
    }
}