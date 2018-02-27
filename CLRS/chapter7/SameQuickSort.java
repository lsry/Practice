import java.util.Arrays;

/**
* 针对相同元素值的快速排序
*/
public class SameQuickSort 
{
	/**
	* 交换数组两个位置中的值
	* @param arr 需要交换的数组
	* @param x 第一个数组元素索引
	* @param y 第二个数组尾元素索引
	*/
	public static void swap(int[] arr,int x,int y){
	    int d = arr[x];
		arr[x] = arr[y];
		arr[y] = d;
	}

    /**
	* 划分一个数组，形成三个部分，主元为数组第一个数
	* arr[p,...,i]是小于主元的部分，arr[i+1,...,s]是等于主元的部分，arr[s+1,...,r]是大于主元的部分
	* @param arr 需要划分的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	* 数组返回等于主元部分的左右索引
	*/
    public static int[] samePartition(int[] arr,int p,int r){
	    int x = arr[p];
		int i = p - 1;
		int s = p;
		for (int j = p + 1;j <= r;++j)
		{
			if (arr[j] < x)
			{
                swap(arr,s+1,j);
				swap(arr,i+1,s+1);
				i++;
				s++;
			}else if (arr[j] == x)
			{
				swap(arr,s+1,j);
				s++;
			}
		}
		return new int[]{i+1,s};
	}

	 /**
	* 快速排序划分子程序随机化版本
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
    public static int[] randomPartition(int[] arr,int p,int q){
	    int r = p + (int)((q - p)*Math.random());
		int temp = arr[p];
		arr[p] = arr[r];
		arr[r] = temp;
		return samePartition(arr,p,q);
	}

    /**
	* 快速排序
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
	public static void quickSort(int[] arr,int p,int q){
	    if (p < q)
	    {
			int[] r = randomPartition(arr,p,q);
			quickSort(arr,p,r[0]-1);
			quickSort(arr,r[1]+1,q);
	    }
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{10,9,8,7,6,5,4,3,2,10};
		int[] b = samePartition(a,0,9);
		System.out.println("b[0] = " + b[0] + "\t b[1] = " + b[1]);
		System.out.println(Arrays.toString(a));
		quickSort(a,0,9);
		System.out.println(Arrays.toString(a));
	}
}
