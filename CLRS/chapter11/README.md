## Chapter 11 散列表         

### 11.1 直接寻址表     

#### 11.1-1          
如果存在最大元素，则一定位于直接寻址表T所存放元素的最后一个，所以从后向前遍历，查找第一个不为空的位置即可。        
最坏情况为T只有第一个位置有元素，时间为O(m)          

#### 11.1-2   
    //假设关键字 key ∈ {0,1,...,m-1}      
    //初始化长度为m的数组,每一位置0 ，代表没有对应关键字    
    arr[m] = {0}
    DIRECT-ADDRESS_SEARCH(T,k)
      if T[k] == 1
        return k
      else return -1
    DIRECT-ADDRESS_INSERT(T,k)
      T[k] = 1
    DIRECT-ADDRESS_DELETE(T,k)
      T[k] = 0

#### 11.1-3            
插入时若有相同关键字，替换为新的指针即可

#### 11.1-4         
在栈S中存储元素，然后在大数组中对应key位置赋栈指针值        
    
    A[];
    S[],top = -1
    INSERT(x)
      top++
      S[top] = x
      A[x.key] = top
    SEARCH(x)
      if A[x.key] <= top
        return S[A[x.key]]
    DELETE(x)
      if A[x.key] <= top
        exchange S[top] and S[A[x.key]]
        top--

### 11.2 散列表             
