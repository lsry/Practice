public class LeetCode0647{
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0){
            return 0;
        }
        int[][] arr = new int[s.length()][s.length()];
        for (int i = 0;i < s.length();i++){
            valiate(arr, s, i, i);
            valiate(arr, s, i, i+1);
        }
        int count = 0;
        for (int i = 0;i < s.length();i++){
            for(int j = 0;j < s.length();j++){
                if (arr[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public void valiate(int[][] arr,String s,int left,int right){
        if (left < 0 || right >= s.length() || arr[left][right] != 0){
            return ;
        }
        while (left >= 0 && right < s.length()){
            if (arr[left][right] == 1 || s.charAt(left) == s.charAt(right)){
                arr[left][right] = 1;
                left--;
                right++;
            } else {
                arr[left][right] = -1;
                break;
            }
        }
        while (left >= 0 && right < s.length()){
            arr[left][right] = -1;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        LeetCode0647 l647 = new LeetCode0647();
        System.out.println(l647.countSubstrings("aaa"));
        System.out.println(l647.countSubstrings("abc"));
    }
}