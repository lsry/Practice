public class LeetCode0507{
    public boolean checkPerfectNumber(int num) {
        if (num <= 1){
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        int sum = 1;
        for (int i = 2;i <= sqrt;i++){
            if (num % i == 0){
                if (i == (num / i)){
                    sum += i;
                } else {
                    sum += (i + (num / i));
                }
            }
        }
        return num == sum;
    }
}