public class OrdMaxSubArray
{
	/**
	*暴力求解最大子数组问题
	*T(n) = Θ(n^2)
	*@param arr 传入的数组
	*@param low 数组首元素索引
	*@param high 数组尾元素索引
	*/
    public static int[] findMaxSubArray(int[] arr,int low,int high){
	    int left = 0;    //数组左边索引
		int right = 0;    //数组右边索引
		int arr_sum = 0;  //最大子数组的和

		for (int i = low;i <= high;i++)
		{
			int sum = arr[i];
			if (sum > arr_sum)
			{
				arr_sum = sum;
				left = i;
				right = i;
			}
			for (int j = i+1;j<=high;j++)
			{
                sum += arr[j];
				if (sum > arr_sum)
				{
					arr_sum = sum;
					left = i;
					right = j;
				}
			}
		}

		return new int[]{left,right,arr_sum};
	}



	public static void main(String[] args) 
	{
		int[] arr = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,
			                  12,-5,-22,15,-4,7,10,34,90,-2,
			                  -5,-3,78,-21,-23,23,12,14,24,15,
			                  21,34,15,-21,12,-43,-56,-14,12,10};
		long start = System.currentTimeMillis();
		int[] result = findMaxSubArray(arr,0,39);
		long end = System.currentTimeMillis();
		System.out.println("left: " + result[0]);
		System.out.println("right: " + result[1]);
		System.out.println("sum: " + result[2]);
		System.out.println("Time: " + (end - start));

	}
}
