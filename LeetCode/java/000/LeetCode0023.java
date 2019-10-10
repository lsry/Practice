/**
 * 分治算法，类似于归并排序，先两两合并，然后在合并结果
 */
public class LeetCode0023{
    public ListNode merge2(ListNode l1,ListNode l2){
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

    public ListNode mergeRecur(ListNode[] lists,int i1,int i2){
        if (i1 == i2){
            return lists[i1];
        } else if (i2 - i1 == 1){
            return merge2(lists[i1],lists[i2]);
        } else if (i1 < i2) {
            int middle = i1 + (i2 - i1) / 2;
            ListNode l1 = mergeRecur(lists, i1, middle);
            ListNode l2 = mergeRecur(lists, middle+1,i2);
            return merge2(l1,l2);
        } else {
            return null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeRecur(lists, 0, lists.length-1);
    }

    public static void main(String[] args) {
        
    }
}