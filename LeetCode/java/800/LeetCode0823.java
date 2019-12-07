import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode0823{
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        Arrays.sort(A);
        Map<Integer,Long> ma = new HashMap<>();
        ma.put(A[0], 1L);
        for (int i = 1;i < A.length;i++){
            long temp = 1L;
            for (int j = i - 1;j >= 0;j--){
                if (A[i] % A[j] == 0){
                    int tarKey = A[i] / A[j];
                    if (ma.containsKey(tarKey)){
                        temp += ma.get(A[j]) * ma.get(tarKey);
                    }
                }
            }
            ma.put(A[i], temp);
        }
        long result = 0L;
        for (Map.Entry<Integer,Long> entry : ma.entrySet()){
            result += entry.getValue();
        }
        return (int)(result % MOD);
    }
}