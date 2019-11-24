import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode1125 {
    /**
     * BFS
     * Time Limit Exceeded 
     */
    public int[] smallestSufficientTeamBFS(String[] req_skills, List<List<String>> people) {
        Map<String,Integer> skills = new HashMap<>();
        for (int i = 0;i < req_skills.length;i++){
            skills.put(req_skills[i], 1 << i);
        }
        List<Integer> peoples = new ArrayList<>(people.size());
        for (List<String> ls : people){
            int skill = 0;
            for (String s : ls){
                skill |= skills.get(s);
            }
            peoples.add(skill);
        }
        List<Set<Integer>> select = new ArrayList<>();
        for (int i = 0;i < peoples.size();i++){
            int skill = skills.get(req_skills[0]);
            if ((peoples.get(i) & skill) == skill){
                Set<Integer> si = new HashSet<>();
                si.add(i);
                select.add(si);
            }
        }
        for (int i = 1;i < req_skills.length;i++){
            int skill = skills.get(req_skills[i]);
            Iterator<Set<Integer>> is = select.iterator();
            List<Set<Integer>> temp = new ArrayList<>();
            while (is.hasNext()){
                Set<Integer> si = is.next();
                if (!containSkill(si, skill, peoples)){
                    for (int j = 0;j < peoples.size();j++){
                        if (!si.contains(j) && ((peoples.get(j) & skill) == skill)){
                            Set<Integer> sj = new HashSet<>(si);
                            sj.add(j);
                            temp.add(sj);
                        }
                    }
                    is.remove();
                } else {
                    temp.add(si);
                }
            }
            select = temp;
        }
        Set<Integer> si = select.get(0);
        for (Set<Integer> sii : select){
            if (sii.size() < si.size()){
                si = sii;
            }
        }
        int[] res = new int[si.size()];
        int i = 0;
        for (int x : si){
            res[i] = x;
            i++;
        }
        return res;
    }

    public boolean containSkill(Set<Integer> si,int skill,List<Integer> peoples){
        int siskill = 0;
        for (Integer i : si){
            siskill |= peoples.get(i);
        }
        return (siskill & skill) == skill;
    }

    /**
     * DFS
     */
    private List<Integer> result = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String,Integer> skills = new HashMap<>();
        for (int i = 0;i < req_skills.length;i++){
            skills.put(req_skills[i], 1 << i);
        }
        int[] peoples = new int[people.size()];
        for (int i = 0;i < people.size();i++){
            for (String s : people.get(i)){
                peoples[i] |= skills.get(s);
            }
        }
        dfs(0, new ArrayList<>(), req_skills.length, peoples);
        return result.stream().mapToInt(k -> k).toArray();
    }
    public void dfs(int curSkill,List<Integer> curList,int N,int[] peSkill){
        if (curSkill == (1 << N) - 1){
            if (result.size() == 0 || result.size() > curList.size()){
                result = new ArrayList<>(curList);
                return;
            }
        } 
        if (result.size() != 0 && curList.size() >= result.size()){
            return;
        }

        // 优化点：寻找所需要的技能
        int bitct = 0;
        while (((curSkill >> bitct) & 1) == 1) ++bitct;
        
        for (int i = 0;i < peSkill.length;i++){
            if (((peSkill[i] >> bitct) & 1) == 1){
                curList.add(i);
                dfs(curSkill | peSkill[i], curList, N, peSkill);
                curList.remove(curList.size() - 1);
            }
        }
    }
}