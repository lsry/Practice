import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class LeetCode0126{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> hs = new HashSet<>(wordList);
        if (!hs.contains(endWord)){
            return res;
        }
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        res.add(ls);  
        res = find(endWord, res, wordList);
        return res;
    }

    public List<List<String>> find(String endWord,List<List<String>> temp,List<String> wordList){
        List<List<String>> res = new ArrayList<>();
        Iterator<List<String>> it = temp.iterator();
        while(it.hasNext()){
            List<String> ls = it.next();
            String last = ls.get(ls.size() - 1);
            if (ls.size() < wordList.size() + 1){               
                for (int i = 0;i < wordList.size();i++){
                    String word = wordList.get(i);
                    if (isdiffOne(last, word)){
                        List<String> ls2 = new ArrayList<>(ls);
                        ls2.add(word);
                        res.add(ls2);
                    }
                }
            } else {
                it.remove();
            }  
        }
        if (contain(res, endWord)){
            it = res.iterator();
            while (it.hasNext()){
                List<String> ts = it.next();
                if (!ts.get(ts.size() - 1).equals(endWord)){
                    it.remove();
                }
            }
        } else if (res.size() > 0) {
            res = find(endWord, res, wordList);
        }
        return res;
    }

    public boolean contain(List<List<String>> lls,String word){
        for (List<String> ls : lls){
            if (ls.get(ls.size() - 1).equals(word)){
                return true;
            }
        }
        return false;
    }

    public boolean isdiffOne(String one,String two){
        int count = 0;
        for (int i = 0;i < one.length();i++){
            if (one.charAt(i) != two.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        
    }
}