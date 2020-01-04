public class SetMatrixZeroes{

    public  void setZeroes(int[][] matrix) {
        if (matrix.length <= 0){
            return;
        }

        boolean rowFlag = false;
        boolean colFlag = false;

        for (int r = 0;r < matrix.length;r++){
            if (matrix[r][0] == 0){
                rowFlag = true;
                break;
            }
        }
        for (int c = 0;c < matrix[0].length;c++){
            if (matrix[0][c] == 0){
                colFlag = true;
                break;
            }
        }

        for (int r = 1;r < matrix.length;r++){
            for (int c = 1;c < matrix[1].length;c++){
                if (matrix[r][c] == 0){
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1;r < matrix.length;r++){
            if (matrix[r][0] == 0){
                for (int c = 0;c < matrix[0].length;c++){
                    matrix[r][c] = 0;
                }
            }
        }
        for (int c = 1;c < matrix[0].length;c++){
            if (matrix[0][c] == 0){
                for (int r = 0;r < matrix.length;r++){
                    matrix[r][c] = 0;
                }
            }
        }

        if (colFlag){
            for (int c = 0;c < matrix[0].length;c++){
                matrix[0][c] = 0;
            }
        }

        if (rowFlag){
            for (int r = 0;r < matrix.length;r++){
                matrix[r][0] = 0;
            }
        }

        System.out.print(rowFlag + "\t" + colFlag + "\n");
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,0,3}};
        new SetMatrixZeroes().setZeroes(arr);
        for (int[] ar : arr){
            for (int a : ar){
                System.out.print(a + "\t");
            }
            System.out.println();
        }
    } 
}