## Capter 12 二叉搜索树

### 12.1 什么是二叉搜索树

#### 12.1-1      
1. **高度为2：** 高度为 2 最多有 3 个元素，而集合有 7 个，所以不满足。 
2. **高度为3：** ![](img/1211a.png)      
3. **高度为4：** ![](img/1211b.png) 
4. **高度为5：** ![](img/1211c.png) 
5. **高度为6：** ![](img/1211d.png) 
6. **高度为7：** ![](img/1211e.png)         

#### 12.1-2         
1. **最小堆性质：** 某结点值在以该结点作为根的子树中值最小        
   **二叉搜索树性质：** 左孩子结点及后代结点的值小于等于根结点的值，右孩子结点及后代结点的值大于根结点的值。          
2. 无法在线性时间内完成，因为没办法知道哪一个孩子有最小值，需要进行比较，因而最佳时间为 O(nlgn)               

#### 12.1-3     
[简单，栈 inOrderIterStack](code/BinSearchTree.java)      

#### 12.1-4 
更换一下中序遍历的顺序即可  

#### 12.1-5           
在建立二叉搜索树的过程中，插入的结点总要与路径上的结点进行比较，到达当前搜索树的叶结点处（该结点的位置），对于 n 个结点来说，最少的比较次数为 Ω(nlgn) , 因此最坏情况下需要 Ω(nlgn) 时间。          

### 12.2 查询二叉搜索树        

#### 12.2-1          
对于 X = < x1, x2, ..., xn > , 若 xi < xj , 则任意 x ∈ {x_j+1,..., xn} xi < x ;               
所以 e 不符合 ， 因为 347 < 621 ，而 347 > 299       

#### 12.2-2       
[minNodeRecu, maxNodeRecu](code/BinSearchTree.java)          

#### 12.2-3            
[predecessor](code/BinSearchTree.java)         

#### 12.2-4          
![](img/1224.png)          
如图所示，根节点为 3 ， 查找 6 ， A = {4} , B = {3,5,6} , C = {}        
存在 a = 4 , b = 3 , 使得 a > b ;           

#### 12.2-5           
**证明：** 当前结点为 n ，左孩子为 l , 右孩子为 r , 后继为 c , 前驱为 p ;则 p.k <= n.k <= c.k     
假设后继 c 存在左孩子 cl , 那么 cl.k <= c.k ， 可得到 n.k <= cl.k <= c.k ， 则 cl 为后继；     
前驱同理可证没有右孩子；            

#### 12.2-6             
**证明：** x.rchild == null, 存在 y 为 x 的后继，   
考虑以 y.lchild 为根的子树，x 必然为关键字最大的结点，位于 y.lchild 的右子树上, 因为若位于左子树上，则 y.lchild.key > x.key; 其次，从 y.child 到 x 的路径上若存在一个大于 x 关键字的结点，那么该结点为 x 的后继，x 位于该结点的左子树上，与 y 为 x 后继矛盾；     
得到 y.key > x.key > y.lchild.key ;     
此外树的其它部分不存在结点 y' , 使得 y.key > y'.key > x.key;   
因此得 y 为 x 的后继。   

#### 12.2-7      
**证明：**   
1. 由于算法输出 n 个结点，得到 T(n) = Ω(n)        
2. 对于 n 个结点的二叉树，有 n - 1 条边，每条边只在查找后继和查找子树中最大结点后继中被使用，因此算法运行过程中，每条边最多使用两次，所以T(n) = O(n)        
3. T(n) = θ(n)                     

#### 12.2-8        
略

#### 12.2-9        
**证明：**               
1. case: x = y.left_child,          
   y.key > x.key, 如果存在结点 y' != x, 使得 y.key > y'.key > x.key, 那么由二叉树性质，y' 位于 y 的左子树上，又由于 x 为 y 的左孩子，y' 位于 y 的左孩子 x 和 y 之间的位置，而该位置不存在，那么 y' 要么与 x 重合, 要么与 y 重合，因此 y' 不存在；所以 y 为大于 x 关键字的最小结点；          
2. 同理可证；    

### 12.3 插入和删除          

#### 12.3-1           
[insertRecur](code/BinSearchTree.java)          

#### 12.3-2  
在搜索过程中，需要检查当前结点是否和关键字相等，插入时只需要和祖先结点关键字比较；          

#### 12.3-3    
1. 每次插入的时间为 log(h) 平均时间为 T(n) = lg1 + lg2 + ... + lg(n) = O(nlgn) , 最坏时间当按顺序插入时， T(n) = O(n^2)           
2. 中序遍历的时间为T(n) = O(n)        
3. 因此该方法排序时间：O(nlgn) ，最坏时间 O(n^2)               

#### 12.3-4       
不可交换，

#### 12.3-5 

    SEARCH(x,k)
      t = x
      while t != null && t.key != k
       if t.key > k
         t = t.left
       else
         t = t.right
      return t;

    // 插入左边不影响后继，右边需要在遍历时和当前结点后继比较大小，若小则后继为插入结点
    insert(T,z)
      y = null
      x = T.root
      while x != null
        y = x
        if x.key > z.key
          x = x.left
        else 
          x = x.right
          if y.succ != null
            y.succ = (y.succ.key > z.key) ? z : y.succ
      if y == null
        T.root = z
      else if y.key > z.key
        y.left = z
        z.parent = y
      else 
        y.right = z
        y.succ = z
        z.parent = y

    // bugs
    Delete(T,z)
      if z.left == null
        transplant(T,z,z.right)
        z.parent.succ = Tree-min(T,z.right)
      else if z.right == null
        transplant(T,z,z.left)
      else 
        y = Tree-Min(T,z.right)
        if y.parent != z
          transplant(T,y,y,right)
          y.right = z.right
          y.right.parent = y
          y.succ = Tree-min(T,y.right)
        transplant(T,z,y)
        y.left = z.left
        y.left.parent = y
        y.parent.succ = Tree-Min(y)

#### 12.3-6     

    Tree-Delete(T,z)
      if z.left == null
        transplant(T,z,z.right)  
      else if z.right == null
        transplant(T,z,z.left)
      else
        y = Tree-max(T,z.left)
        if (y.parent != z)
          transplant(T,y,y.left)
          y.left = z.left
          y.left.parent = y
        transplant(T,z,y)
        y.right = z.right
        y.right.parent = y

### 12.4 随机构建二叉搜索树

#### 12.4-1   
数学归纳法          
![](img/1241.gif)       

#### 12.4-2   
**1. 描述：** 其中有一条路径的相对于其他叶结点深度较深      
**2. 高度：** O(n)                 

#### 12.4-3
随机选择二叉树中，对于某位中间值 x 作为根的树，不会由于其大于 x 和小于 x 的相对顺序改变而改变树的形状，因此这两种视为一种情况，而随机构建二叉树将上述两种情况分开。   

#### 12.4-4 
求二阶导数   
f(x) = 2^x , f''(x) = (ln2)^2 * 2^x > 0 恒成立，所以是凹函数  (convert function)               

#### 12.4-5   

### 思考题

#### 12-1         
**a.** 由于相等时总会选择一条默认路径，不妨总从大的方向走，因此 T(n) = O(n)              

**b.** 