import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1091{
    class Node{
        int x;
        int y;
        int value;

        public Node(int x,int y,int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1){
            return -1;
        }
        Deque<Node> queue = new LinkedList<>();
        int[][] index = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        queue.addFirst(new Node(0,0,1));
        while (!queue.isEmpty()){
            Node cur = queue.removeLast();
            if (cur.x == grid.length - 1 && cur.y == grid[0].length - 1){
                return cur.value;
            }
            for (int i = 0;i < index.length;i++){
                int x = cur.x + index[i][0];
                int y = cur.y + index[i][1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0){
                    queue.addFirst(new Node(x,y,cur.value + 1));
                    grid[x][y] = 1;
                }
            }
        }
        return -1;
    }
}