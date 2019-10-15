public class LeetCode0433{
    private boolean[] visited;
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0){
            return -1;
        }
        visited = new boolean[bank.length];
        return helper(start,end,bank,0);
    }

    public int helper(String start, String end, String[] bank,int steps){
        if (start.equals(end)){
            return steps;
        }
        if (steps > bank.length){
            return -1;
        }
        int minStep = bank.length + 1;
        for (int i = 0;i < bank.length;i++){
            if (!visited[i] && getDistance(start, bank[i]) == 1){
                visited[i] = true;
                int cur = helper(bank[i], end, bank, steps+1);
                if (cur != -1 && cur < minStep){
                    minStep = cur;
                }
                visited[i] = false;
            }
        }
        return (minStep == bank.length + 1) ? -1 : minStep;
    }

    public int getDistance(String s1,String s2){
        int distance = 0;
        for (int i = 0;i < s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                distance++;
            }
        }
        return distance;
    }
}