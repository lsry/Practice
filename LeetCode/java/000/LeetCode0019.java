public class LeetCode0019{
    /**
     * 创建两个指针，间隔 n-1，然后同时移动直到快指针移动到末尾，那么慢指针即为要删除的元素
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
       // 要创建头结点 (important)
       ListNode h = new ListNode(0);
       h.next = head;
       ListNode front = h,back = h,back2 = h;
        for (int i = 0;i < n && front != null;i++){
            front = front.next;
        }
        while (front != null){
            front = front.next;
            back2 = back;
            back = back.next;
        }
        if (back == null){
            back2.next = null;
        } else {
            back2.next = back.next;
        }
        return h.next;
    }
    public static void main(String[] args) {
        
    }
}