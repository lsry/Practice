import java.util.LinkedList;

public class LeetCode0649{
    public String predictPartyVictory(String senate) {
        LinkedList<Integer> rqueue = new LinkedList<>();
        LinkedList<Integer> dqueue = new LinkedList<>();
        for (int i = 0;i < senate.length();i++){
            if (senate.charAt(i) == 'R'){
                rqueue.addLast(i);
            } else {
                dqueue.addLast(i);
            }
        }
        rqueue.addLast(-1);
        dqueue.addLast(-1);
        while (rqueue.size() > 1 && dqueue.size() > 1){
            int r = rqueue.peekFirst();
            int d = dqueue.peekFirst();
            if (r == -1 && d == -1){
                rqueue.addLast(rqueue.removeFirst());
                dqueue.addLast(dqueue.removeFirst());
            } else if (r == -1){
                rqueue.remove(1);
                dqueue.addLast(dqueue.removeFirst());
            } else if (d == -1){
                dqueue.remove(1);
                rqueue.addLast(rqueue.removeFirst());
            } else if (r < d){
                dqueue.removeFirst();
                rqueue.addLast(rqueue.removeFirst());
            } else {
                rqueue.removeFirst();
                dqueue.addLast(dqueue.removeFirst());
            }
        }
        return (dqueue.size() > 1) ? "Dire" : "Radiant";
    }
}