public class LeetCode0860{
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        for (int bill : bills){
            if (bill == 5){
                money[0] ++;
            } else if (bill == 10){
                if (money[0] <= 0){
                    return false;
                } else {
                    money[0]--;
                    money[1]++;
                }
            } else {
                if (money[0] > 0 && money[1] > 0){
                    money[0]--;
                    money[1]--;
                    money[2]++;
                } else if (money[0] >= 3){
                    money[0] -= 3;
                    money[2] ++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0860 l = new LeetCode0860();
        l.lemonadeChange(new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5});
    }
}