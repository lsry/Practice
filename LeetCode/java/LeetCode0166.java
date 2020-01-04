import java.util.HashMap;
import java.util.Map;

public class LeetCode0166{
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        int div = numerator / denominator;
        int mod = numerator % denominator;
        if (mod == 0) {
            return String.valueOf(div);
        }
        StringBuilder sBuilder = new StringBuilder();
        long m = (mod > 0) ? mod : (-1 * mod);
        int d = denominator;
        boolean flag = false;
        Map<Long,Integer> mi = new HashMap<>();
        int index = 0;
        while (m > 0) {
            if (mi.containsKey(m)){
                flag = true;
                break;
            }
            mi.put(m, index);
            m = m * 10;
            sBuilder.append(Math.abs(m / d));
            m = m % d;
            index++;
        }
        String res = "";
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            res = "-";
        }
        res += String.valueOf(Math.abs(div));
        if (flag) {
            return res + "." + sBuilder.substring(0, mi.get(m)) 
            + "(" + sBuilder.substring(mi.get(m)) + ")";
        } else {
            return res + "." + sBuilder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("-5 / -3 = " + (-5 / -3));
        System.out.println("-5 % -3 = " + (-5 % -3));
        System.out.println("-5 / 3 = " + (-5 / 3));
        System.out.println("-5 % 3 = " + (-5 % 3));
        System.out.println("7 / -12 = " + (7 / -12));
        System.out.println("7 % -12 = " + (7 % -12));
    }
}