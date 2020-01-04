import java.util.Deque;
import java.util.LinkedList;

public class LeetCode0965 {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        Deque<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            if (cur.val != val) {
                flag = false;
                break;
            }
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
        }
        return flag;
    }
}