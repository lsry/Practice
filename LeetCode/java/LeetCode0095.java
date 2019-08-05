import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode0095{
    public List<TreeNode> generateTrees(int n) {
        return generateHalf(1, n);
    }

    /**
     * 生成左右两颗子树，然后连接起来即可
     */
    public List<TreeNode> generateHalf(int left,int right) {
        List<TreeNode> ltn = new ArrayList<>();
        if (left > right){
            return ltn;
        } else if (left == right){
            TreeNode tn = new TreeNode(left);
            ltn.add(tn);
        } else {
            for (int i = left;i <= right;i++){
                List<TreeNode> leftTrees = generateHalf(left, i-1);
                List<TreeNode> rightTrees = generateHalf(i+1, right);
                if (leftTrees.isEmpty()){
                    for (TreeNode rt : rightTrees){
                        TreeNode n = new TreeNode(i);
                        n.right = rt;
                        ltn.add(n);
                    }
                } else if (rightTrees.isEmpty()){
                    for (TreeNode lt : leftTrees){
                        TreeNode n = new TreeNode(i);
                        n.left = lt;
                        ltn.add(n);
                    }
                } else {
                    for (TreeNode lt : leftTrees){
                        for (TreeNode rt : rightTrees){
                            TreeNode n = new TreeNode(i);
                            n.left = lt;
                            n.right = rt;
                            ltn.add(n);
                        }
                    }
                }   
            }
        }
        return ltn;
    }
}