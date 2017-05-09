import java.util.Arrays;

public class MergeSort 
{
    /**
	*归并排序
	*@param a 排序的数组
	*@param first 数组首元素索引
	*@param end 数组尾元素索引
	*/
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
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];

		//初始化两个数组，并将最后一个数置为无穷大
		for (int x=0;x<n1 ;++x )
		{
			left[x] = a[p+x];
		}
		left[n1]=Integer.MAX_VALUE;

		for (int x = 0;x<n2 ;x++ )
		{
			right[x] = a[q+1+x];
		}
        right[n2]=Integer.MAX_VALUE;

		int i=0,j=0,k=p;
		for(k=p;k<=r;k++)
		{
			if (left[i]<=right[j])
			{
				a[k] = left[i];
				i++;
			}else{
				a[k] = right[j];
				j++;
			}
		}
		return a;
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{5,4,2,7,9,0,33,23,56};
		mergeSorting(a,0,8);
		System.out.println(Arrays.toString(a));
	}
}
