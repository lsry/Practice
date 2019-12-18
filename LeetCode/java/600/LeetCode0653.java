public class LeetCode0653{
    public boolean findTarget(TreeNode root, int k) {
        return find(root, root, k);
    }

    public boolean find(TreeNode root,TreeNode cur,int k){
        if (cur == null){
            return false;
        } else {
            return search(root, k - cur.val, cur) || find(root,cur.left, k) 
              || find(root, cur.right, k);
        }
    }

    public boolean search(TreeNode root,int target,TreeNode curNode){
        if (root == null){
            return false;
        } else if (root.val == target){ // 要求二叉搜索树中不存在相同值结点
            return (root != curNode) ? true : false;
        } else if (root.val > target){
            return search(root.left, target,curNode);
        } else {
            return search(root.right, target,curNode);
        }
    }
}