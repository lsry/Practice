public class RevNum 
{
     public static int RevNumbers(int[] a,int first,int end){
		if (first>=end)
		{
			return 0;
		}
		else if (first<end)
		{
			int p = (first+end)/2;
			return RevNumbers(a,first,p)+RevNumbers(a,p+1,end)+Reving(a,first,p,end);
		}
		return 0;
	}

    private static int Reving(int[] a,int p,int q,int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];

        int numbers = 0;//存放逆序对的个数
		//初始化两个数组，并将最后一个数置为无穷大
		for (int x=0;x<n1 ;++x )
		{
			left[x] = a[p+x];
		}
		left[n1]=Integer.MAX_VALUE;

		for (int x = 0;x<n2 ;x++ )
		{
			right[x] = a[q+1+x];
		}
        right[n2]=Integer.MAX_VALUE;

		int i=0,j=0,k=p;
		for(k=p;k<=r;k++)
		{
			if (left[i]<=right[j])
			{
				a[k] = left[i];
				i++;
			}else{
				a[k] = right[j];
				//如果左边数组元素大于右面某个数组元素，那么左边数组
				//包括该元素及后面的所有元素都大于右面数组元素
				//左边数组大于右面数组某个元素的个数即为本次循环逆序对的个数
				if (left[i] != Integer.MAX_VALUE)
				    numbers = numbers + n1 - i;
				j++;
			}
		}
		return numbers;
	}

	public static void main(String[] args) 
	{
		int[] a = new int[]{8,7,6,5,4,3,2,1,0};
		int c = RevNumbers(a,0,8);
		System.out.println(c);
	}
}
