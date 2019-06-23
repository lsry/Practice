public class LeetCode0013{
    public int romanToInt(String s) {
        int n = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == 'M'){
                n += 1000;
            } else if (s.charAt(i) == 'C'){
                n += 100;
                if (i + 1 < s.length()){
                    if (s.charAt(i+1) == 'M'){
                        n += 800;
                        i++;
                    } else if (s.charAt(i+1) == 'D'){
                        n += 300;
                        i++;
                    }
                } 
            } else if (s.charAt(i) == 'X'){
                n += 10;
                if (i + 1 < s.length()){
                    if (s.charAt(i+1) == 'C'){
                        n += 80;
                        i++;
                    } else if (s.charAt(i+1) == 'L'){
                        n += 30;
                        i++;
                    } 
                } 
            } else if (s.charAt(i) == 'I'){
                n += 1;
                if (i + 1 < s.length()){
                    if (s.charAt(i+1) == 'X'){
                        n += 8;
                        i++;
                    } else if (s.charAt(i+1) == 'V'){
                        n += 3;
                        i++;
                    } 
                } 
            } else if (s.charAt(i) == 'D'){
                n += 500;
            } else if (s.charAt(i) == 'L'){
                n += 50;
            } else {
                n += 5;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        LeetCode0013 l13 = new LeetCode0013();
        System.out.println("III: 3\t" + l13.romanToInt("III"));
        System.out.println("IV: 4\t" + l13.romanToInt("IV"));
        System.out.println("IX: 9\t" + l13.romanToInt("IX"));
        System.out.println("LVIII: 58\t" + l13.romanToInt("LVIII"));
        System.out.println("MCMXCIV: 1994\t" + l13.romanToInt("MCMXCIV"));
        System.out.println("MCCXLII: 1242\t" + l13.romanToInt("MCCXLII"));
    }
}