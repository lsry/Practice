import java.util.Arrays;

public class LeetCode0910{
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int differ = A[A.length - 1] - A[0];
        for (int i = 0;i < A.length - 1;i++){
            int low = Math.min(A[0] + K, A[i + 1] - K);
            int high = Math.max(A[A.length - 1] - K,A[i] + K);
            differ = Math.min(differ, high - low);
        }
        return differ;
    }
}