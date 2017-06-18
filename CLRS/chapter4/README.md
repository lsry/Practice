## Chapter 4  分治策略

### 4.1 最大子数组问题

#### 4.1-1

### 4.2 矩阵乘法的Strassen算法

### 4.3 用代入法求解递归式

#### 4.3-1
假设 T(n) <= cn^2  T(1) = c  
T(n) = c(n-1)^2 + n  
= cn^2 - 2cn + c +n  (T(1) = 1)  
= cn^2 - (2cn - c - n)  
<= cn^2  
2cn - c -n >= 0  
c >= n/(2n-1) = 1/2 (1+1/(2n-1)) = 1  
所以当 c >= 1 时，成立

#### 4.3-2
假设 T(n) ≤ clgn+1 T(1) = 1  
T(n) = clg(ceil(n/2))+1+1  
= clgn -clg2 +2  
= clgn - (clg2-1)  
<= clgn+1  
∴ clg2 -2 >= 0  
c >= 1/lg2 = 1  
当 n=1 T(1) = 1 = O(1)

#### 4.3-3
假设 T(n) >= cnlgn + 1  
T(n) = 2(cfloor(n/2)lg(floor(n/2))+1)+n  
= cnlg(floor(n/2)) + 2 + n  
= cnlgn -cn +2 + n  
= cnlgn+1 -(cn-1-n)     
≥ cnlgn+1  
∴ cn-1-n <= 0  
c <= (n+1)/n  c<=1
当 n=1 T(1) =1 = Ω(1)  

#### 4.3-4
假设 T(n) <= cnlgn+1

#### 4.3-5
假设 c1nlgn <= T(n) <= c2nlgn  
T(n) = c2ceil(n/2)lg(ceil(n/2)) + c2floor(n/2)lg(ceil(n/2)) + c3n  
= c2nlgn -c2n + c3n  
= c2nlgn -(c2-c3)n  
<= c2nlgn  
c2-c3>=0  c2 >= c3  
T(n) = O(nlgn)  
同理 T(n) = Ω(nlgn)

#### 4.3-6
假设当 n>17 T(n) <= c(n-17)lg(n-17)   
T(n) = c(n/2)lg(n/2)+n  
= cnlgn-cn+n  
= cnlgn-(c-1)n  
<= cnlgn  
c>=1 n>17 时 T(n) = O(nlgn)  

#### 4.3-7
1. T(n) <= cn^(log3(4))   
   T(n) = 4(c(n/3)^(log3(4))) + n   
    = cn^(log3(4)) -(-n) <= cn^(log3(4))  
    -n >= 0 不成立

2. 假设 T(n) <= c1n^(log3(4)) -c2n   
T(n) = 4(c1(n/3)^(log3(4))-c2(n/3)) + n  
= c1n^(log3(4)) - c2n - (1/3c2 - 1)n  
<= c1n^(log3(4)) - c2n   
1/3c2 - 1 >= 0 ->  c2>=3
T(1) = c1-c2 >= Θ(1)  
c1 >> c2 , c2 >= 3  T(n) = O(n^(log3(4)))   

#### 4.3-8
1. T(n) <= cn^2  
T(n) = 4c(n/2)^2 + n  
= cn^2 -(-n)  <= cn^2  
-n>=0 不成立   

2. 假设 T(n) <= c1n^2 - c2n  
T(n) = 4(c1(n/2)^2-c2n/2)+n  
= c1n^2-c2n-(c2-1)n  
<= c1n^2-c2n  
c2-1>=0  -> c2>=1
c1 >> c2 , c2>=1  T(n)=O(n^2)

#### 4.3-9  
令 m=logn -> n=2^m   
T(2^m) = 3T(2^(m/2)) + m   
令 S(m) = T(2^m)  
 S(m) = 3(m/2) + m  
 S(m) = O(m^(log2(3)))  

 证明 ： 假设 S(m) <= c1m^(log2(3)) - c2m
 得到 c1 >> c2 , c2>=2  

 T(n) = O(logn^(log2(3)))  

### 4.4 用递归树方法求解递归式

#### 4.4-1
![](img/441.png)  
层数：n/2^i=1  -> i = logn  每个节点： n(3/2)^i   
底层：3^(logn) = n^(log3) 个节点  
T(n) = Σ[n(3/2)^i] + Θ(n^(log3))  i=(0,...,logn-1)  
= n((3/2)^(logn-1)-1)/(3/2-1) + Θ(n^(log3))  
< 2n((3/2)^(logn)-1)) + Θ(n^(log3))  
= 2n^(log3) - 2 + Θ(n^(log3))   
= O(n^(log3))   

验证： T(n) <= cn^(log3) - dn  
T(n) = 3(c(n/2)^(log3)-dn/2) + n  
= cn^(log3) - dn - (d/2 - 1)n  
<= cn^(log3) - dn  
d/2 - 1 >=0 -> d >= 2  
c > d d>=2 T(n) = O(n^(log3))

#### 4.4-2
总共有（logn + 1) 层，每层一个节点为 (n^2/4^i)  
T(n) = n^2Σ(1/4)^i  i=(0,1,...,logn-1)  
= 4n^2/3 = O(n^2)  

checking:  T(n) <= cn^2  
T(n) = c(n/2)^2 + n^2  
= cn^2 - (3c/4 - 1)n^2 <= cn^2  
3c/4-1 >= 0  -> c>= 4/3  

#### 4.4-3
![](img/443.png)  
层数：n/2^i=1 -> i=logn   
每层代价：n2^i+2^(1-i)  
最底层：4^(logn) = n^2  
T(n) = nΣ(2^i) + 8Σ(2^i) + O(n^2)  i=(0,1,..,logn-1)  
= n^2 + 7n -8 + O(n^2)  
= O(n^2)  

checking: T(n) <= c(n-2)^2-d(n-2)  (n>=3)  
T(n) = 4(c(n/2)^2 - d(n/2)) + n  
= cn^2 - 2dn + n  
= cn^2 - dn - (d-1)n  
< cn^2 - dn  
d-1 >= 0 -->  d>=1
c> d  T(n) = O(n^2)

#### 4.4-4
T(n) = T(n-1) +1  
T(n-1) = T(n-2) +1  
......  
T(2) = T(1) +1  
T(n) = T(1) + n-1 = O(n)  

#### 4.4-5
最长 n 层
一 n
二 (3/2)n - 1  
三 (9/4)n - 7/2
...

T(n) < nΣ(3/2)^i  (i=0,1,...,n)  
= 2n(3/2)^n  
= O(n(3/2)^n)  

#### 4.4-6
  
