public class LeetCode1052{
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int maxSatisfied = 0;
        for (int i = 0;i < customers.length && i < X;i++){
            maxSatisfied += customers[i];
        }       
        int left = 0;
        int right = X - 1;
        for (int i = X;i < customers.length;i++){
            if (grumpy[i] == 0){
                maxSatisfied += customers[i];
            } else {
                int last = maxSatisfied;
                for (int j = 0;j < i - right;j++){
                    if (grumpy[left + j] == 1){
                        last -= customers[left + j];
                    }               
                }    
                for (int j = right + 1;j <= i;j++){
                    if (grumpy[j] == 1){
                        last += customers[j];
                    }
                }            
                if (last > maxSatisfied){
                    maxSatisfied = last;
                    right = i;
                    left = right - X + 1;
                }
            }
        }
        return maxSatisfied;
    }
}