public class Search 
{
	/* 二分查找递归算法
	* @parm A 已经排序好的数组
	* @parm p q 查找数组首尾元素索引
	* @parm v 要查找的值
	*/
    public static int twoSearch(int[] A,int p,int q,int v){
		int r = p+(q-p)/2;
		if(p>q)
			return -1;
		if (p<=q)
		{
			if (A[r]==v)
				return r;
			else if (A[r]>v)
				return twoSearch(A,p,r-1,v);
			else
				return twoSearch(A,r+1,q,v);
		}
		return -1;
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{1,2,3,4,6,7,8,9,10};
		System.out.println(twoSearch(a,0,8,4));
	}
}
