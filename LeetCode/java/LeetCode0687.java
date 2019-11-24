/**
 * 从当前结点开始，有三条路径：
 * 1）沿着左子树向下
 * 2）沿着右子树向下
 * 3）由左子树经过当前结点到右子树
 * 三条路径取最大值
 */
public class LeetCode0687{
    private int maxPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        getPath(root, 0);
        return maxPath;
    }

    public int getPath(TreeNode root,int curPath){
        if (root == null || (root.left == null && root.right == null)){
            maxPath = Math.max(maxPath,curPath);
            return curPath;
        } else if (root.left != null && root.right != null){
            if (root.val == root.left.val && root.val == root.right.val){
                int leftPath = getPath(root.left, 0);
                int rightPath = getPath(root.right, 0);
                int path = curPath + 1 + Math.max(leftPath, rightPath);
                int circlePath = 2 + leftPath + rightPath;
                maxPath = Math.max(circlePath, maxPath);
                maxPath = Math.max(maxPath, path);
                return path;
            } else if (root.val == root.left.val){
                int path = curPath + 1 + getPath(root.left, 0);
                getPath(root.right, 0);
                maxPath = Math.max(maxPath, path);
                return path;
            } else if (root.val == root.right.val) {
                int path = curPath + 1 + getPath(root.right, 0);
                getPath(root.left, 0);
                maxPath = Math.max(maxPath, path);
                return path;
            } else  {
                getPath(root.left, 0);
                getPath(root.right, 0);
                return curPath;
            }
        } else if (root.left != null){
            if (root.val == root.left.val){
                int path = curPath + 1 + getPath(root.left, 0);
                maxPath = Math.max(maxPath, path);
                return path;
            } else {
                getPath(root.left, 0);
                return curPath;
            }
        } else {
            if (root.val == root.right.val){
                int path = curPath + 1 + getPath(root.right, 0);
                maxPath = Math.max(maxPath, path);
                return path;
            } else {
                getPath(root.right, 0);
                return curPath;
            }
        }
    }
}