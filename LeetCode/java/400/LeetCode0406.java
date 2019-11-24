import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0406{
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1,p2) -> {
            if (p1[0] != p2[0]){
                return p2[0] - p1[0];
            } else {
                return p1[1] - p2[1];
            }
        });
        List<int[]> arrList = new LinkedList<>();
        for (int[] ar : people){
            arrList.add(ar[1], ar);
        }
        return arrList.toArray(new int[arrList.size()][2]);
    }
}