import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode0099{
    LinkedList<TreeNode> stack = new LinkedList<>(), uppers = new LinkedList<>(),lowers = new LinkedList<>();

    public void update(TreeNode root, TreeNode lower, TreeNode upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
      }

    public void recoverTree(TreeNode root) {
        TreeNode lower = null, upper = null, iNode;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) continue;
            iNode = root;
            if (lower != null && iNode.val <= lower.val) {
                int temp = iNode.val;
                iNode.val = lower.val;
                lower.val = temp;
                break;
            }
            if (upper != null && iNode.val >= upper.val) {
                int temp = iNode.val;
                iNode.val = upper.val;
                upper.val = temp;
                break;
            }
            update(root.right, iNode, upper);
            update(root.left, lower, iNode);

        }  
    } 
}