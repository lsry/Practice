public class LeetCode0896 {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 1){
            return true;
        }
        boolean inc = true, de = true;
        for (int i = 1;i < A.length;i++){
            if (inc && A[i] < A[i - 1]){
                inc = false;
            }
            if (de && A[i] > A[i - 1]){
                de = false;
            }
            if (!inc && !de){
                break;
            }
        }
        return inc || de;
    }
}