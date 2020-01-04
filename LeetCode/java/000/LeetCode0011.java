public class LeetCode0011{
    public int getMin(int a,int b){
        return (a < b) ? a : b;
    }
    /**
     * 区域的面积限制因素：宽度，较小的高度
     * 首先考虑最宽的情况得到面积；
     * 然后考虑依次减 1 缩小宽度，对于左边还是右边缩小取决于左边和右边的高度
     * 在保留最高那一边的情况下，则有可能获得较大的面积，因此移动较小高度的那一边
     */
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j){
            int cur_area = (j - i) * getMin(height[i],height[j]);
            if (cur_area > area){
                area = cur_area;
            }
            if (height[i] > height[j]){
                j--;
            } else {
                i++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        LeetCode0011 lone = new LeetCode0011();
        System.out.println(lone.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}