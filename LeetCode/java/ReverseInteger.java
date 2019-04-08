public class ReverseInteger{

    public String stringReverse(String s){
        char[] array = s.toCharArray();  
        String reverse = ""; 
        int i = array.length - 1;
        while (array[i] == '0'){
            i--;
        } 
        for (; i >= 0; i--) {
            reverse += array[i];  
        }   
        return reverse;  
    }

    public int reverse(int x) {
        if (x == 0){
            return 0;
        }
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
    }
}