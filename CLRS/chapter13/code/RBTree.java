/**
 * 红黑树结点定义
 */
class RBNode{
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    public int key;            // 关键字
    public RBNode parent;      // 母亲结点
    public RBNode left;        // 左孩子结点
    public RBNode right;       // 右孩子结点
    public boolean color;      // 结点颜色

    public RBNode(int k,RBNode p,RBNode l,RBNode r,boolean c){
        this.key = k;
        this.parent = p;      
        this.left = l;
        this.right = r;
        this.color = c;
    }
}

/**
 * 红黑树定义
 */
public class RBTree{
    // 当结点指针为空时，均指向该结点；
    public final RBNode nil = new RBNode(0,null,null,null,RBNode.BLACK);

    public RBNode root;

    // 创建一棵空树, 根节点默认关键字为 0
    public RBTree(){
        root = new RBNode(0,nil,nil,nil,RBNode.BLACK);
    }

    // 创建一棵根节点关键字为 key 的树
    public RBTree(int key){
        root = new RBNode(key,nil,nil,nil,RBNode.BLACK);
    }

    public void leftRotate(RBNode z){
        // 交换当前结点与右孩子的左孩子的指针关系
        RBNode y = z.right;
        z.right = y.left;
        if (y.left != nil) {
            y.left.parent = z;
        }
        // 交换当前结点与右孩子共同祖先结点之间的指针关系
        y.parent = z.parent;        
        if (z.parent == nil) {
            root = y;
        } else if (z == z.parent.left) {
            z.parent.left = y;
        } else {
            z.parent.right = y;
        }
        // 交换当前结点与右孩子的指针关系
        y.left = z;
        z.parent = y;
    }

    public void rightRotate(RBNode z){
        RBNode y = z.left;
        z.left = y.right;
        if (y.right != nil) {
            y.right.parent = z;
        }
        y.parent = z.parent;
        if (z.parent == nil) {
            root = y;
        } else if (z == z.parent.left){
            z.parent.left =y;
        } else {
            z.parent.right = y;
        }
        y.right = z;
        z.parent = y;
    }

    private void insertFixup(RBNode z){
        while (z.parent.color == RBNode.RED) {
            // 母亲结点位于祖先结点左边
            if (z.parent == z.parent.parent.left){
                if (z.parent.right.color == RBNode.RED){           // case 1
                    z.parent.color = RBNode.BLACK;
                    z.parent.parent.right.color = RBNode.BLACK;
                    z.parent.parent.color = RBNode.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right){                     // case 2
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = RBNode.BLACK;                // case 3
                    z.parent.parent.color = RBNode.RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                if (z.parent.left.color == RBNode.RED){
                    z.parent.color = RBNode.BLACK;
                    z.parent.parent.left.color = RBNode.BLACK;
                    z.parent.parent.color = RBNode.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left){
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = RBNode.BLACK;
                    z.parent.parent.color = RBNode.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = RBNode.BLACK;
    }

    public void insert(RBNode n){
        RBNode y = nil;
        RBNode x = root;
        while (x != nil){
            y = x;
            if (n.key <= x.key){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        n.parent = y;
        if (y == nil) {
            root = n;
        } else if (n.key <= y.key){
            y.left = n;
        } else {
            y.right = n;
        }
        n.color = RBNode.RED;
        insertFixup(n);
    }

    public void insert(int key){
        RBNode n = new RBNode(key,nil,nil,nil,RBNode.RED);
        insert(n);
    }

    /** 
    * 获得该子树中最小值所在结点
    * @param cur 子树根结点
    */
    public RBNode getMinNode(RBNode cur){
        RBNode x = cur;
        while (x.left != nil) {
            x = x.left;
        }
        return x;
    }

    /** 
    * 将 sou 子树移动到 des 子树所在的位置上，
    * 没有更新移动后 sou 子树左右孩子结点的变化
    * 只更改替换后子树的父结点左右孩子结点变化
    * @param des 源子树的根节点
    * @param sou 目的子树的根节点
    */
    private void transplant(RBNode sou,RBNode des){
        if (des.parent == nil) {
            root = des;
        } else if (sou == sou.parent.left){
            sou.parent.left = des;
        } else {
            sou.parent.right = des;
        }
        des.parent = sou.parent;
    }
}