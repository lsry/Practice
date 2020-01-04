class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode0236{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        } else if (root == p){
            return find(p, q)? p : null;
        } else if (root == q){
            return find(q, p) ? q : null;
        }
        TreeNode node = lowestCommonAncestor(root.left, p, q);
        if (node != null){
            return node;
        }
        node = lowestCommonAncestor(root.right, p, q);
        if (node != null){
            return node;
        }
        if (find(root.left, p) && find(root.right, q) || find(root.left, q) && find(root.right, p)){
            return root;
        } else {
            return null;
        }
    }

    public boolean find(TreeNode root, TreeNode n){
        TreeNode x = root;
        if (x == null){
            return false;
        } else if (x == n) {
            return true;
        } else {
            return find(x.left, n) || find(x.right, n);
        }
    }
}