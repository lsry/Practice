class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode0098{
    class Res{
        public boolean isvalid;
        public Integer low;
        public Integer hig;

        public Res(boolean valid,Integer l,Integer h){
            isvalid = valid;
            low = l;
            hig = h;
        }

        public Res(){}
    }

    public boolean isValidBST(TreeNode root) {
        return check(root).isvalid;
    }

    // 自底向上验证
    public Res check(TreeNode node){
        if (node == null){
            return new Res(true,null,null);
        } else if (node.left == null && node.right == null){
           return new Res(true,node.val,node.val);
        } else if (node.left == null && node.right != null){
            Res right = check(node.right);
            if (!right.isvalid || right.low <= node.val){
                return new Res(false,null,null);
            }
            right.hig = (right.hig > node.val) ? right.hig : node.val;
            right.low = (right.low < node.val) ? right.low : node.val;
           return right;
        } else if (node.left != null && node.right == null){
            Res left = check(node.left);
            if (!left.isvalid || left.hig >= node.val){
                return new Res(false,null,null);
            }
            left.hig = (left.hig > node.val) ? left.hig : node.val;
            left.low = (left.low < node.val) ? left.low : node.val;
            return left;
        } else {
            int val = node.val;
            Res left = check(node.left);
            Res right = check(node.right);
            if (!left.isvalid || !right.isvalid || 
                (left.hig != null && left.hig >= val) || (right.low != null && right.low <= val)){
                return new Res(false,null,null);
            }
            
            Res res = new Res();
            res.isvalid = true;
            if (left.low != null && right.low != null){
                if (left.low < val && left.low < right.low){
                    res.low = left.low;
                } else if (val < left.low && val < right.low){
                    res.low = val;
                } else {
                    res.low = right.low;
                }
            } else if (left.low == null && right.low != null){
                res.low = (val < right.low) ? val : right.low;
            } else if (left.low != null && right.low == null){
                res.low = (val < left.low) ? val : left.low;
            } else {
                res.low = val;
            }
            if (left.hig != null && right.hig != null){
                if (left.hig > val && left.hig > right.hig){
                    res.hig = left.hig;
                } else if (right.hig > left.hig && right.hig > val){
                    res.hig = right.hig;
                } else {
                    res.hig = val;
                }
            } else if (left.hig != null && right.hig == null){
                res.hig = (left.hig > val) ? left.hig : val;
            } else if (left.hig == null && right.hig != null){
                res.hig = (right.hig > val) ? right.hig : val;
            } else {
                res.hig = val;
            }
            return res;
        }
    }
}