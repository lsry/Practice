import java.util.Arrays;

public class LeetCode0955{
    public int minDeletionSize(String[] A) {
        String[] cur = new String[A.length];
        int deleteCount = 0;
        for (int i = 0;i < A[0].length();i++){
            String[] temp = Arrays.copyOf(cur, A.length);
            for (int j = 0;j < A.length;j++){
                temp[j] += A[j].charAt(i);
            }
            if (isSorted(temp)){
                cur = temp;
            } else {
                deleteCount++;
            }
        }
        return deleteCount;
    }

    public boolean isSorted(String[] arr) {
       for (int i = 0;i < arr.length - 1;i++){
           if (arr[i].compareTo(arr[i + 1]) > 0){
               return false;
           }
       }
       return true;
    }
}