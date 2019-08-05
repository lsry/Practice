import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode0094{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        Stack<TreeNode> stn = new Stack<>();
        TreeNode tn = root;
        while (tn != null || !stn.empty()){
            while (tn != null){
                stn.push(tn);
                tn = tn.left;
            }
            tn = stn.pop();
            li.add(tn.val);
            tn = tn.right;
        }
        return li;
    }
}