import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 交换左子树和右子树，并非交换对应的值
 */
public class LeetCode0971 {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> wrong = new ArrayList<>();
        wrong.add(-1);
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> nodes = new ArrayDeque<>();
        TreeNode cur = root;
        nodes.addFirst(cur);
        int index = 0;
        while (!nodes.isEmpty()){
            cur = nodes.removeFirst();
            if (cur.val != voyage[index]){
                result = wrong;
                break;
            }
            index++;
            if (index >= voyage.length){
                break;
            }
            if (cur.left != null && cur.left.val != voyage[index]){
                result.add(cur.val);
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            }
            if (cur.right != null){
                nodes.addFirst(cur.right);
            }
            if (cur.left != null){
                nodes.addFirst(cur.left);
            }
        }
        return result;
        
    }
}