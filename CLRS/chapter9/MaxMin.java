public class MaxMin
{
	/** 
	* 普通求数组最大值
	*/
    public static int maxOrd(int[] arr){
	    int max = arr[0];
		for (int ar : arr)
	    {
			max = ar > max ? ar : max; 
	    }
		return max;
	}

    /** 
	* 普通求数组最小值
	*/
	public static int minOrd(int[] arr){
	    int min = arr[0];
		for (int ar : arr)
	    {
			min = ar > min ? min : ar; 
	    }
		return min;
	}

    /** 
	* 一起求数组最大和最小值 2n-2
	* 返回数组 [0] 最小值 [1] 最大值
	*/
	public static int[] minMaxOrd(int[] arr){
	    int[] nx = new int[2];
		nx[0] = arr[0];
		nx[1] = arr[0];
		for (int ar : arr)
	    {
			nx[0] = ar > nx[0] ? nx[0] : ar;
			nx[1] = ar > nx[1] ? ar : nx[1];
	    }
        return nx;
	}

    /** 
	* 一起求数组最大和最小值，比较次数少 3(n/2)
	* 返回数组 [0] 最小值 [1] 最大值
	*/
	public static int[] minMaxLesCom(int[] arr,int n){
	    int[] nx = new int[2];
		int i = 0;
		if (n % 2 == 0)             //偶数时取前两个值
		{
			i = 2;
			nx[0] = arr[0] > arr[1] ? arr[1] :arr[0];
			nx[1] = arr[0] > arr[1] ? arr[0] :arr[1];
		}else {                    //奇数时取第一个值
			i = 1;
		    nx[0] = arr[0];
			nx[1] = arr[0];
		}
		for (;i < n;i = i + 2)     //成对比较余下的元素
		{
            if (arr[i] > arr[i+1])
            {
				nx[0] = nx[0] > arr[i+1] ? arr[i+1] : nx[0];
				nx[1] = nx[1] > arr[i] ? nx[1] : arr[i];
            }else{
				nx[0] = nx[0] > arr[i] ? arr[i] : nx[0];
				nx[1] = nx[1] > arr[i+1] ? nx[1] : arr[i+1];
			}
		}
        return nx;
	}

	public static void main(String[] args) 
	{
		System.out.println("偶数： ");
		int[] a = new int[]{3,5,1,6,8,2};
		int n = minOrd(a);
		int x = maxOrd(a);
		System.out.println("n = " + n);
        System.out.println("x = " + x);
		int[] nx = minMaxOrd(a);
        System.out.println("nx[0] = " + nx[0]);
        System.out.println("nx[1] = " + nx[1]);
		nx = minMaxLesCom(a,6);
        System.out.println("nx[0] = " + nx[0]);
        System.out.println("nx[1] = " + nx[1]);

        System.out.println("奇数： ");
		int[] b = new int[]{3,5,1,6,8,2,9};
		nx = minMaxLesCom(b,7);
        System.out.println("nx[0] = " + nx[0]);
        System.out.println("nx[1] = " + nx[1]);
	}
}
