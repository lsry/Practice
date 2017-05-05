## Chapter 2 算法基础

### 2.1 插入排序

#### 2.1-1
>1. 31 41 59 26 41 58  
2. 31 41 59 26 41 58  
3. 26 31 41 59 41 58
4. 26 31 41 41 59 58
5. 26 31 41 41 58 59

#### 2.1-2
    INSERRT_SORT(A)
      for j=2 to A.length
      key = A[j]
      i = j-1
      while i>0 and A[i]<key
        A[i+1] = A[i]
        i = i-1
      A[i+1] = key

#### 2.1-3
>    
    SEARCH(A,v)
      for(i=0;i<A.length;++i)
        if(A[i]=v)
          return i
      return NIL
证明：
* 初始化：当 i=0 ，if A[i]=v return 0 成立 else NIL 成立  
* 保持： 当 i 移动时 ，前面 i 个数已经被查找过了，如果等于 v 就会返回i 否则继续查找，因此前面 i 个数在循环中是不变的  
* 终止： 导致 for 终止条件为 存在 A[i] = v ，此时算法正确 否则扫描完成，A 中的所有元素均被查找过，不存在A[i]=v，则返回NIL 因此算法过程正确。

#### 2.1-4
\Theta
