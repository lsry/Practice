## Chapter 10 基本数据结构

### 10.1 栈和队列

#### 10.1-1
![](img/1011.png)   

#### 10.1-2
建立两个栈分别从数组首部和尾部向内扩展，当两个栈顶指针相等时即代表已满。         
[MyDoubleStack](code/MyDoubleStack.java)  

#### 10.1-3       
![](img/1013.png)   

#### 10.1-4   
[MyQueue](code/MyQueue.java)

#### 10.1-5
头指针和尾指针处均可出入队列     
[MyDeQueue](code/MyDeQueue.java)

#### 10.1-6     
[StackToQueue](code/StackToDequeu.java)

**入队时间：**        
直接进栈1即可，时间O(1)     
**出队时间：**        
由于出队过程发生在栈2，而入队过程在栈1，元素存在从栈1到栈2的移动过程，所以时间O(n)      

#### 10.1-7     
[QueueToStack](code/QueueToStack.java)      
**入栈时间：**        
直接在有元素的队列入队即可，时间O(1)     
**出栈时间：**     
需要将有元素的队列前length - 1个元素移动到空队列中，然后出最后一个元素，时间O(n)        

### 10.2 链表      

#### 10.2-1       
**Insert：**  
链式结构，头插法可在O(1)时间内完成          
**DELETE：**       
若删除第一个元素则可以，其他特定元素则需要遍历链表

#### 10.2-2      
单链表头插法形成的顺序是与输入相反的，因此结果与栈结构相同      
[SingalListStack](code/SingalListStack.java)        

#### 10.2-3   
单链表尾插法形成顺序与输入相同，从头到为为输入顺序，需要一个变量保存尾结点位置           
[SingalListQueue](code/SingalListQueue.java)    

#### 10.2-4        
将关键字赋给nil,因此在遍历的过程中，要么发现存在关键字，返回那个元素，要么返回nil     

    LIST-SEARCH(L,k)
      L.nil.key = k
      ptr = L.nil.next
      while ptr.key != k
        ptr = ptr.next
      return ptr

#### 10.2-5      
[SingalCircleList](code/SingalCircleList.java)

#### 10.2-6        
用循环链表 ，可以找到头结点和尾结点，交换指针即可     

#### 10.2-7     
[SingalList reverse](code/SingalList.java)

#### 10.2-8  
异或：C = A ⊕ B , A = C ⊕ B , B = A ⊕ C      

    //结点信息
    node{key np}
    //形成的链表 , 
    //nil.np = nil.next , nil.prev = nil.np XOR nil.np      
    List{
        tail,head
        Node nil
        nil.np = 0
        head = tail =  nil.np

        insert(Node n)
          n.np = nil.np XOR &nil
          [nil.np].np = &n XOR &nil
          nil.np = nil.np XOR nil.np XOR &n

        search(k)
          temp = nil.np
          prev = &nil
          while [temp].key != k
            temp = [temp].np XOR prev
            prev = temp
          return temp
        
        reverse()
          nil.np = nil.np XOR nil.np
    }

### 10.3 指针和对象的实现   

#### 10。3-1       
**多数组表现形式：**      
![](img/10311.jpg)

**单数组表现形式：**     
![](img/10312.jpg)       

#### 10.3-2        
    ; 存储数据用的数组         
    arr[length]      
    ; 假设同构对象结构：key , next , prev  
    free = 0 
    ALLOCATE-OBJECT()
      if free == -1
        error "out of space"
      else 
        x = free
        free = arr[free + 1]
      return x
    
    FREE-OBJECT(x)
      arr[x+1] = free
      free = x

#### 10.3-3      
不用找之前的空间，分配当前头指针指向的空间即可 ，分配出去后便可以重置    

#### 10.3-4      
    ;分配元素，直接分配即可  
    ; top : 当前自由表开始位置  
    ALLOCATE-OBJECT()
      x = top
      top ++;
      return x

    ; 释放元素 ，如果恰好在自由表的前面，则直接释放否则，将自由表前面空间的数据移动到释放的位置，然后释放自由表前面的空间     
    FREE-OBJECT(x)
      [x] = [top--]
      top--

#### 10.3-5     
    ; L , F 代表当前表的开头结点序号  
    ; 为满足紧凑性 0 <= L < n , n <= F < m   
    COMPACTIFY-LIST(L,F)    
      while L != nil
        ;找到一个不在范围的 L   
        while L < n && L != nil
          L = next[L]
        ;找到一个不在范围的 F  
        while F >= n && F != nil
          F = next[F]
        if L == nil || F == nil
          break
        ; 交换双方的数据，并更改对应元素的指针  
        key[F] = key[L]
        next[prev[F]] = L
        prev[next[F]] = L
        next[prev[L]] = F
        prev[next[L]] = F
        exchange next[F] and next[L]
        exchange prev[F] and prev[L]  
        exchange L and F
        L = next[L]
        F = next[F]

### 10.4 有根树   

#### 10.4-1           
---------- 18 --------------          
------12--------10-----------       
---7-----4----2-----9--------    
-------5---------------------       
15  ,    14            

#### 10.4-2        
    print(root)
      while root != nil
        打印 root.key
        print(root.left)
        print(root.right)

#### 10.4-3             
    print(root)
      InitStack(S)
      S.push(root)
      while !S.empty()
        n = S.pop()
        if n.left != nil  
          S.push(n.left)
        if n.right != nil
          S.push(n.right)
        打印 n.key

#### 10.4-4           
    print(root)
      while root != nil
        打印 root.key
        print(root.left-child)
        print(root.right-sibling)           

#### 10.4-5          
