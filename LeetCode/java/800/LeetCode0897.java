import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode0897 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(0);
        TreeNode h = head;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.addFirst(cur);
                cur = cur.left;
            }
            cur = stack.removeFirst();
            h.right = new TreeNode(cur.val); // 如果不重新生成一棵树，需要将左孩子设置为null,否则不再为一棵树
                                             // 形成环，在遍历树的过程中形成死循环
            h = h.right;
            cur = cur.right;
        }
        return head.right;
    }
}