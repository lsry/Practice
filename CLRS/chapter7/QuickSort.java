import java.util.Arrays;

public class QuickSort  
{
	/**
	* 快速排序
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
	public static void quickSort(int[] arr,int p,int q){
	    if (p < q)
	    {
			int r = hoarePartition(arr,p,q);
			quickSort(arr,p,r-1);
			quickSort(arr,r+1,q);
	    }
	}

    /**
	* 快速排序划分子程序，以最后一个元素x为主元，将前面q-p个元素分成两部分
	* 1) p <= k <= i arr[k] <= x
	* 2) i+1 <= k <= j-1 arr[k] > x
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
	public static int partition(int[] arr,int p,int q){
	    int pe = arr[q];
		int i = p - 1;
		for (int j = p;j < q;j++)
		{
			if (arr[j] <= pe)
			{
				i++;
				int d = arr[j];
				arr[j] = arr[i];
				arr[i] = d;
			}
		}
		arr[q] = arr[i+1];
		arr[i+1] = pe;
		return i + 1;
	}

    /**
	* 快速排序划分子程序随机化版本
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
    public static int randomPartition(int[] arr,int p,int q){
	    int r = p + (int)((q - p)*Math.random());
		int temp = arr[q];
		arr[q] = arr[r];
		arr[r] = temp;
		return partition(arr,p,q);
	}

	/**
	* 快速排序划分子程序Hoare版本
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
	public static int hoarePartition(int[] arr,int p,int q){
	    int x = arr[p];
		int i = p - 1;
		int j = q + 1;
		while (true)
		{
			do
			{
				j--;
			}
			while (arr[j] > x);
			do
			{
				i++;
			}
			while (arr[i] < x);
			if (i < j)
			{
				int d = arr[j];
				arr[j] = arr[i];
				arr[i] = d;
				System.out.println("i = "+i);
			}
			else{
				return j;
			}
		}
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{13,19,9,5,12,8,7,4,11,2,6,21};
		quickSort(a,0,11);
		System.out.println(Arrays.toString(a));
		int[] b = new int[]{1,1,1,1,1};
		System.out.println(partition(b,0,4));
	}
}
