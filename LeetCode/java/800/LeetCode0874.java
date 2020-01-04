import java.util.HashSet;
import java.util.Set;

public class LeetCode0874{
    class Node{
        public int x;
        public int y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;
            return this.x == n.x && this.y == n.y;
        }

        @Override
        public int hashCode(){
            return x * 31 + y;
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Node> ns = new HashSet<>();
        for (int i = 0;i < obstacles.length;i++){
            ns.add(new Node(obstacles[i][0],obstacles[i][1]));
        }
        int max = 0;
        int x = 0, y = 0;
        int direction = 0;// 0: north, 1: east, 2: south, 3: west
        for (int c : commands){
            if (c == -1){  // turn right
                direction = (direction + 1) % 4;
            } else if (c == -2){
                direction = (direction - 1 + 4) % 4;
            } else {
                int positive = 1; 
                boolean useY = true; // north - south 
                switch (direction){
                    case 0 : positive = 1; useY = true; break;
                    case 1 : positive = 1; useY = false; break;
                    case 2 : positive = -1; useY = true; break;
                    case 3 : positive = -1; useY = false; break;
                }
                if (useY){
                    int step = 1;
                    for (;step <= c;step++){
                        if (ns.contains(new Node(x,y + positive * step))){
                            break;
                        }
                    }
                    y += positive * (step - 1);
                    
                } else {
                    int step = 1;
                    for (;step <= c;step++){
                        if (ns.contains(new Node(x + positive * step,y))){
                            break;
                        }
                    }
                    x += positive * (step - 1);
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }
}