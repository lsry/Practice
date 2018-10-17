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
