public class Select 
{
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
	* 第 i 小元素 随机化版本 i = 1,2,...,n
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param r 数组尾元素索引
	*/
	public static int randomSelected(int[] arr,int p,int r,int i){
	    if (p == r)
	    {
			return arr[p];
	    }
		int q = randomPartition(arr,p,r);
		int k = q - p + 1;                       //计算 arr[p,..,q]元素个数
		if (i == k)
		{
			return arr[q];
		}
		else if (i < k)
		{
			return randomSelected(arr,p,q-1,i);
		}
		else{                                   //假如落在大的区间，那么现在已经知道有k个小元素了 
		    return randomSelected(arr,q+1,r,i-k);
		}
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{3,6,2,8,1,4,9,10};
		for (int i = 0;i < 8;i++)
		{
			int t = randomSelected(a,0,7,i+1);
			System.out.println("第" + (i+1) + "小元素为" + t);
		}
	}
}
