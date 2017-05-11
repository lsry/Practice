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
* 终止： 导致 for 终止条件为存在 A[i] = v ，此时算法正确 否则扫描完成，A 中的所有元素均被查找过，不存在A[i]=v，则返回NIL 因此算法过程正确。

#### 2.1-4
###### 描述：
输入：包含n个数的两个0 1数组A、B  
输出：包含n+1个数的0 1 数组C  
###### 思路：
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

```cpp
     ChooseSort(A)                  时间      次数  
     1. for i=1 to A.length-1         c1     n  
     2.    key = A[i]                 c2     n-1       
     3.    for j = i+1 to A.length-1  c3     n-1
     4.      if key > A[j]            c4    Σ(j-1)  
     5.      交换A[j]与key             c5    Σ(j-1)  
     6.    A[i] = key                 c6     n-1   
```
2. [选择排序代码](ChooseSort.java)
3. 循环不变式：前面已经排好序的数字序列
4. 当排到最后一个数时，必然已经是最大的数，不需要再比较
5. 最好情况：已经排好序的数组，第二个for不用再做，即$Θ(n)$  
   最坏情况：倒序排列， 时间是$Θ(n^2)$

#### 2.2-3
1. 平均情况：查找1,2,3，...，n位数的次数分别是1,2,3,...,n次，查找每个数的概率均为1/n, 平均查找次数 (1+2+3+...+n) * 1/n =(n+1)/2    
2. 最坏情况:所要查找的不存在或位于最后一位数，则查找次数 n  
   时间均为$Θ(n)$  

#### 2.2-4
保证输入时，数据是良好的

### 2.3 设计算法

#### 2.3-1
    {3,9,26,38,41,49,52,57}
    {3,9,26,38} {41,49,52,57}
    {3,9} {26,38} {41,49} {52,57}
    {3} {9} {26} {38} {41} {49} {52} {57}

#### 2.3-2
    MERGE(A,p,q,r)
    n1=q-p+1 n2=r-q
    let L[1..n1] and R[1..n2] be new arrays
    for i=1 to n1
        L[i] = A[p+i-1]
    for i=1 to n2
        R[i] = A[q+i]
    i=1,j=1,k=p
    while i<=n1 and j<=n2
        if L[i]<=R[j]
            A[k] = L[i]
            i=i+1
        else
            A[k] = R[j]
            j=j+1
        k=k+1
    if i=n1
        let R cope to A
    else if j=n2
        let L cope to A


#### 2.3-3
1. 当n=2时，T(1)=2*lg2=2，成立；
2. 假设当n=k,k为2的幂时成立，即T(k) = 2T(k/2)+k = klgk成立；
3. 当n=2*k时，T(2k) = 2T(2k/2)+2*k = 2T(k)+2k =  
2klgk+2k = 2k(lg2+lgk) = 2klg(2k)
4. 综上所述，原式成立

#### 2.3-4
    T(n) =
          c 当n=1  
         (n-1/n)T(n-1)+ Θ(n^2) 当 n>1

#### 2.3-5
##### [二分查找代码](Search.java)
##### 证明
1. 查找递归式 T(n)= c n=1   
                   T(n/2)+c n>1
2. 递归树：         
      一层： c             
      二层： c/2    c/2  
      三层： c/4    c/4    c/4    c/4   
      .....  
      总共lgn+1 层，每层均为c  
      时间为 clgn + c

#### 2.3-6
1. 伪代码：


    INSERT(A)
    if A.length<2
        return A
    for i=2 to A.length
        key=A[i]
        j=i-1
        if j>0
            k=BINARYS(A,1,j,key)
            if k!=NIL
                for s=j down to k
                    A[s+1]=A[s]
                A[k]=key

2. 证明：  
 T(n)=n(lgn+n)=Θ(n^2)

 #### 2.3-7
     SEARCH(S,x)
     for j=1 to S.length
         k=BINARYS(S,x-S[j])
         if k!=NIL
            return true
    return false;

### 思考题

#### 2-1
* a 证明：插入排序排k个元素需要Θ(k^2) 总共有n/k个子表 所用总时间为Θ(k^2*(n/k))=Θ(nk)

* b 总共有lg(n/k)+1层，每层代价均为cn,向上合并时，每两个排好序的合并，从而总代价为cn(lg(n/k)+1) = Θ(nlg(n/k))

* c 由Θ(nk+nlg(n/k))=Θ(nlgn) 得：k=lgn 或者 lg(n/k)=n （k==1)  
由max k=lgn

* d 插入排序时间：8n^2  
归并排序时间：64nlgn  
得： 2 < n < 43    选择 n=40

#### 2-2
* a 排完序后的数组元素是原来的元素

* b 循环不变式：算法中，只是交换 A[i,..j]数组中元素的位置，但是并没有改变 j to A.length 中元素的前后关系（非大小），因此子数组A[j,..A.length]中A[j]为最小元素为该循环不变式；  
证明：  
初始化：当 j=A.length 时，子数组只有一个元素，因此成立；  
保持：当 j 减小时，只是交换 A[i,..j]数组中元素的位置，但是并没有改变 j to A.length 中的位置，而且将前面的元素交换到该不变式数组中的适当位置，A[j]保持最小；   
终止：循环终止条件为 j=i+1,由于先A[j]最小，现比较A[j]与A[i]，将会使最小元素排在前面，因此循环成立。

- c 循环不变式：A[1,..,i]已经排好序，元素位置不变；  
证明：  
初始化：当 i=1 时，数组只有一个元素，成立；  
保持：当 i+1 时，内层循环依次将最小，次最小。。。元素移动到该不变式数组中最后一个位置，即A[i]，因此该数组顺序不变；  
终止：循环终止条件为 i=A.length-1, 此时A[A.length]将会与A[A.length-1]比较大小，将整个数组排好序。  

- d Θ(n^2) 冒泡在内层移动元素位置要三次基本操作，而插入排序仅需一次基本操作，相对来说插入排序性能要好。

#### 2-3
