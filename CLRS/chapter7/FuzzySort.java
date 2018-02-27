/**
* 针对模糊区间的快速排序
* arr[] 区间左端点的值
* brr[] 区间右端点的值
*/

public class FuzzySort 
{
    /**
	* 交换两个数组对应位置中的值
	* @param arr brr 需要交换的数组
	* @param x 第一个数组元素索引
	* @param y 第二个数组元素索引
	*/
	public static void swap(int[] arr,int[] brr,int x,int y){
	    int d = arr[x];
		int e = brr[x];
		arr[x] = arr[y];
		brr[x] = brr[y];
		arr[y] = d;
		brr[y] = e;
	}

    /**
	* 划分一个数组，形成三个部分，主区间为数组第一个区间，将有重叠的部分看做相同的区间
	* 区间[arr[p] brr[p]],...,[arr[i] brr[i]]是小于区间的部分，
	* 区间[arr[i+1] brr[i+1]],...,[arr[s] brr[s]]是与主区间重叠的部分，
	* 区间[arr[s+1] brr[s+1],...,[arr[r] brr[r]]是大于主区间的部分
	* @param arr brr 需要划分的数组 
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	* 数组返回等于主元部分的左右索引
	*/
    public static int[] fuzzyPartition(int[] arr,int[] brr,int p,int r){
	    int x = arr[p];
		int y = brr[p];
		int i = p - 1;
		int s = p;
		for (int j = p + 1;j <= r;++j)
		{
			if (brr[j] < x)
			{
                swap(arr,brr,s+1,j);
				swap(arr,brr,i+1,s+1);
				i++;
				s++;
			}else if ((arr[j] > x && arr[j] < y)||(brr[j] > x && brr[j] < y))
			{
				swap(arr,brr,s+1,j);
				s++;
			}
		}
		return new int[]{i+1,s};
	}

    /**
	* 快速排序划分子程序随机化版本
	* @param arr brr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
    public static int[] randomPartition(int[] arr,int[] brr,int p,int q){
	    int r = p + (int)((q - p)*Math.random());
		swap(arr,brr,p,r);
		return fuzzyPartition(arr,brr,p,q);
	}

	/**
	* 快速排序
	* @param arr brr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
	public static void fuzzySort(int[] arr,int[] brr,int p,int q){
	    if (p < q)
	    {
			int[] r = randomPartition(arr,brr,p,q);
			fuzzySort(arr,brr,p,r[0]-1);
			fuzzySort(arr,brr,r[1]+1,q);
	    }
	}

    /**
	* 输出区间
	* @param arr brr 区间左右端点数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
	public static void display(int[] arr,int[] brr,int x,int y){
	    for (int i = x;i <= y;i++)
	    {
			System.out.print("["+arr[i]+"  "+brr[i]+"]\t");
	    }
		System.out.println();
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{3,5,1,7,4};
		int[] b = new int[]{4,6,3,8,6};
		fuzzySort(a,b,0,4);
		display(a,b,0,4);
	}
}
