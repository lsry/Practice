public class LeetCode0024{

    public ListNode exchangeK(ListNode head,int k){
        ListNode h0 = new ListNode(0);
        h0.next = head;
        ListNode before_cur = h0;
        ListNode last = h0;
        ListNode cur = head;
        ListNode cur_head = cur;
        while (cur != null){
            cur_head = cur;
            int i = 0;
            for (;i < k && cur != null;i++){
                before_cur = cur;
                cur = cur.next;
            }
            if (i == k){
                before_cur.next = null;
                ListNode temp = cur_head;
                while (cur_head != null){
                    ListNode t = cur_head;
                    cur_head = cur_head.next;
                    t.next = last.next;
                    last.next = t;      
                }
                last = temp;
            } else {
                break;
            }
        }
        last.next = cur_head;
        return h0.next;
    }

    public ListNode swapPairs(ListNode head) {
        return exchangeK(head, 2);
    }
    public static void main(String[] args) {
        
    }
}