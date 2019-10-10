public class LeetCode0012{
    /**
     * 按位处理，根据每个数位判断
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int n = num;
        int digit = n / 1000;
        // 处理千位
        for (int i = 0;i < digit;i++){
            sb.append('M');
        }
        // 处理百位
        n = n - digit * 1000;
        digit = n / 100;
        if (digit == 9){
            sb.append("CM");
        } else if (digit >= 5 && digit < 9){
            sb.append('D');
            for (int i = 0;i < digit - 5;i++){
                sb.append('C');
            }
        } else if (digit == 4){
            sb.append("CD");
        } else {
            for (int i = 0;i < digit;i++){
                sb.append('C');
            }
        }
        // 处理十位
        n = n - digit * 100;
        digit = n / 10;
        if (digit == 9){
            sb.append("XC");
        } else if (digit >= 5 && digit < 9){
            sb.append('L');
            for (int i = 0;i < digit - 5;i++){
                sb.append('X');
            }
        } else if (digit == 4){
            sb.append("XL");
        } else {
            for (int i = 0;i < digit;i++){
                sb.append('X');
            }
        }
        // 处理个位
        n = n - digit * 10;
        digit = n;
        if (digit == 9){
            sb.append("IX");
        } else if (digit >= 5 && digit < 9){
            sb.append('V');
            for (int i = 0;i < digit - 5;i++){
                sb.append('I');
            }
        } else if (digit == 4){
            sb.append("IV");
        } else {
            for (int i = 0;i < digit;i++){
                sb.append('I');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LeetCode0012 l12 = new LeetCode0012();
        System.out.println("3: III,\t" + l12.intToRoman(3));
        System.out.println("4: IV,\t" + l12.intToRoman(4));
        System.out.println("9: IX,\t" + l12.intToRoman(9));
        System.out.println("1994: MCMXCIV,\t" + l12.intToRoman(1994));
    }
}