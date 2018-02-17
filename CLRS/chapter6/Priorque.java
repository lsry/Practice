public class Priorque extends Heap
{
    public Priorque(int[] arr,int n){
	    super(arr,n);
		buildMaxHeap();
	}

    /*
	* 返回最大元素
	*/
    public int getMaxMum(){
	    return heapArray[0];
	}

    /*
	* 返回最大元素并删除最大元素
	*/
    public int extraMaxMum(){
	    int max = heapArray[0];
		heapArray[0] = heapArray[heap_size-1];
        heap_size--;
		maxHeapify(0);
		return max;
	}

	/*
	* 增大第index位置元素，并调节到合适的位置
	* @param index 需增大的元素位置
	* @param key 要增大的值
	*/
	public void increase(int index,int key){
	    if (heapArray[index] >= key)
	    {
			return;
	    }
		else{
		    heapArray[index] = key;
			int i = index;
			while (i > 0 && heapArray[parantIndex(i)] < heapArray[i])
			{
				int pi = parantIndex(i);
			    int temp = heapArray[i];
				heapArray[i] = heapArray[pi];
				heapArray[pi] = temp;
                i = pi;
			}
		}
	}

    /*
	* 在优先队列中插入一个元素
	* @param key 要插入的元素值
	*/
    public void insert(int key){
	    heap_size++;
		heapArray[heap_size-1] = Integer.MIN_VALUE;
		increase(heap_size-1,key);
	}

	public static void main(String[] args) 
	{
		int[] ar = new int[]{1,2,3,14,25,21,78};
		Priorque pq = new Priorque(ar,7);
		pq.display();
		System.out.println(pq.getMaxMum());
		System.out.println(pq.extraMaxMum());
		pq.display();
		pq.increase(5,80);
		pq.display();
		pq.insert(36);
		pq.display();
	}
}
