import java.util.Deque;
import java.util.LinkedList;

public class LeetCode0173 {}

class BSTIterator {
    Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        TreeNode t = root;
        while (t != null) {
            stack.addFirst(t);
            t = t.left;
        }        
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.removeFirst();
        int v = cur.val;
        TreeNode rchild = cur.right;
        while (rchild != null) {
            stack.addFirst(rchild);
            rchild = rchild.left;
        }
        return v;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
