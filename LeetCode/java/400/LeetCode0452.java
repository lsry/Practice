import java.util.Arrays;

public class LeetCode0452{
    public int findMinArrowShots(int[][] points) {
        // 1. 按照左端点排序
        Arrays.sort(points, (a,b) -> {
            return a[0] - b[0];
        });
        int arrows = 0;
        int index = 0;
        while (index < points.length){
            arrows++;
            // 2. 每一支箭可能范围 [left,MIN(right)]
            int end = points[index][1];
            while (index < points.length && points[index][0] <= end){
                if (points[index][1] < end){
                    end = points[index][1];
                }
                index++;
            }
        }
        return arrows;
    }
}