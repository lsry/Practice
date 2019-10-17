import java.util.List;

/**
 * 本质证明图的连通性
 */
public class LeetCode0841 {
    private boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        helper(rooms, 0);
        for (boolean b : visited){
            if (b == false){
                return false;
            }
        }
        return true;
    }

    public void helper(List<List<Integer>> rooms,int index){
        visited[index] = true;
        int size = rooms.size();
        if (index >= size){
            return;
        }
        List<Integer> li = rooms.get(index);
        for (Integer i : li){
            if (visited[i] == false){
                helper(rooms, i);
            }
        }
    }
}