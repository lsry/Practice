## Chapter 2 算法基础

### 2.1 插入排序

#### 2.1-1
1. 31 [41] 59 26 41 58  
2. 31 41 [59] 26 41 58  
3. [26] 31 41 59 41 58
4. 26 31 41 [41] 59 58
5. 26 31 41 41 [58] 59

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
伪代码：

    SEARCH(A,v)
      for i = 1 to A.length
        if(A[i]==v)
          return i
      return NIL
证明：
* 初始化：当 i=1 时，if A[i]=v return 0 成立 else NIL 成立  
* 保持： 当 i 移动时 ，前面 i 个数已经被查找过了，如果等于 v 就会返回i 否则继续查找，因此前面 i 个数在循环中是不变的  
* 终止： 导致 for 终止条件为 存在 A[i] = v ，此时算法正确 否则扫描完成，A 中的所有元素均被查找过，不存在A[i]=v，则返回NIL 因此算法过程正确。


##### 描述：
输入：包含n个数的两个0 1数组A、B  
输出：包含n+1个数的0 1 数组C  
##### 思路：
将两个数组从低处对应位想加，得到的结果result作为C数组该位的数字，如有进位forward则加到高位。  
result=(A[i]+B[i]+forward)%2  
forward=(A[i]+B[i]+forward)/2

或者运用加法器原理：

    if((a[i]&forward|b[i]&forward|a[i]&b[i])==1)
      forward=1;
[二进制加法代码](AddBinary.java)

### 2.2 分析算法

#### 2.2-1
$Θ(n^3)$

#### 2.2-2
1. 伪代码：   


    ChooseSort(A)                       时间          次数
      for i=1 to A.length-1             c1            n
        key = A[i]                      c2            n-1     
        for j = i+1 to A.length-1       c3            n-1
          if key > A[j]                 c4           (2 n-1)和(j-1)
            交换A[j]与key               c5            (2 n-1)和(j-1)
        A[i] = key                      c6            n-1


2. [选择排序代码](ChooseSort.java)
3. 循环不变式：前面已经排好序的数字序列
4. 当排到最后一个数时，必然已经是最大的数，不需要再比较
5. 最好情况：已经排好序的数组，第二个for不用再做，即$Θ(n)$  
   最坏情况：倒序排列， 时间是$Θ(n^2)$

#### 2.2-3
1. 平均情况：查找1,2,3，...，n位数的次数分别是1,2,3,...,n次，查找每个数的概率均为1/n, 平均查找次数 (1+2+3+...+n)*1/n =(n+1)/2    
2. 最坏情况:所要查找的不存在或位于最后一位数，则查找次数 n  
   时间均为$Θ(n)$  

#### 2.2-4
保证输入时，数据是良好的

### 2.3 设计算法