public class LeetCode0058{
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return (arr.length > 0) ? arr[arr.length - 1].length() : 0;
    }
}