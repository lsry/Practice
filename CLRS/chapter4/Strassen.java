public class Strassen 
{
	/**
	* Strassen矩阵乘法，时间复杂度θ（n^lg7)
	* T(n) = 7T(n/2) + θ(n^2)
	*/

	/**
    * 辅助矩阵加减法
	* @param A[][] 左矩阵A
	* @param a 矩阵C的列首值
	* @param b 矩阵C的行首值
	* @param B[][] 右矩阵B
	* @param c 矩阵B的列首值
	* @param d 矩阵B的行首值
	* @param C[][] 结果矩阵C
	* @param n 矩阵维度
	* @param s '+' 矩阵加 '-' 矩阵减
	*/
	private static void addMatrix(int[][] A,int a,int b,int[][] B,int c,int d,int[][] C,int n,char s){
	    for (int i = 0 ; i < n ; i++ )
	    {
			for (int j = 0; j < n ; j++ )
			{
				if (s == '+')
				{
					C[i][j] = A[a + i][b + j] + B[c + i][d + j];
				}
				else if (s == '-')
				{
					C[i][j] = A[a + i][b + j] - B[c + i][d + j];
				}
				else{}
			}
	    }
	} 

     /**
	* 矩阵乘法
	* @param A[][] 左矩阵A
	* @param a 矩阵A的列首值
	* @param b 矩阵A的行首值
	* @param B[][] 右矩阵B
	* @param c 矩阵B的列首值
	* @param d 矩阵B的行首值
	* @param C[][] 结果矩阵C
	* @param e 矩阵C的列首值
	* @param f 矩阵C的行首值
	* @param n 矩阵维数
	*/
    public static void matrixStrassen(int[][] A,int a,int b,
		                     int[][] B,int c,int d,
		                     int[][] C,int e,int f,int n){
	     if (n == 1)   //只有一个元素的时候                           
	    {
			C[e][f] = A[a][b] * B[c][d];
	    }else{
		    int t = n / 2;

            int[][] s1 = new int[t][t];             // s1 = B12 - B22
			addMatrix(B,c,d+t,B,c+t,d+t,s1,t,'-');

			int[][] s2 = new int[t][t];             // s2 = A11 + A12
            addMatrix(A,a,b,A,a,b+t,s2,t,'+');

			int[][] s3 = new int[t][t];             // s3 = A21 + A22
			addMatrix(A,a+t,b,A,a+t,b+t,s3,t,'+');

			int[][] s4 = new int[t][t];             // s4 = B21 - B11
			addMatrix(B,c+t,d,B,c,d,s4,t,'-');

			int[][] s5 = new int[t][t];             // s5 = A11 + A22
			addMatrix(A,a,b,A,a+t,b+t,s5,t,'+');

			int[][] s6 = new int[t][t];             // s6 = B11 + B22
			addMatrix(B,c,d,B,c+t,d+t,s6,t,'+');

			int[][] s7 = new int[t][t];             // s7 = A12 - A22
			addMatrix(A,a,b+t,A,a+t,b+t,s7,t,'-');

			int[][] s8 = new int[t][t];             // s8 = B21 + B22
			addMatrix(B,c+t,d,B,c+t,d+t,s8,t,'+');

			int[][] s9 = new int[t][t];             // s9 = A11 - A21 
			addMatrix(A,a,b,A,a+t,b,s9,t,'-');

			int[][] s10 = new int[t][t];            // s10 = B11 + B12
			addMatrix(B,c,d,B,c,d+t,s10,t,'+');

            int[][] p1 = new int[t][t];             // p1 = A11 * s1
            matrixStrassen(A,a,b,s1,0,0,p1,0,0,t);

			int[][] p2 = new int[t][t];             // p2 = s2 * B22
			matrixStrassen(s2,0,0,B,c+t,d+t,p2,0,0,t);

			int[][] p3 = new int[t][t];             // p3 = s3 * B11
			matrixStrassen(s3,0,0,B,c,d,p3,0,0,t);

			int[][] p4 = new int[t][t];             // p4 = A22 * s4
		    matrixStrassen(A,a+t,b+t,s4,0,0,p4,0,0,t);

			int[][] p5 = new int[t][t];             // p5 = s5 * s6
			matrixStrassen(s5,0,0,s6,0,0,p5,0,0,t);

			int[][] p6 = new int[t][t];             // p6 = s7 * s8
			matrixStrassen(s7,0,0,s8,0,0,p6,0,0,t);

			int[][] p7 = new int[t][t];             // p7 = s9 * s10
			matrixStrassen(s9,0,0,s10,0,0,p7,0,0,t);

			for (int x = 0; x < t ; x++)
			{
				for (int y = 0; y < t ; y++)
				{
					// C11 = p5 + p4 - p2 + p6
					C[e+x][f+y] = p5[x][y] + p4[x][y] - p2[x][y] + p6[x][y];

					// C12 = p1 + p2
					C[e+x][f+t+y] = p1[x][y] + p2[x][y];

					// C21 = p3 + p4
					C[e+t+x][f+y] = p3[x][y] + p4[x][y];

					// C22 = p5 + p1 - p3 - p7
					C[e+t+x][f+t+y] = p5[x][y] + p1[x][y] - p3[x][y] - p7[x][y];
				}
			}
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
		
        matrixStrassen(A,0,0,B,0,0,C,0,0,in);

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
