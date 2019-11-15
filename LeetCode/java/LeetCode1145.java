public class LeetCode1145{
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findByValue(root, x);
        int xNum = getTreeNums(xNode);
        int xLeftNum = getTreeNums(xNode.left);
        int xRightNum = xNum - 1 - xLeftNum;
        return ((n - xNum) > xNum) || (xLeftNum > (n - xLeftNum)) || (xRightNum > (n - xRightNum));
    }

    private TreeNode findByValue(TreeNode root,int value){
        if (root != null){
            if (root.val == value){
                return root;
            } 
            TreeNode res = findByValue(root.left, value);
            if (res != null){
                return res;
            }
            res = findByValue(root.right, value);
            return res;
        }
        return null;
    }

    private int getTreeNums(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + getTreeNums(root.left) + getTreeNums(root.right);
    }
}