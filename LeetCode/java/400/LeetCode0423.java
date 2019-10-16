public class LeetCode0423{
    public String originalDigits(String s) {
        int[] chars = new int[26 + 'a'];
        for (char ch : s.toCharArray()){
            chars[ch]++;
        }
        int[] num = new int[10];
        num[0] = chars['z'];
        num[1] = chars['o'] - chars['z'] - chars['w'] - chars['u'];
        num[2] = chars['w'];
        num[3] = chars['r'] - chars['z'] - chars['u'];
        num[4] = chars['u'];
        num[5] = chars['f'] - chars['u'];
        num[6] = chars['x'];
        num[7] = chars['s'] - chars['x'];
        num[8] = chars['g'];
        num[9] = chars['i'] - (chars['f'] - chars['u']) - chars['x'] - chars['g'];
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 10;i++){
            for (int j = 0;j < num[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}