public class BinSearchTree{
    // 结点类定义，静态内部类，
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
        Node x = root;      // 迭代变量，为了找到 z 母亲结点的位置
        Node z = new Node(k);
        // 1. 找到要插入结点的母亲结点
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
    * 中序遍历，迭代版本，使用栈
    * @param base 遍历的开始位置
    */
    public void inOrderIterStack(Node base){
        // 初始化一个栈
        Node[] stack = new Node[100];  // 数组长度应该不小于树的结点数
        int point = -1;
        Node cur = base;
        while (cur != null) {
            if (cur.getLeft() != null) {
                point++;
                stack[point] = cur;
                cur = cur.getLeft();
            } else {
                cur = stack[point];
                point--;
            }
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
    public Node maxNodeFromBase(Node base){
        Node temp = base;
        while (temp != null && temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp;
    }
    
    public Node maxNode(){
        return maxNodeFromBase(root);
    }

    /*
    * 查找当前结点中序遍历中的后继
    * @param cur 当前结点
    * @return 后继结点
    */
    public Node successor(Node cur){
        Node curr = cur;
        if (curr == null){
            return curr;
        }
        // 1. 如果有右子树，则后继必然在右子树的最小结点上
        if (curr.getRight() != null){
            return minNodeFromBase(curr.getRight());
        }
        // 2. 后继结点左子树的最大值为当前结点的值，即当前结点位于后继结点的左子树上，
        Node y = curr.getParent();
        while (y != null && curr == y.getRight()){
            curr = y;
            y = y.getParent();
        }
        return y;
    }

    public Node successor(int k){
        Node cur = search(k);
        return successor(cur);
    }

    /*
    * 查找当前结点中序遍历的前驱
    * @param cur 当前结点
    * @return 后继结点
    */
    public Node predecessor(Node cur){
        Node curr = cur;
        if (curr == null){
            return curr;
        }
        if (curr.getLeft() != null){
            return maxNodeFromBase(curr.getLeft());
        }
        Node y = curr.getParent();
        while (y != curr && curr == y.getLeft()){
            curr = y;
            y = curr.getParent();
        }
        return y;
    }

    public Node predecessor(int k){
        Node cur = search(k);
        return predecessor(cur);
    }

    /*
    * 将 sou 子树移动到 des 子树所在的位置上，没有更新移动后 sou 子树左右孩子结点的变化
    * 只更改替换后子树的父结点左右孩子结点变化
    * @param des 源子树的根节点
    * @param sou 目的子树的根节点
    */
    private void transplant(Node des, Node sou){
        if (des == null){
            return;
        } else if (des.getParent() == null){   // 此时 des 为树的根节点
            root = sou;
        } else if (des == des.getParent().getLeft()){
            des.getParent().setLeft(sou);
        } else {
            des.getParent().setRight(sou);
        }
        if (sou != null){
            sou.setParent(des.getParent());
        }
    }

    /*
    * 删除 cur 结点
    * @param cur 要删除的结点
    */
    public void deleteNode(Node cur){
        if (cur.getLeft() == null){
            transplant(cur, cur.getRight());
        } else if (cur.getRight() == null){
            transplant(cur, cur.getLeft());
        } else {
            Node success = minNodeFromBase(cur.getRight());  // 查找要删除节点的后继
            // 将删除结点的右子树替换到后继结点的右子树上，然后后继结点成为删除节点的右女儿
            if (success.getParent() != cur){
                transplant(success, success.getRight());
                success.setRight(cur.getRight());
                success.getRight().setParent(success);
            }
            // 将右女儿移动到删除结点上
            transplant(cur, success);
            success.setLeft(cur.getLeft());
            success.getLeft().setParent(success);
        }
    }

    public void deleteNode(int k){
        Node cur = search(k);
        deleteNode(cur);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,4,17,1,16,5,21};
        BinSearchTree tree = new BinSearchTree();
        for (int a : arr){
            tree.insert(a);
        }
        tree.inOrderRecur(tree.getRoot());
        System.out.print("\n");
        tree.deleteNode(16);
        tree.inOrderRecur(tree.getRoot());
        System.out.print("\n");
    }
}