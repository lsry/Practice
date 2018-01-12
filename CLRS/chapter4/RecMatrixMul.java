public class RecMatrixMul 
{
	/**
	* 递归求解矩阵乘法，时间复杂度θ（n^3)
	* T(n) = 8T(n/2) + θ(n^2)
	*/

	/**
    * 辅助矩阵加法
	* @param A[][] 左矩阵A
	* @param B[][] 右矩阵B
	* @param n 矩阵维度
	* @param C[][] 结果矩阵C
	* @param a 矩阵C的列首值
	* @param b 矩阵C的行首值
	*/
	private static void addMatrix(int[][] A,int n,int[][] B,int[][] C,int a,int b){
		int b1 = b;
	    for (int i = 0 ; i < n ; i++ )
	    {
			for (int j = 0; j < n ; j++ )
			{
				C[a][b1] = A[i][j] + B[i][j];
				b1++;
			}
			a++;
			b1 = b;
	    }
	} 

    /**
	* 矩阵乘法
	* @param A[][] 左矩阵A
	* @param a 矩阵A的列首值
	* @param b 矩阵A的行首值
	* @param B[][] 右矩阵B
	* @param e 矩阵B的列首值
	* @param f 矩阵B的行首值
	* @param C[][] 结果矩阵C
	* @param i 矩阵C的列首值
	* @param j 矩阵C的行首值
	*/
    public static boolean mulMatrixRec(int[][] A,int a,int b,int n,
		                     int[][] B,int e,int f,
		                     int[][] C,int i,int j){
	    if (n == 1)   //只有一个元素的时候                           
	    {
			C[i][j] = A[a][b] * B[e][f];
			return true;
	    }
		else{
		    int t = n / 2;    //将矩阵分4块，并形成临时矩阵
			int[][] D = new int[t][t];
			int[][] E = new int[t][t];

			mulMatrixRec(A,a,b,t,B,e,f,D,0,0);        //C11 = A11 * B11 + A12 * B21
			mulMatrixRec(A,a,b+t,t,B,e+t,f,E,0,0);
			addMatrix(D,t,E,C,i,j);

			mulMatrixRec(A,a,b,t,B,e,f+t,D,0,0);      //C12 = A11 * B12 + A12 * B22
			mulMatrixRec(A,a,b+t,t,B,e+t,f+t,E,0,0);
			addMatrix(D,t,E,C,i,j+t);

			mulMatrixRec(A,a+t,b,t,B,e,f,D,0,0);      //C21 = A21 * B11 + A22 * B21
			mulMatrixRec(A,a+t,b+t,t,B,e+t,f,E,0,0);
			addMatrix(D,t,E,C,i+t,j);

			mulMatrixRec(A,a+t,b,t,B,e,f+t,D,0,0);    //C22 = A21 * B12 + A22 * B22
			mulMatrixRec(A,a+t,b+t,t,B,e+t,f+t,E,0,0);
			addMatrix(D,t,E,C,i+t,j+t);

			return true;
		}
	}

	public static void main(String[] args) 
	{
		int in = 4;
        int[][] A = new int[in][in];
        int[][] B = new int[in][in];
		int[][] C = new int[in][in];
		for (int i = 0; i< in ; i++ )
        {
			for (int j = 0 ; j < in ; j++ )
			{
                A[i][j] = (int)(Math.random()*5);
				B[i][j] = (int)(Math.random()*5);
				C[i][j] = 0;
			}
        }
		
        mulMatrixRec(A,0,0,in,B,0,0,C,0,0);

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

