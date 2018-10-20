class TreeNode{
    public int key;
    public TreeNode left,right,parent;

    public TreeNode(int k){
        left = null;
        right = null;
        parent = null;
        key = k;
    }
}

public class BiTree{
    private TreeNode root;

    public BiTree(int k){
        root = new TreeNode(k);
    }

    private TreeNode insertNode(TreeNode tree,TreeNode node){
        if (tree == null){
            tree = node;
        }else if(tree.key > node.key){
            if (tree.left == null){
                tree.left = node;
                node.parent = tree;
            }else{
                insertNode(tree.left, node);
            }
        }else {
            if (tree.right == null){
                tree.right = node;
                node.parent = tree;
            }
            else {
                insertNode(tree.right, node);
            }
        }
        return tree;
    }
    public void insert(TreeNode node){
        root = insertNode(root, node);
    }

    public void printTree(){
        TreeNode prev = root;
        TreeNode cur = root.left;
        TreeNode next = null;
        while (cur != null){
            if (prev == cur.parent){
                next = cur.left;
                if (next == null){
                    System.out.print(cur.key+"\t");
                    next = cur.right;
                    if (next == null){
                        next = cur.parent;
                    }
                }
            } else if (prev == cur.left){
                System.out.print(cur.key+"\t");
                next = cur.right;
                if (next == null){
                    next = cur.parent;
                } 
            } else if (prev == cur.right){
                next = cur.parent;
            }
            prev = cur;
            cur = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BiTree tree = new BiTree(16);
        for (int i = 1;i < 15;i++){
            tree.insert(new TreeNode(i));
        }
        tree.printTree();
    }
}