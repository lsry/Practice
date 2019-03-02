public class ChooseSort
{
	public static void ChooseSort(int[] a){
    int n=a.length;
	  for (int i=0;i<n-1 ;i++ )
	  {
		  int key = a[i];
		  for (int j=i+1;j<n ;j++ )
		  {
		    if (key > a[j])
		    {
          int temp = a[j];
			    a[j] = key;
			    key = temp;
		    }
		  }
		  a[i] = key;
	  }
	}

	public static void ChooseSort2(int[] a){
		int n = a.length;
		for(int i = 0;i < n - 1;i++){
			int min = i;
			for(int j = i + 1;j < n;j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}

	public static void main(String[] args)
	{
	  int[] a = {0,4,2,6,8,2,7,5};
	  ChooseSort2(a);
	  for (int ai : a)
	  {
		  System.out.print(ai + " ");
	  }
	}
}
