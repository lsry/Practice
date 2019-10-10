import java.util.*;

public class LeetCode0040{

    public HashSet<List<Integer>> combine(int[] candidates,int target,int index){
        HashSet<List<Integer>> lli = new HashSet<>();
        if (target > 0){
            for (int i = index;i < candidates.length;i++){
                if (target - candidates[i] == 0){
                    List<Integer> li = new ArrayList<>();
                    li.add(candidates[i]);
                    lli.add(li);
                } else if (target - candidates[i] > 0){
                    HashSet<List<Integer>> temp = combine(candidates, target - candidates[i],i + 1);
                    if (temp.size() > 0){
                        for (List<Integer> li : temp){
                            li.add(candidates[i]);
                            Collections.sort(li);
                            lli.add(li);
                        }
                    }
                }
            }
        } 
        return lli;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lli = new ArrayList<>();
        HashSet<List<Integer>> hli = combine(candidates, target, 0);
        for (List<Integer> li : hli){            
            lli.add(li);
        }       
        return lli;
    }
}