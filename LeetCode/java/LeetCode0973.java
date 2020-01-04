import java.util.Arrays;

public class LeetCode0973 {

    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        Arrays.sort(points,(x,y) -> {
            return (x[0] * x[0] + x[1] * x[1]) - (y[0] * y[0] + y[1] * y[1]);
        });
        for (int i = 0;i < K;i++){
            result[i][0] = points[i][0];
            result[i][1] = points[i][1];
        }
        return result;
    }
}