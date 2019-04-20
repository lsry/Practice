import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode0876{
    public ListNode middleNode(ListNode head) {
        if (head == null){
            return null;
        }
        List<ListNode> li = new ArrayList<>();
        ListNode h0 = head;
        while(h0 != null){
            li.add(h0);
            h0 = h0.next;
        }
        return li.get(li.size()/2);
    }
}