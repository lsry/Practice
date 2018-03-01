public class NumSort
{
	/** 
	* 计数排序，利用0，。。。，k各个大小的数出现的个数
	* @param arr 待排序的数组
	* @param brr 结果数组
	* @param n 元素个数
	* @param k arr中出现的最大的数
	*/
    public static void countSort(int[] arr,int[] brr,int n,int k){
	    int[] crr = new int[k+1];
		for (int i = 0;i < k+1;i++)         //赋初值0
		{
			crr[i] = 0;
		}
		for (int i = 0;i < n;i++)          //计算0，。。。，k的个数
		{
			crr[arr[i]]++;
		}
		for (int i = 1;i < k+1;i++)        //计算对应的位置
		{
			crr[i] = crr[i] + crr[i-1];
		}
		for (int i = n-1;i >= 0;i--)
		{
			brr[crr[arr[i]]-1] = arr[i];  //crr[] 中最后一个数的大小是arr[]中数所在的位置，编号1,...,n,但是、
			                              //arr[],brr[]位置编号为 0,...,n-1
			crr[arr[i]]--;                //防止因为有相同元素而错位
		}
    }

    /** 
	* 输出arr[]在[a , b]的个数
	* @param arr 数组
	* @param n 元素个数
	* @param k arr中出现的最大的数
	* @param a b [a,b]左右端点值 
	*/
    public static int intervals(int[] arr,int n,int k,int a,int b){
	    int[] crr = new int[k+1];
		for (int i = 0;i < k+1;i++)         //赋初值0
		{
			crr[i] = 0;
		}
		for (int i = 0;i < n;i++)          //计算0，。。。，k的个数
		{
			crr[arr[i]]++;
		}
		int sum = 0;
		for (int i = a;i <= b;i++)
		{
            sum += crr[i];
		}
		return sum;
	}

	public static void display(int[] arr,int n){
	    for (int i = 0;i < n;i++)
	    {
			System.out.print(arr[i] + "\t");
	    }
        System.out.println();
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{2,5,1,4,2,3,0,1};
		int d = intervals(a,8,5,0,3);
		display(a,8);
        System.out.println(d);
	}
}
