public class LeetCode0814{
    public TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return root;
        }
        if (root.val == 0){
            if (!(containOne(root.left) || containOne(root.right))){
                root = null;
            }
        } 
        if (root != null){
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        }
        return root;       
    }

    public boolean containOne(TreeNode root){
        if (root != null){
            return root.val == 1 || containOne(root.left) || containOne(root.right);
        }
        return false;
    }
}