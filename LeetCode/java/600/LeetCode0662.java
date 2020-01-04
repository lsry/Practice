import java.util.HashMap;
import java.util.Map;

public class LeetCode0662{
    private int width = 0;
    public int widthOfBinaryTreeTLE(TreeNode root) {
        maxWidth(root, 1, null, 1);
        return width;
    }

    public void maxWidth(TreeNode left,int lv,TreeNode right,int rv) {
        if ((left == null && right == null)) {
            return;
        } else if (right == null) {
            width = Math.max(1, width);
            maxWidth(left.left, lv * 2 - 1, left.right, lv * 2);
        } else if (left == null) {
            width = Math.max(1, width);
            maxWidth(right.left, rv * 2 - 1, right.right, rv * 2);
        } else {
            width = Math.max(width,rv - lv + 1);
            maxWidth(left.left, lv * 2 - 1, left.right,lv * 2);
            maxWidth(left.left, lv * 2 - 1, right.left, rv * 2 - 1);
            maxWidth(left.left, lv * 2 - 1, right.right, rv * 2);
            maxWidth(left.right, lv * 2, right.left, rv * 2 -1);
            maxWidth(left.right, lv * 2, right.right, rv * 2);
            maxWidth(right.left, rv * 2 - 1, right.right, rv * 2);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,0,1);
        return widthMax;
    }
    // 存放每一层最左结点
    private Map<Integer,Integer> leftNodes = new HashMap<>();
    private int widthMax = 0;
    private void dfs(TreeNode root,int depth,int pos) {
        if (root != null) {
            if (leftNodes.get(depth) == null) {
                leftNodes.put(depth, pos);
            }
            widthMax = Math.max(widthMax,leftNodes.get(depth) - pos + 1);
            dfs(root.left,depth + 1,pos * 2 - 1);
            dfs(root.right,depth + 1,pos * 2);
        }
    }
}