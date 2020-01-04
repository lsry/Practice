public class LeetCode0832{
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0;i < A.length;i++){
            int left = 0;
            int right = A[0].length - 1;
            while (left < right){
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
                left++;
                right--;
            }
        }
        for (int i = 0;i < A.length;i++){
            for (int j = 0;j < A[0].length;j++){
                if (A[i][j] == 1){
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        return A;
    }
}