public class LeetCode0328{
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode o = head;
        ListNode even = head.next;
        ListNode e = even;
        while (e != null && e.next != null){
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = even;
        return head;
    }
}