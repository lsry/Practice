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
		for (int j = p;j < q;j++){
			if (arr[j] <= pe){
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
	    if (p == r){
			return arr[p];
	    }
		int q = randomPartition(arr,p,r);
		int k = q - p + 1;                       //计算 arr[p,..,q]元素个数
		if (i == k){
			return arr[q];
		}
		else if (i < k){
			return randomSelected(arr,p,q-1,i);
		}
		else{                                   //假如落在大的区间，那么现在已经知道有k个小元素了 
		    return randomSelected(arr,q+1,r,i-k);
		}
	}

	/**
	* 第 i 小元素 循环版本 i = 1,2,...,n
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param r 数组尾元素索引
	*/
	public static int circleSelected(int[] arr,int p,int r,int i){
	    if (p == r){
			return arr[p];
	    }
		int q = randomPartition(arr,p,r);
		int k = q - p + 1;                       //计算 arr[p,..,q]元素个数
		while (k != i){                          //恰好前一部分有i个元素时，那么这部分arr[q] 为第i元素
			if (k < i){                          
				i = i - k;                       //当前一部分不够时，但前一部分已经有了前k个元素，那么只需要找第i-k即可
				p = q + 1;
			}else{                               //当前一部分比i要多时
			    r = q - 1;
			}
            q = randomPartition(arr,p,r);
			k = q - p + 1;
		}
		return arr[q];
	}

    /* 插入排序
	* @param arr 排序数组
	* @param p 数组首元素索引
	* @param r 数组尾元素索引
	*/
    public static void insertSort(int[] arr,int p,int q){
	    for (int i = p + 1;i <= q;i++)
	    {
            int key = arr[i];
			int j = i - 1;
			while (j >= p && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
	    }
	}

    /**
	* 快速排序划分子程序，根据元素x为主元，将前面q-p个元素分成两部分,前提是该数组中含有x
	* 1) p <= k <= i arr[k] <= x
	* 2) i+1 <= k <= j-1 arr[k] > x
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	* @param x 划分主元x 
	*/
    public static int partitionAcNum(int[] arr,int p,int q,int x){
		int i = p;
		while (arr[i] != x)             //找到 x 所在的位置
		{
			i++;
		}
		int d0 = arr[q];                // 将 x 与最后一个元素交换
		arr[q] = arr[i];
		arr[i] = d0;
		i = p - 1;
		for (int j = p;j < q;j++){
			if (arr[j] <= x){
				i++;
				int d = arr[j];
				arr[j] = arr[i];
				arr[i] = d;
			}
		}
		arr[q] = arr[i+1];
		arr[i+1] = x;
		return i+1;
	}

    /**
	* 第 i 小元素 最坏时间线性 i = 1,2,...,n
	* @param arr 需要排序的数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
	public static int linerSelected(int[] arr,int p, int q,int i){
	    int n = q - p + 1;                            //当前arr[p,...,q]数组个数
		if (n <= 1){                                 //只有一个元素时
			return arr[p];
		}
		int d = (n % 5 == 0) ? (n/5) : (n/5)+1;      // 总共有 n/5 个 5 元素的组
		int[] temp = new int[d];
		int le = p;
		for (int j = 0;j < d;j++)                    //对每一个组进行排序，然后得到每个组的中位数
		{
			if (le < q)
			{
				int ri = (le + 4) > q ? q : (le+4);
			    insertSort(arr,le,ri);
			    temp[j] = arr[(le+ri)/2];
			    le = le + 5;
			}
		}
		int x = linerSelected(temp,0,d-1,d/2);          //得到所有中位数的中位数
		int k = partitionAcNum(arr,p,q,x);              //以该中位数划分这个数组,得到该中位数在数组中的索引
		int k0 = k - p + 1;                             //小于或等于 x 的元素个数
        if (i == k0){
			return x;
        }else if (i > k0)
        {
            return linerSelected(arr,k+1,q,i-k0);
        }else{
		    return linerSelected(arr,p,k-1,i);
		}
	}

    /**
	* 找 k 分位数 with bugs
	* @param arr 数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
	public static void kthQuantities(int[] arr,int p,int q,int k){
	    int n = q - p + 1;            //数组长度
		if (k <= 1 || n/k == 0)
		{
			return;
		}
		int t = k / 2;               //求取第 k/2 个分位数
		System.out.println("t = "+t);
		int pos = (n%k == 0 ? n / k * t : (n/k+1)*t);   //第 k/2 个分位数对应的位置
		System.out.println("pos = "+pos);
		System.out.println(linerSelected(arr,p,q,pos));
		if (k % 2 == 0)
		{
            kthQuantities(arr,p,pos-2,t);
            kthQuantities(arr,pos,q,t+1);
		}else{
		    kthQuantities(arr,p,pos-2,t);
            kthQuantities(arr,pos,q,t);
		}
		
	}
    
	/**
	* 最接近中位数的k个元素  距离各异
	* @param arr 数组
	* @param p 数组首元素索引
	* @param q 数组尾元素索引
	*/
    public static void kCloseMedim(int[] arr,int n,int[] brr,int k){
	    int med = linerSelected(arr,0,n-1,n/2);              //求中位数
		int[] c = new int[n];
		for (int i = 0;i < n;i++)
		{
			c[i] = arr[i] > med ? arr[i] - med : med - arr[i];      //为每个元素到中位数的距离
		}
        int med1 = linerSelected(c,0,n-1,k);           //距离的中位数
		int j = 0;
		for (int i = 0;i < n;i++)
		{
			if (j >= k)
			{
				break;
			}
			if (0-med1 <= arr[i] - med && arr[i] - med <= med1)
			{
				brr[j] = arr[i];
                j++;
			}
		}
	}

   /**
	* 求两个有序数组的下中位数
	* @param arr brr 数组
	* @param p r 数组首元素索引
	* @param q s 数组尾元素索引
	*/
	public static int twoArraryMedim(int[] arr,int p, int q,int[] brr,int r,int s){
	    if (p+1 == q || r+1 == s){        //当每个数组仅剩下两个时，求其中位数
			if (arr[p] < brr[r])
			{
				return arr[q] < brr[r] ? arr[q] : brr[r];
			}else {
			    return arr[p] < brr[s] ? arr[p] : brr[s];
			}
	    }else{
			//求中间位置元素索引
			int x = (q + p + 1)/2;
			int y = (s + r + 1)/2;
			if ((q - p + 1)%2 == 0 || (s - r + 1)%2 == 0)      //若里面有偶数个元素
			{
				if (arr[x] == brr[y-1]){                       //一个求上中位数，另一个为下中位数
			        return arr[x];
			    }else if (arr[x] < brr[y-1]){
			        return twoArraryMedim(arr,x-1,q,brr,r,y);
			    }else {
			        return twoArraryMedim(arr,p,x,brr,y-1,s);
			    }
			}else {                                            //若里面有奇数个元素
				if (arr[x] == brr[y]){
			        return arr[x];
			    }else if (arr[x] < brr[y]){
			        return twoArraryMedim(arr,x,q,brr,r,y);
			    }else {
			        return twoArraryMedim(arr,p,x,brr,y,s);
			    }
			}
		}
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{1,100,200,300,400,500};
		int[] b = new int[]{5,8,205,304,392,505};
		System.out.println(twoArraryMedim(a,0,5,b,0,5));
		
	}
}
