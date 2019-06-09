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

    /** 红黑树根节点 */
    public RBNode root;

    // 创建一棵空树
    public RBTree(){
        root = nil;
    }

    // 创建一棵根节点关键字为 key 的树
    public RBTree(int key){
        root = new RBNode(key,nil,nil,nil,RBNode.BLACK);
    }

    /**
     * 左旋，需要保证一定有右孩子，
     * 右孩子当做根，当前结点成为左孩子，右孩子的左孩子为当前结点的右孩子，然后替换父子关系
     * @param x 当前要旋转的结点 
     */
    public void leftRotate(RBNode x){
        // 交换当前结点与右孩子的左孩子的指针关系
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != nil) {
            y.left.parent = x;
        }
        // 交换当前结点与右孩子共同祖先结点之间的指针关系
        y.parent = x.parent;        
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        // 交换当前结点与右孩子的指针关系
        y.left = x;
        x.parent = y;
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
            // 母亲结点位于祖父结点左边，祖父结点必然是黑色的
            if (z.parent == z.parent.parent.left){
                RBNode y = z.parent.parent.right;
                if (y.color == RBNode.RED){           // case 1，叔结点为红色，
                                                      //         父结点和叔结点同时变黑，z 上移两层
                    z.parent.color = RBNode.BLACK;
                    y.color = RBNode.BLACK;
                    z.parent.parent.color = RBNode.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right){        // case 2，z 为右孩子 ，左旋到情况3
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = RBNode.BLACK;      // case 3, z 父结点变黑，祖父结点变红，以祖父结点右旋
                    z.parent.parent.color = RBNode.RED;
                    rightRotate(z.parent.parent);
                }
            } else if (z.parent == z.parent.parent.right) {
                RBNode y = z.parent.parent.left;
                if (y.color == RBNode.RED){
                    z.parent.color = RBNode.BLACK;
                    y.color = RBNode.BLACK;
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

    /**
     * 插入一个新结点，以红色插入
     * @param n 新的红色结点
     */
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
    * 将 des 子树移动到 sou 子树所在的位置上，des ----> sou               
    * 没有更新移动后 sou 子树左右孩子结点的变化，只更改替换后子树的父结点左右孩子结点变化
    * @param sou 源子树的根节点
    * @param des 目的子树的根节点
    */
    private void transplant(RBNode sou,RBNode des){
        if (sou.parent == nil) {
            root = des;
        } else if (sou == sou.parent.left){
            sou.parent.left = des;
        } else {
            sou.parent.right = des;
        }
        des.parent = sou.parent;
    }

    private void deleteFixup(RBNode x){
        while (x != root && x.color == RBNode.BLACK){
            if (x == x.parent.left){ 
                RBNode w = x.parent.right;
                if(w.color == RBNode.RED){          // case 1,兄弟结点为红色，w 变黑，parent 变红，左旋
                    w.color = RBNode.BLACK;
                    x.parent.color = RBNode.RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == RBNode.BLACK && w.right.color == RBNode.BLACK){
                    w.color = RBNode.RED;
                    x = x.parent;
                } else {
                    if (w.right.color == RBNode.BLACK){
                        w.left.color = RBNode.BLACK;
                        w.color = RBNode.RED;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = RBNode.BLACK;
                    w.right.color = RBNode.BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else if (x == x.parent.right){
                RBNode w = x.parent.left;
                if (w.color == RBNode.RED){
                    w.color = RBNode.BLACK;
                    x.parent.color = RBNode.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.left.color == RBNode.BLACK && w.right.color == RBNode.BLACK){
                    w.color = RBNode.RED;
                    x = x.parent;
                } else {
                    if (w.left.color == RBNode.BLACK){
                        w.right.color = RBNode.BLACK;
                        w.color = RBNode.RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = RBNode.BLACK;
                    w.left.color = RBNode.BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            } else {}
        }
        x.color = RBNode.BLACK;
    }

    /**
     * 删除结点 z
     * x : 移动至 y 的原始位置
     * y : 移动至 z 的原始位置
     */
    public void deleteNode(RBNode z){
        RBNode y = z;
        boolean ycolor = y.color;
        RBNode x = nil;
        if (z.left == nil){
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil){
            x = z.left;
            transplant(z, z.left);
        } else {
            y = getMinNode(z.right);
            ycolor = y.color;
            x = y.right;
            if (y.parent == z){
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (ycolor == RBNode.BLACK){
            deleteFixup(x);
        }
    }

    public RBNode search(int key){
        RBNode temp = root;
        RBNode result = nil;
        while (temp !=nil){
            if (temp.key == key){
                result = temp;
                break;
            } else if (temp.key < key){
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return result;
    }

    public void printTree(RBNode subroot){
        RBNode temp = subroot;
        if (temp != nil){
            printTree(temp.left);
            System.out.print("(key: " + temp.key + ", color: " + (temp.color?"RED":"BLACK") + ")\t");
            printTree(temp.right);
        }
    }

    public void printTree(){
        printTree(root);
    }

    public static void main(String[] args){
        int[] keys = new int[]{38,31,12,19,8};
        RBTree rt = new RBTree(41);
        for (int k : keys){
            rt.insert(k);
        }
        rt.printTree();
        int[] ds = new int[]{8,12,19,31,38,41};
        for (int d : ds){
            RBNode t = rt.search(d);
            rt.deleteNode(t);
            System.out.print("\ndelete " + d + " after: ");
            rt.printTree();
        }
    }
}