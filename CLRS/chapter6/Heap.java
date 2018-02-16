public class Heap
{
    private final static int ARRAY_LENGTH = 50;       //可容纳元素数
	private int heap_size;                            //已经容纳元素数
	private int[] heapArray;                          //存放堆的空间

    /*
	* @param arr[] 传入的数组
	* @param n 数组长度
	*/
	public Heap(int arr[],int n){
		heapArray = new int[ARRAY_LENGTH];
		heap_size = n;
		for (int i = 0;(i < n)&&(i < ARRAY_LENGTH) ;i++)
		{
			heapArray[i] = arr[i];
		}
	}

   /*
	* 获得父元素索引
	* @param in 需要确定元素位置的索引
	*/
    public int parantIndex(int in){
		double x = in/2.0+0.5;
		int d = (int)x - 1;
	    return d;
	}
    
	/*
	* 获得左孩子元素索引
	* @param in 需要确定元素位置的索引
	*/
	public int leftChildIndex(int in){
		return in * 2 + 1;
	}

    /*
	* 获得右孩子元素索引
	* @param in 需要确定元素位置的索引
	*/
	public int rightChildIndex(int in){
	    return in * 2 + 2;
	}

    /*
	* 递归版本使第in元素维护最大堆的性质
	* @param in 需要确定元素位置的索引
	*/
    public void maxHeapify(int in){
	    int left = leftChildIndex(in);
		int right = rightChildIndex(in);
		int largest = in;
		if ((left < heap_size)&&(heapArray[left] > heapArray[largest]))
		{
			largest = left;
		}
		if ((right < heap_size)&&(heapArray[right] > heapArray[largest]))
		{
			largest = right;
		}
		if (largest != in)
		{
			int temp = heapArray[in];
			heapArray[in] = heapArray[largest];
			heapArray[largest] = temp;
			maxHeapify(largest);
		}
	}

    /*
	* 循环版本使第in元素维护最大堆的性质
	* @param in 需要确定元素位置的索引
	*/
    public void maxHeapifyNotRec(int in){
	    int left = leftChildIndex(in);
		int right = rightChildIndex(in);
		int largest = in;
		while ((left < heap_size)&&(heapArray[left] > heapArray[largest])||(right < heap_size)&&(heapArray[right] > heapArray[largest]))
		{
			int inn = largest;
			if ((left < heap_size)&&(heapArray[left] > heapArray[largest]))
		    {
			    largest = left;
		    }
			if ((right < heap_size)&&(heapArray[right] > heapArray[largest]))
		    {
			    largest = right;
		    }
			if (largest != inn)
		    {
			    int temp = heapArray[inn];
			    heapArray[inn] = heapArray[largest];
			    heapArray[largest] = temp;
				left = leftChildIndex(largest);
		        right = rightChildIndex(largest);
		    } 
		}
	}
    
	/*
	* 构建最大堆
	*/
    public void buildMaxHeap(){
	    for (int i = (heap_size-1)/2;i >= 0;i--)
	    {
            maxHeapifyNotRec(i);
	    }
	}

    /*
	* 堆排序算法
	*/
	public void heapSort(){
	    buildMaxHeap();
		int heapSize = heap_size;
		for (int i = heap_size-1;i>0;i--)
		{
			int temp = heapArray[0];
			heapArray[0] = heapArray[i];
			heapArray[i] = temp;
			heap_size--;
            maxHeapifyNotRec(0);
		}
		heap_size = heapSize;
	}

    /*
	* 显示当前堆中的所有元素
	*/
	public void display(){
	    for (int i = 0;i < heap_size ;i++)
	    {
			System.out.print(heapArray[i] + "\t");
	    }
		System.out.println();
	}




	public static void main(String[] args) 
	{
		int arr[] = new int[]{4,2,5,7,9,2,1,8};
		Heap he = new Heap(arr,8);
		he.display();
		he.heapSort();
		he.display();
	}
}
