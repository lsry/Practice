import java.util.HashSet;

public class LeetCode0142{
    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode h0 = head;
        while (h0 != null){
            if (hs.contains(h0)){
                return h0;
            } else {
                hs.add(h0);
                h0 = h0.next;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head){
        
    }
}