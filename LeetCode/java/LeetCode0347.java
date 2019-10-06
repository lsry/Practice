import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode0347 {

    public class Node implements Comparable<Node>{
        public int key;
        public int count;

        public Node(int k,int c){
            this.key = k;
            this.count = c;
        }

        @Override
        public int compareTo(Node n) {
            return this.count - n.count;
        }

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n,map.getOrDefault(n, 0) + 1);
        }

        Node[] nodes = new Node[map.size()];
        int index = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            nodes[index] = new Node(entry.getKey(),entry.getValue());
            index++;
        }

        Arrays.sort(nodes);

        List<Integer> li = new ArrayList<>(k);
        for (int i = nodes.length - 1;i >= nodes.length - k;i--){
            li.add(nodes[i].key);
        }

        return li;
    }
}