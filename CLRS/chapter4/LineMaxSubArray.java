public class LineMaxSubArray 
{
	/**
	*线性时间求解最大子数组问题
	*T(n) = Θ(n)
	*@param arr 传入的数组
	*@param low 数组首元素索引
	*@param high 数组尾元素索引
	*/
	public static int[] findMaxSubArray(int[] arr, int low,int high){
	    int left = 0;          //left:最大子数组左边索引
		int right = 0;         //right:最大子数组右边索引
		int msum = -100;       //msum:最大子数组的和   建议初始值应该比数组的最小值要小，如果全是负数，否则会发生错误
		int cur = 0;           //cur:子数组的和为正值时的左边索引值（可能的最大子数组的左边索引值）
		int sum = 0;           //sum:以此计算子数组和
        for (int i = 0;i <= high;i++)
        {
            sum += arr[i];
			if (sum > msum)    //当求得当前arr[0,...,i-1]的最大子数组后，遇到的下一个为正数
			{
				msum = sum;
				left = cur;
				right = i;
			}
			                   //也可能下一个为负数，若和不小于零，则不用做任何事
			if (sum < 0)  //遇到负数并且小于零，则最大子数组不可能以负值开头   这里不应该是else if ，否则某些情况下会有未知错误
			{
				sum = 0;
				cur = i+1;
			}
        }

		return new int[]{left,right,msum};
	}
	
	
	public static void main(String[] args) 
	{
		int[] array = new int[]{-3,-2,-1,-2,-3};
		int[] result = findMaxSubArray(array,0,4);
		System.out.println("left: " + result[0]);
		System.out.println("right: " + result[1]);
		System.out.println("sum: " + result[2]);
	}
}
