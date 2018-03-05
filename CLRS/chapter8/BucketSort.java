import java.util.ArrayList;
import java.util.Scanner;

public class BucketSort  
{
	/**
	* 桶排序
	* @param arr 要排序的数组
	* @param n 数组长度
	*/
    public static void bucketSort(Double[] arr,int n){
	    ArrayList<ArrayList<Double>> brr = new ArrayList<ArrayList<Double>>();
		for (int i = 0;i < n;i++)
		{
			brr.add(new ArrayList<Double>());
		}
		//将数组中的每一个数填入到合适的桶中
		for (int i = 0;i < n;i++)
		{
			int k = (int)(n * arr[i]);
			brr.get(k).add(arr[i]);
		}
		//依次对每一个链表进行排序，使用插入排序算法
		for (ArrayList<Double> br : brr)
		{
			int size = br.size();
			for (int a = 1;a < size;a++)
			{
				Double key = br.get(a);
				int b = a -1;
				while (b >= 0 && br.get(b) > key)
				{
					br.set(b+1,br.get(b));
					b = b - 1;
				}
				br.set(b+1,key);
			}
		}
		//将排序完后的数据重新填回原数组中
		int in = 0;
		for (ArrayList<Double> br : brr){
		    for (Double dd : br){
			    if (in < n)
			    {
					arr[in] = dd;
				    in++;
			    }
			}
		}

	}

	public static void main(String[] args) 
	{
		int n = 0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		Double[] a = new Double[n];
		for (int i = 0;i < n;i++){
		    a[i] = Math.random();
		}
		bucketSort(a,n);
		for (Double d : a)
		{
			System.out.print(d + "\t");
		}
		System.out.println();
	}
}
