import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode0648 {
    class Trie{
        private class Node{
            public boolean isWord;
            public Map<Character,Node> next;
    
            public Node(boolean isWord){
                this.isWord = isWord;
                next = new HashMap<>();
            }
    
            public Node(){
                this(false);
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()){
                if (!cur.next.containsKey(c)){
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            cur.isWord = true;
        }

        public String findPrefix(String word){
            Node cur = root;
            for (int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                if (!cur.next.containsKey(c)){
                    break;
                }
                cur = cur.next.get(c);
                if (cur.isWord){
                    return word.substring(0, i + 1);
                }    
            }
            return null;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.isEmpty() || sentence == null || sentence.isEmpty()){
            return sentence;
        }
        Trie trie = new Trie();
        for (String s : dict){
            trie.insert(s);
        }
        String[] sarr = sentence.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (String s : sarr){
            String temp = trie.findPrefix(s);
            if (temp != null){
                sBuilder.append(temp);
            } else {
                sBuilder.append(s);
            }
            sBuilder.append(" ");
        }
        return sBuilder.substring(0, sBuilder.length() - 1);
    }

    public static void main(String[] args) {
        
    }
}