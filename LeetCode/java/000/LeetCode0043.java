public class LeetCode0043{
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String maxStr = num1;
        String minStr = num2;
        if (num1.length() < num2.length()){
            maxStr = num2;
            minStr = num1;
        }
        String[] arr = new String[10];
        arr[1] = maxStr;
        String res = "";
        for (int i = 0;i < minStr.length();i++){
            char ch = minStr.charAt(i);
            if (ch == '0'){
                res = res + '0';
            } else {
                if (arr[ch - '0'] == null || arr[ch - '0'].length() <= 0){
                    arr[ch - '0'] = mulSingle(maxStr, ch-'0');
                }
                if (i > 0){
                    res = res + '0';
                }
                res = add(res,arr[ch-'0']);
            }
        }
        return res;
    }

    public String mulSingle(String num,int x){
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1;i >= 0;i--){
            int product = (num.charAt(i) - '0') * x + carry;
            res.append(product % 10);
            carry = product / 10;
        }
        if (carry > 0){
            res.append(carry);
        }
        return res.reverse().toString();
    }

    public String add(String num1,String num2){
        String maxStr = num1;
        String minStr = num2;
        if (num1.length() < num2.length()){
            maxStr = num2;
            minStr = num1;
        }
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int diff = maxStr.length() - minStr.length();
        int i = maxStr.length() - 1;
        while (i - diff >= 0){
            int sum = maxStr.charAt(i) - '0' + minStr.charAt(i - diff) - '0' + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
        }
        while (i >= 0){
            int sum = maxStr.charAt(i) - '0' + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
        }
        if (carry > 0){
            res.append(carry);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode0043 l43 = new LeetCode0043();
        System.out.println(l43.add("156", "244").equals("400"));
        System.out.println(l43.add("1568", "9412").equals("10980"));
        System.out.println(l43.mulSingle("423", 5).equals("2115"));
        System.out.println(l43.multiply("234", "257").equals("60138"));
        System.out.println(l43.multiply("234", "1").equals("234"));
        System.out.println(l43.multiply("234", "1000").equals("234000"));
    }
}