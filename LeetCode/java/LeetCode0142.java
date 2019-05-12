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
        ListNode h1 = head;
        ListNode h2 = head;
        boolean flag = false;
        while (h2 != null && h2.next != null){
            h1 = h1.next;
            h2 = h2.next.next;
            if (h1 == h2){
                flag = true;
                break;
            }
        }
        if (flag){
            h2 = head;
            while (h1 != h2){
                h1 = h1.next;
                h2 = h2.next;
            }
            return h1;
        } else {
            return null;
        }
    }
}