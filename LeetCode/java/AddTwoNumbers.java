class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/*
 * Leetcode 0002
 */

public class AddTwoNumbers{
    /**
     * 遍历两个链表，依次将对应位置上数字相加，并记下进位
     * 当其中一个为空，则遍历另外一个链表，将数字加过来
     * 若两个均为空，则需要判断进位是否为 0 ， 不为 0 ，则放到最高位上
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        int c = (head1.val + head2.val) / 10;
        ListNode res = new ListNode((head1.val + head2.val) % 10);
        ListNode head3 = res;
        while (head1.next != null && head2.next != null){
            head1 = head1.next;
            head2 = head2.next;
            head3.next = new ListNode((head1.val + head2.val + c) % 10);
            c = (head1.val + head2.val + c) / 10;
            head3 = head3.next;
        }
        if (head2.next == null && head1.next != null){
            while (head1.next != null){
                head1 = head1.next;
                head3.next = new ListNode((c + head1.val) % 10);
                c = (c + head1.val) / 10;
                head3 = head3.next;
            }
        }
        if (head1.next == null && head2.next !=null){
            while (head2.next != null){
                head2 = head2.next;
                head3.next = new ListNode((c + head2.val) % 10);
                c = (c + head2.val) / 10;
                head3 = head3.next;
            }
        }
        if (head1.next == null && head2.next == null && c != 0){
            head3.next = new ListNode(c);
            head3 = head3.next;
        }
        return res;
    }
}