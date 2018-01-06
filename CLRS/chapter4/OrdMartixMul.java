public class OrdMartixMul  
{
	/**
	*普通矩阵乘法，时间复杂度θ(n^3)
	* @parm A[m][n] 左矩阵A
	* @parm B[n][p] 右矩阵B
	*/
	public static int[][] martixMul(int A[][],int m,int n,int B[][],int p){
	    int[][] C = new int[m][p];
        for (int i = 0; i< m ; i++ )
        {
			for (int j = 0 ; j < p ; j++ )
			{
                C[i][j] = 0;
				for (int k = 0 ; k < n ; k++ )
				{
					C[i][j] += A[i][k] * B[k][j]; 
				}
			}
        }
		return C;
	}
	public static void main(String[] args) 
	{
		int in = 4;
        int[][] A  = new int[in][in];
        int[][] B  = new int[in][in];
		for (int i = 0; i< in ; i++ )
        {
			for (int j = 0 ; j < in ; j++ )
			{
                A[i][j] = (int)(Math.random()*5);
				B[i][j] = (int)(Math.random()*5);
			}
        }
		int[][] C = martixMul(A,in,in,B,in);
		System.out.println("A: ");
		for (int i = 0; i< in ; i++ )
        {
			for (int j = 0 ; j < in ; j++ )
			{
               System.out.print(A[i][j] + "\t");
			}
			System.out.println();
        }
        System.out.println();
		System.out.println("B: ");
		for (int i = 0; i< in ; i++ )
        {
			for (int j = 0 ; j < in ; j++ )
			{
               System.out.print(B[i][j] + "\t");
			}
			System.out.println();
        }
        System.out.println();
		System.out.println("C: ");
		for (int i = 0; i< in ; i++ )
        {
			for (int j = 0 ; j < in ; j++ )
			{
               System.out.print(C[i][j] + "\t");
			}
			System.out.println();
        }
        System.out.println();
	}
}
