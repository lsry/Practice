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
