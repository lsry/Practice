public class ReverseInteger{

    /**
     * 将字符串翻转
     */
    public String stringReverse(String s){
        char[] array = s.toCharArray();  
        StringBuilder reverse = new StringBuilder(); 
        int i = array.length - 1;
        // 将末尾 0 消除，因为翻转过来不算整数的一部分
        while (array[i] == '0'){
            i--;
        } 
        for (; i >= 0; i--) {
            reverse.append(array[i]);  
        }   
        return reverse.toString();  
    }

    public int reverse(int x) {
        if (x == 0){
            return 0;
        }
        // 负数标志
        boolean isPos = false;
        String num = String.valueOf(x);
        String res = "";
        if (x < 0){
            isPos = true;
            res = stringReverse(num.substring(1));
        } else {
            res = stringReverse(num);
        }
        try {
            if (isPos){
                return Integer.valueOf("-" + res);
            } else {
                return Integer.valueOf(res);
            }
        } catch (Exception e) {
            return 0;
        }
        
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
        System.out.println(new ReverseInteger().reverse(37890));
        System.out.println(new ReverseInteger().reverse(-12987));
        System.out.println(Integer.valueOf("000200"));
    }
}