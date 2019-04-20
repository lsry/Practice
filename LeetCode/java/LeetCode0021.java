class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LeetCode0021{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode h0 = head;
        ListNode h1 = l1;
        ListNode h2 = l2;
        while (h1 != null && h2 != null){
            if (h1.val < h2.val){
                h0.next = h1;
                h1 = h1.next;
            } else {
                h0.next = h2;
                h2 = h2.next;
            }
            h0 = h0.next;
        }
        if (h2 == null){
            while (h1 != null){
                h0.next = h1;
                h1 = h1.next;
                h0 = h0.next;
            }
        }
        if (h1 == null){
            while (h2 != null){
                h0.next = h2;
                h0 = h0.next;
                h2 = h2.next;
            }
        }
        return head.next;
    }
}