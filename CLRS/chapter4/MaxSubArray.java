import java.util.Scanner;
public class MaxSubArray 
{
	/**
	*最大子数组问题( T(n) = Θ(nlgn) )
	*@param arr 传入的数组
	*@param low 数组首元素索引
	*@param high 数组尾元素索引
	*/
	public static int[] findMaxSubArray(int[] arr,int low,int high){
        if (low == high)
            return new int[]{low,high,arr[low]};
		else{
		    int mid = low + (high - low)/2;
			int[] left_arr = findMaxSubArray(arr,low,mid);
			int[] right_arr = findMaxSubArray(arr,mid+1,high);
			int[] cross_arr = findCrossMaxSubArray(arr,low,mid,high);
			if (left_arr[2] > right_arr[2] && left_arr[2] > cross_arr[2])
			    return left_arr;
			else if (right_arr[2] > left_arr[2] && right_arr[2] > cross_arr[2])
			    return right_arr;
			else
				return cross_arr;
		}
    }

    /**
	*求横跨中间元素的最大子数组
	*@param arr 要排序的数组
	*@param low 数组首元素索引
	*@param mid 数组中间元素索引
	*@param high 数组尾元素索引
	*/
    private static int[] findCrossMaxSubArray(int[] arr,int low,int mid,int high){
	    
		//求中间元素左边的最大子数组和及左边索引值
		int left_sum = Integer.MIN_VALUE;  //左边元素值的和
		int sum = 0;
		int left = 0;    //左边索引值
		for (int i = mid;i >= low;--i)
		{
			sum += arr[i];
			if (sum > left_sum)
			{
				left_sum = sum;
                left = i;
			}
		}

		//求中间元素右边的最大子数组和及右边索引值
		int right_sum = Integer.MIN_VALUE;     //右边元素值的和
		sum = 0;
		int right = 0;    //右边索引值
		for (int i = mid + 1;i<=high;++i)
		{
			sum += arr[i];
			if (sum > right_sum)
			{
				right_sum = sum;
				right = i;
			}
		}
		return new int[]{left,right,left_sum + right_sum};
	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0;i<n;i++)
		{
			arr[i] = (int)(Math.random()*100-50);
		}
		long start = System.currentTimeMillis();
		int[] result = findMaxSubArray(arr,0,n-1);
		long end = System.currentTimeMillis();
		System.out.println("left: " + result[0]);
		System.out.println("right: " + result[1]);
		System.out.println("sum: " + result[2]);
		System.out.println("Time: " + (end - start));
	}
}
