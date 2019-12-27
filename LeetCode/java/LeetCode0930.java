import java.util.HashMap;
import java.util.Map;

public class LeetCode0930{
    public int numSubarraysWithSum(int[] A, int S) {
        int N = A.length;
        int[] p = new int[N + 1];
        for (int i = 0;i < N;++i) {
            p[i + 1] = p[i] + A[i];
        }
        Map<Integer,Integer> presum = new HashMap<>();
        int ans = 0;
        for (int x : p) {
            ans += presum.getOrDefault(x, 0);
            presum.put(x + S, presum.getOrDefault(x + S, 0) + 1);
        }
        return ans;
    }
}