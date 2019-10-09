public class LeetCode0978{
    public int maxTurbulenceSize(int[] A) {
        return helper(A,0,A.length-1);
    }

    public int helper(int[] A,int head,int tail){
        if (head == tail || (head + 1 == tail && A[head] == A[tail])){
            return 1;
        } else if (head + 1 == tail){
            return 2;
        }
        int next = head + 1;
        while (next < tail){
            int f = A[next - 1];
            int m = A[next];
            int b = A[next + 1];
            if ((f < m && m > b) || (f > m && m < b)){
                next++;
            } else {
                break;
            }
        }
        if (next == tail){
            return tail - head + 1;
        } else {
            int left = helper(A,head,next);
            int right = helper(A,next,tail);
            return left > right ? left : right;
        }
    }
}