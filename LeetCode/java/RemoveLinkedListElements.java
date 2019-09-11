public class RemoveLinkedListElements{
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        ListNode h1 = head;
        while (h1 != null && h1.val == val)
            h1 = h1.next;
        head = h1;         
        if (h1 == null){
            return head;
        }
        ListNode h2 = h1;   
        h1 = h1.next;
        while (h1 != null){
            if (h1.val == val){
                h2.next = h1.next;
            } else {
                h2 = h2.next;
            }
            h1 = h1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,6,3,4,5,6};
        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int a : arr){
            ListNode t = new ListNode(a);
            h.next = t;
            h = h.next;
        }
        RemoveLinkedListElements rls = new RemoveLinkedListElements();
        rls.removeElements(head, 6);
        h = head.next;
        while (h != null){
            System.out.print(h.val + "\t");
            h = h.next;
        }
    }
}