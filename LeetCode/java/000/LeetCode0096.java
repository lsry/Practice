public class LeetCode0096{
    /**
     * 对于数 1,..n ，不同的数如 i 作为根时，两边含有 1,..,i-1 和 i+1,...,n 分别计算两边个数，相乘即可
     */
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2;i < n+1;i++){
            arr[i] = -1;
        }
        return halfCount(arr, n);
    }

    public int halfCount(int[] arr,int x){
        if (arr[x] != -1){
            return arr[x];
        } else {
            int count = 0;
            for (int i = 1;i <= x;i++){
                int left = i - 1;
                int right = x - i;
                count += halfCount(arr, left) * halfCount(arr, right);
            }
            arr[x] = count;
            return arr[x];
        }
    }
}