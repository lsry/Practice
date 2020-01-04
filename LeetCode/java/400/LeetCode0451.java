import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LeetCode0451{
    class Node implements Comparable<Node>{
        public Character ch;
        public int count;

        public Node(char c,int count){
            this.ch = c;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - this.count;
        }

        @Override
        public boolean equals(Object other){
            if (this == other) return true;
            if (other == null || !(other instanceof Node)) return false;
            Node n = (Node) other;
            return Objects.equals(this.ch, n.ch);
        }

        @Override
        public int hashCode(){
            return count * 31 + ch.hashCode();
        }
        
    }
    public String frequencySort(String s) {
        Map<Character,Integer> mch = new HashMap<>();
        for (char c : s.toCharArray()){
            mch.put(c, mch.getOrDefault(c, 0) + 1);
        }
        Node[] nodes = new Node[mch.size()];
        int i = 0;
        for (Map.Entry<Character,Integer> entry : mch.entrySet()){
           nodes[i] = new Node(entry.getKey(), entry.getValue());
            i++;
        }
        Arrays.sort(nodes);
        StringBuilder sb = new StringBuilder();
        for (Node n : nodes){
            for (int j = 0;j < n.count;j++){
                sb.append(n.ch);
            }
        }
        return sb.toString();
    }
}