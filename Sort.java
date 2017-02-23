/*
*@author:lsry
*including some sorting methods for arrays
*/

import java.util.Arrays;
public class Sort
{
	public static int[] mergeSorting(int[] a,int first,int end){
		if (first<end)
		{
			int p = (first+end)/2;
			mergeSorting(a,first,p);
			mergeSorting(a,p+1,end);
			merge(a,first,p,end);
		}
		return a;
	}
	
	/**
	*将一个数组两个已排好序的部分重新排序
	*@param a 要排序的数组
	*@param p 数组首元素索引
	*@param q 数组中间元素索引 （p+r）/2
	*@param r 数组尾元素索引
	*/
	private static int[] merge(int[] a,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for (int x=0;x<n1 ;++x )
		{
			left[x] = a[p+x];
		}
		for (int x = 0;x<n2 ;x++ )
		{
			right[x] = a[q+1+x];
		}
		int i=0,j=0,k=p,m=0;
		m=(n1<=n2)?n1:n2;
		while(i<n1&&j<n2)
		{
			if (left[i]<=right[j])
			{
				a[k] = left[i];
				i++;
			}else{
				a[k] = right[j];
				j++;
			}
			k++;
		}
		if(i==n1)
		{
			while(j!=n2)
			{
				a[k]=right[j];
				k++;
				j++;
			}
		}
		if(j==n2)
		{
			while(i!=n1)
			{
				a[k]=left[i];
				k++;
				i++;
			}
		}
		return a;
	}

	public static void main(String[] args){
		int[] a = new int[]{9,8,7,6,5,4,3,2,1,0};
		mergeSorting(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
