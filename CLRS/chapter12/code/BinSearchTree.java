public class BinSearchTree{
    // 结点类定义
    public static class Node{
        private int key;
        private Node parent;
        private Node left;
        private Node right;

        public Node(int k){
            key = k;
            parent = null;
            left = null;
            right = null;
        }

        public int getKey(){
            return key;
        }

        public void setParent(Node p){
            parent = p;
        }

        public Node getParent(){
            return parent;
        }

        public void setLeft(Node l){
            left = l;
        }

        public Node getLeft(){
            return left;
        }

        public void setRight(Node r){
            right = r;
        }

        public Node getRight(){
            return right;
        }
    }

    private Node root;

    public Node getRoot(){
        return root;
    }

    public BinSearchTree(){
        root = null;
    }

    public BinSearchTree(int k){
        root = new Node(k);
    }

    /*
    * 双指针法找需要插入的结点位置
    * @param k 插入的关键字
    */
    public void insert(int k){
        Node y = null;      // 纪录 z 的母亲结点所在位置
        Node x = root;      // 为了找到 z 母亲结点的位置
        Node z = new Node(k);
        while (x != null){
            y = x;
            if (z.getKey() < x.getKey()){
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        } 
        z.setParent(y);
        if (y == null){
            root = z;
        } else if (z.getKey() < y.getKey()){
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
    }

    /*
    * 查找递归版本
    * @param k 关键字
    * @param base 遍历的开始位置
    */
    private Node searchRecur(Node base, int k){
        if (base == null || base.getKey() == k){
            return base;
        } else {
            if (base.getKey() < k){
                return searchRecur(base.getRight(), k);
            } else {
                return searchRecur(base.getLeft(), k);
            }
        }
    }

    /*
    * 查找循环版本
    * @param k 关键字
    * @param s 区别递归标识
    */
    public Node search(String  s,int k){
        Node temp = root;
        while (temp != null && temp.getKey() != k){
            if (temp.getKey() < k){
                temp = temp.getRight();
            } else {
                temp = temp.getLeft();
            }
        }
        return temp;
    }

    /*
    * 查找递归版本
    * @param k 关键字
    */
    public Node search(int k){
        return searchRecur(root, k);
    }

    /*
    * 中序遍历，递归版本
    * @param base 遍历的开始位置
    */
    public void inOrderRecur(Node base){
        if (base != null){
            inOrderRecur(base.getLeft());
            System.out.print(base.getKey()+ "  ");
            inOrderRecur(base.getRight());
        }
    }

    /*
    * 最小关键字结点
    * @param base 查找起始结点
    * @return temp 最小关键字结点
    */
    private Node minNodeFromBase(Node base){
        Node temp = base;
        while (temp != null && temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp;
    }
    
    public Node minNode(){
        return minNodeFromBase(root);
    }

    /*
    * 最大关键字结点
    * @return temp 最大关键字结点
    */
    public Node maxNode(){
        Node temp = root;
        while (temp != null && temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp;
    }

    /*
    * 查找当前结点后继
    * @param cur 当前结点
    * @return 后继结点
    */
    public Node successor(Node cur){
        if (cur == null){
            return cur;
        }
        if (cur.getRight() != null){
            return minNodeFromBase(cur.getRight());
        }
        Node y = cur.getParent();
        while (y != null && cur == y.getRight()){
            cur = y;
            y = y.getParent();
        }
        return y;
    }

    public Node successor(int k){
        Node cur = search(k);
        return successor(cur);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,4,17,1,16,5,21};
        BinSearchTree tree = new BinSearchTree();
        for (int a : arr){
            tree.insert(a);
        }
        tree.inOrderRecur(tree.getRoot());
        System.out.print("\n");
        System.out.println(tree.successor(4).getKey());
        //System.out.println(tree.maxNode().getKey());
    }
}