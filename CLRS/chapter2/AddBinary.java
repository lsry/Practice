public class  AddBinary
{
	public static void addBin(int[] a,int[] b){
		int i,n,key;
		n=a.length;
		key=0;
		int[] c = new int[n+1];
		for(int cv:c)
			cv=0;
		for (i=n-1;i>=0 ; i--)
		{
			c[i+1]=(a[i]+b[i]+key)%2;
			//if((a[i]&key|b[i]&key|a[i]&b[i])==1)
			//	key=1;   //加法器原理 利用位运算
			key=(a[i]+b[i]+key)/2;
			System.out.println(c[i+1]);
		}
		c[0]=key;
		for(int cv:c)
			System.out.print(cv);
		System.out.println();
	}
	public static void main(String[] args)
	{
		int[] a={0,1,1,0};
		int[] b={1,1,1,0};
		addBin(a,b);
	}
}
