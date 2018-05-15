## Chapter 8  线性时间排序

### 8.1 排序算法的下界

#### 8.1-1
当输入的数据已经排序好，形成以下比较序列：1:2,2:3，。。。，n-1：n,此时形成最小深度 (n-1)   

#### 8.1-2
![812](img/812.gif)   

#### 8.1-3
要达到线性时间，则做的结果在决策树上应该在高度为n的位置。此时最多的叶子数最多有 2^n 个，总的叶子数有 n! 个；   
* 达到 1/2 , 因为![813](img/813a.gif) ,所以不存在。    
* 达到 1/n ，因为 lg(n-1)! > n -> 2^n/n! < 1/n  也不成立。    
* 达到 1/2^n , 因为 2^n/n! > 1/2^n ,所以存在。

#### 8.1-4
对于每一个子序列，总共有 k! 种输出，有 n/k 个子序列，也就总共有 (k!)^(n/k) 个输出情况，由 2^ >= (k!)^(n/k)     
所以： h >= (n/k)lg(k!) = Ω(nlgk)     

### 8.2 计数排序   

#### 8.2-1   
* A:{6,0,2,0,1,3,4,6,1,3,2} C:{2,2,2,3,1,0,2}      C:{2,4,6,8,9,9,11}  B{ , , , , , , , , , , }   
* B{ , , , , , 2 , , , , , }   C:{2,4,5,8,9,9,11}  
* B{ , , , , , 2 ,  , 3 , , , }   C:{2,4,5,7,9,9,11}  
* B{ , , , 1 , , 2 ,  , 3 , , , }   C:{2,3,5,7,9,9,11}  
* B{ , , , 1 , , 2 ,  , 3 , , , 6 }   C:{2,3,5,7,9,9,10}  
* B{ , , , 1 , , 2 ,  , 3 , 4 , , 6 }   C:{2,3,5,7,8,9,10}
* B{ , , , 1 , , 2 , 3  , 3 , 4 , , 6 }   C:{2,3,5,6,8,9,10}
* B{ , , 1 , 1 , , 2 , 3  , 3 , 4 , , 6 }   C:{2,2,5,6,8,9,10}
* B{ , 0 , 1 , 1 , , 2 , 3  , 3 , 4 , , 6 }   C:{1,2,5,6,8,9,10}
* B{ , 0 , 1 , 1 , 2 , 2 , 3  , 3 , 4 , , 6 }   C:{1,2,4 ,6,8,9,10}    
* B{ 0 , 0 , 1 , 1 , 2 , 2 , 3  , 3 , 4 , 6 , 6 }   C:{0,2,4 ,6,8,9,9}    

#### 8.2-2   
根据第10 ~ 12行，C计算出现的个数，对应于A中在正确序列上的位置，在统计完后,C中的数较大，当从数组最后一个开始填入，对于相同的元素，位于较后的填入大的位置上，因而是稳定的。    

#### 8.2-3   
证明：  
* 当j = 0，B 数组为空，相当于元素已经到了合适的位置 ；  
* 当前面 j 个元素已经在B中到了合适的位置，第 j+1 个元素的位置有两种情况: 1) 之前没有出现过相同元素，那么B[C[A[j+1]]]为空，是对应A[j+1]的合适位置，2) 出现过相同元素，那么由于第一次出现时 C[A[j']] = C[A[j']] - 1 ，所以B[C[A[j+1]]]为空，是对应A[j+1]的合适位置；   
* 当终止时，所有元素都到了合适的位置，因而算法正确。   
* 由于 j = j + 1,所以前面的元素位于后面的位置，所以不稳定。   

#### 8.2-4 [intervals](NumSort.java)   

### 8.3 基数排序  

#### 8.3-1

|0|1|2|3|    
|-|-|-|-|   
|COW|SEA|TAB|BAR|
|DOG|TEA|BAR|BIG|
|SEA|MOB|EAR|BOX|
|RUG|TAB|TAR|COW|
|ROW|DOG|SEA|DIG|
|MOB|RUG|TEA|DOG|
|BOX|DIG|DIG|EAR|
|TAB|BIG|BIG|FOX|
|BAR|BAR|MOB|MOB|
|EAR|EAR|DOG|NOW|
|TAR|TAR|COW|ROW|
|DIG|COW|ROW|RUG|
|BIG|ROW|NOW|SEA|
|TEA|NOW|BOX|TAB|
|NOW|BOX|FOX|TAR|
|FOX|FOX|RUG|TEA|  

#### 8.3-2  
* 稳定的：插入排序，归并排序   
* 不稳定：堆排序，快速排序   
* 稳定方法：记录下相同元素的相对位置，在排序完成后，再根据此记录数据重新排序，空间为O(n)   

#### 8.3-3
证明：假设当前排序第t位，前t-1位都已经排序完成，开始第t位排序时有以下两种情况：  
1) 当第t位相同时，不需要改变位置，这里需要排序算法稳定；  
2) 当第t位不同时，排序完成后，会移动到合适的地方，完成排序；       

当最后一位完成后，整个序列已经有序。      

#### 8.3-4     
以n进制，则最多需要log_n{n^3-1} = 2位n进制数，即最多需要两轮，对每一轮进行排序，k = n,所以总的时间为 O(2(n+n)) = O(4n)   

#### 8.3-5  
需要d轮排序；纪录10堆

### 8.4 桶排序   

#### 8.4-1  
0 :      
1 : 0.13 -> 0.16    
2 : 0.20     
3 : 0.39   
4 : 0.42   
5 : 0.53   
6 : 0.64   
7 : 0.71 -> 0.79       
8 : 0.89   
9 :           

#### 8.4-2   
* 最坏情况：当恰好落入一个桶中时      
- 将第8行改为O(nlgn)的算法即可     

#### 8.4-3      
|X = |0|1|2|
|-|-|-|-|  
|P = |1/4|1/2|1/4|      

E[x] = 1  
E[x^2] = 1 * 1/2 + 4 * 1/4 = 3/2     
E^2[X] = 1       

#### 8.4-4      
设定n个桶，每一个点落入到对应桶中所对应的面积应该为总面积的1/n，由于概率与d有关，因此将圆分成n个环，每个环的面积为 pi/n, 所以第i个环半径为 sqrt(1/n) .   

    SORT(A)
      n = A.length
      let B[0,...,n-1] be a new array
      for i = 0 to n-1
        make B[i] be a empty list
      for i = 1 to n
        let k = A[i].x^2 + A[i].y^2
        insert A[i] to B[k/n]   
      for i = 0 to n-1
        sort B[i]    
      contact the list B[0],...,B[n-1]   

#### 8.4-5    
在 n * O(1) = O(n) 时间内找到，然后利用桶排序，得到时间为 O(n)      

    SORT(A)
    n = A.length
    let B[0,...,n-1] be a new array
    for i = 0 to n-1
      make B[i] be a empty list
    k = (max(A) - min(A))/n  
    for i = 1 to n
      insert A[i] to B[k * (A[i] - min(A))]  
    for i = 0 to n-1
      sort B[i]    
    contact the list B[0],...,B[n-1]    

### 思考题

#### 8-1  
**a.** 证明：对于n个互异的元素的输入，总共有 n! 种情况，在决策树的叶结点处完成排序，因此这 n! 种情况对应 n! 个叶结点，由于每种情况的概率相同，所以这 n! 个叶结点每个标有 1/n!,对于其它的叶结点标有 0  。  

**b.** 证明：   
D(T) = ∑左边叶结点深度 + ∑右边叶结点深度  = D(LT)+D(RT)+k  

**c.** 证明：对与一棵有 k 个叶结点的树，叶结点可能分布在左右子树上，另外叶结点不可能单独在一棵子树上，因为假设在一颗子树上，必然会比在两颗子树上深度多1，然后左子树上的叶结点树可能情况有 i = {1,...,k-1},依次代入 **b.** 式子比较，即为最小值 min{d{i} + d{k-i} + k}    

**d.**   
令 f(i) = ilgi + (k-i)lg(k-i)    
f'(i) = lgi - lg(k-i) = 0   
i = k/2   
f(k/2) = k(lgk-1)  
d(k) = Ω(klgk)    

**e.** 对于一个决策树，有 n! 个叶结点，代入 **d** 得：  
D(T) = Ω(n!lgn!)     
对于每一个叶结点所用的期望时间为 1/n! * Ω(n!lgn!) = Ω(nlgn)  

**f.** 确定的排序算法A包含了 n! 种所有的情况，而B只是多了随机的一步，也包含在这 n! 种情况之中，其期望比较次数不会比A所有的之一少。  

#### 8-2
**a.** 计数排序即可   

**b.**     

    SORT(A)   
    n = A.length   
    j = n
    i = 1  
    while i < n && i < j
      if A[i] == 1
        while A[j] != 0 && j > i  
          j = j - 1
        exchange A[i] and A[j]
        i = i + 1   

**c.** 插入排序即可   

**d.**   
a 显然可以   
b 不稳定  
c 时间为O(n^2)    

**e.**  [inPlaceCountSort，但是不稳定](NumSort.java)

#### 8-3    
**a.** 基数排序用一下。  

**b.** 使用基数排序，从左边第一位开始排序，直到最大字符串长度，当当前比较位数超过字符串长度后，用特殊字符代替，表示不参与排序过程。  

#### 8-4  
**a.**    

    match(R,B)  //R:红水壶，B：蓝水壶   
    for j = 1 to n   
      for i = 1 to n   
        if R[j] match B[i]   
          match i,j
          break

**b.**  同比较决策树，每个节点有匹配或不匹配，总共有 n! 个输出，则：n! <= 2^h -> h = Ω(nlgn)    

**c.**   
+ 利用快速排序的思想，在两个比较时，假设当前红色选择为X，在蓝色中找X的同时，将大于X的放在一边，小于X的放在一边，接下来选择第二个红色，如果大于X，在大的蓝色中找，小于X在小的蓝色中找，同时找的过程将蓝色分成两堆，加下来与此类推；         
+ 感觉利用数组，如果不移动元素位置，没法达到O(nlgn)        

#### 8-5  
**a.**  sorted   

**b.** 1,3,2,4,5,7,6,8,10,9    

**c.**  ![85c](img/85c.gif)         

**d.**

    SORT(A)
    for i = 1 to k
      对A[i],A[i+k],...,A[i+n-k-1]实行O(nlgn)的排序算法    

T(n) = O(k * (n/k) * lg(n/k)) = O(nlg(n/k))    

**e.**   

    SORT(A)
    以A[1],...,A[k] 构造一个最小堆
    B[1,..,n] be a new array
    for i = 1 to n
      x = 堆的第一个元素在A中的索引
      B[i] = 堆的第一个元素
      将对应位置 x+k 元素填入到第一个
      维护堆的性质   

T(n) = O(nlgk)    

**f.**    
要排序的总共有 k 组数，每组 n/k 个元素   
2^h >= k * lg(n/k)!  = k * (n/k) * lg(n/k) = Ω(nlgn)   

#### 8-6   
**a.** 2n 中选 n 个   

**b.**    
![86b](img/86b.gif)     

**c.** 假设 x 和 y 在有序序列中连续，且 x < y，且没有比较过，则当 x 被选出来前， 此时比较的两个元素为 x 和 z,且 z != y，z 来自与x不同的表,z 在 y 前，那么当选与 x 不同的表时，z 必然比 y 先选出来，则 x 和 y 在有序序列中不连续，矛盾。    

**d.** 不妨当有两个表 A 和 B , 当比较次数最多时，元素依次从A, B中轮流取出来，总的比较次数为 2n-1    

#### 8-7    
**a.** 由定义当A[q] > A[p] -> B[q] = 1， A[p] <= A[p] -> B[p] = 0.   

**b.**        
证明：由于A[p]是放错位置的最小元素，现假设仅有A[p]与A[q]位置是错的，则A[q] >= A[p] , q < p；  

+ 当A[q]=A[p]时，1 <= i <= q, B[i] = 0, q+1 <= i <p-1 ,B[i] = 1, i = p , B[i] = 0,i > p , B[i] = 1 此时B没有排序 ；

+ 当A[q]=A[p]时，1 <= i < q, B[i] = 0, q <= i <p-1 ,B[i] = 1, i = p , B[i] = 0,i > p , B[i] = 1 此时B没有排序 ；

所以当A中存在两个元素A[p]，A[q]未排序成功时，A[p] < A[q+1,...,p-1], 则 B[p] < B[q+1,...,p-1] ,B 不能排序成功。        

**c.** 在每次偶数步操作的过程中，并没有依赖奇数步排序所操作的结果，只是对矩阵中元素的位置进行了移动。

**d.** 证明：    

**e.**   

**f.**   

**g.**   

**h.**    