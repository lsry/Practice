import java.util.Arrays;

public class LeetCode0056{
    class Node implements Comparable<Node>{
        public int left;
        public int right;

        public Node(int l,int r){
            left = l;
            right = r;
        }

        @Override
        public int compareTo(Node other) {
            return this.left - other.left;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1){
            return intervals;
        }
        Node[] nodes = new Node[intervals.length];
        for (int i = 0;i < intervals.length;i++){
            nodes[i] = new Node(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(nodes);
        int index = 0;
        for (int i = 1;i < nodes.length;i++){
            if (nodes[i].left <= nodes[index].right){
                nodes[index].right = (nodes[i].right > nodes[index].right) ? nodes[i].right : nodes[index].right;
            } else {
                index++;
                nodes[index].left = nodes[i].left;
                nodes[index].right = nodes[i].right;
            }
        }
        int[][] arr = new int[index + 1][2];
        for (int i = 0;i <= index;i++){
            arr[i][0] = nodes[i].left;
            arr[i][1] = nodes[i].right;
        }
        return arr;
    }
}