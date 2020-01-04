import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode0870{
    // 超时
    public int[] advantageCountTime(int[] A, int[] B) {
        Arrays.sort(A);
        List<Integer> li = new LinkedList<>();
        for (int a : A){
            li.add(a);
        }
        for (int i = 0;i < B.length;i++){
            boolean flag = true;
            for (int j = 0;j < li.size();j++){
                if (li.get(j) > B[i]){
                    A[i] = li.remove(j);
                    flag = false;
                    break;
                }
            }
            if (flag){
                A[i] = li.remove(0);
            }
        }
        return A;
    }

    public int[] advantageCount(int[] A, int[] B) {
        int[] sa = Arrays.copyOf(A, A.length);
        int[] sb = Arrays.copyOf(B, B.length);
        Arrays.sort(sa);
        Arrays.sort(sb);

        Map<Integer,List<Integer>> mil = new HashMap<>();
        for (int b : B){
            mil.put(b, new LinkedList<>());
        }
        List<Integer> remainList = new LinkedList<>();
        int index = 0;
        for (int a : sa){
            if (a > sb[index]){
                mil.get(sb[index]).add(a);
                index++;
            } else {
                remainList.add(a);
            }
        }

        int[] ans = new int[A.length];
        for (int i = 0;i < B.length;i++){
            if (mil.get(B[i]).size() > 0){
                ans[i] = mil.get(B[i]).remove(0);
            } else {
                ans[i] = remainList.remove(0);
            }
        }

        return ans;
    }
}