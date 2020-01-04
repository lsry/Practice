import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode1005{
    public int largestSumAfterKNegations(int[] A, int K) {
        List<Integer> neg = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : A){
            sum += i;
            if (i <= 0){
                neg.add(i);
            }
            if (i >= 0 && i < min){
                min = i;
            }
        }
        Collections.sort(neg);
        while (!neg.isEmpty() && K > 0){
            int pos = Math.abs(neg.remove(0));
            sum += 2 * pos;
            if (pos < min){
                min = pos;
            }
            K--;
        }
        while (K > 0){
            min = 0 - min;
            sum += 2 * min;
            K--;
        }
        return sum;
    }
}