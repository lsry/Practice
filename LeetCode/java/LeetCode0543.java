class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode0543{
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res[] = diameter(root);
        return res[1] - 1;
    }

    public int[] diameter(TreeNode root){
        int[] res;
        if (root == null){
            res = new int[]{0,0};
        } else if (root.left == null && root.right == null){
            res = new int[]{1,1};
        } else if (root.right == null){
            int[] left = diameter(root.left);
            res = new int[]{left[0]+1,left[1]};
            if (left[0] + 1 > left[1]){
                res[1] = left[0] + 1;
            }
        } else if (root.left == null){
            int[] right = diameter(root.right);
            res = new int[]{right[0] + 1,right[1]};
            if (right[0] + 1 > right[1]){
                res[1] = right[0] + 1;
            }
        } else {
            int[] left = diameter(root.left);
            int[] right = diameter(root.right);
            int middle = left[0] + right[0] + 1;
            res = new int[2];
            res[0] = Math.max(left[0], right[0]) + 1;
            res[1] = Math.max(middle, Math.max(left[1], right[1]));
        }
        return res;
    }
}