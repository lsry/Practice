import java.util.Scanner;

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

    /** 
	* 原址计数排序
	* @param arr 数组
	* @param n 元素个数
	* @param k arr中出现的最大的数 范围[1,...,k]
	*/
	public static void inPlaceCountSort(int[] arr,int n,int k){
		int[] crr = new int[k+1];
		for (int i = 0;i <= k;i++)         //赋初值0
		{
			crr[i] = 0;
		}
		for (int i = 0;i < n;i++)          //计算1，。。。，k的个数
		{
			crr[arr[i]]++;
		}
		for (int i = 1;i <= k;i++)        //计算对应的位置
		{
			crr[i] = crr[i] + crr[i-1];
		}
		for(int i=0;i!=n;++i){            //先把a数组全部变为0
            arr[i]=0;  
        } 
		for (int i = k;i > 0;i--)          //从最后一个k出发
		{
			while(crr[i]!=crr[i-1]){       //如果相等，则代表 i=k 这个数一个都没有 
                arr[crr[i]-1]=i;           //crr计算的是从1,..,n的位置，而arr从0开始
                crr[i]--;  
            }  
		}
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
		System.out.println("Input length：" );
		int length = 0;
		Scanner in = new Scanner(System.in);
		length = in.nextInt();
		System.out.println("Input range：" );
		int k = 4;
		k = in.nextInt();
		int[] a = new int[length];
		for (int i = 0;i < length;i++)          
		{
			a[i] = (int)(1 + k * Math.random());
		}
		display(a,length);
		inPlaceCountSort(a,length,k);
        display(a,length);

		int j = 0;
		System.out.println("Input times：" );
		j = in.nextInt();
		while (j >= 0)
		{
            for (int i = 0;i < length;i++)          
		    {
			    a[i] = (int)(1 + k * Math.random());
		    }
		    display(a,length);
		    inPlaceCountSort(a,length,k);
            display(a,length);
			j--;
            System.out.println();
		}
	}
}
