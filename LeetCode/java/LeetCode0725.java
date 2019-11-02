public class LeetCode0725{
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] nodes = new ListNode[k];
        ListNode head = root;
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        int ilen = length / k;
        int remain = length % k;
        head = root;
        for (int i = 0;i < k;i++){
            if (head == null){
                break;
            }
            int curLen = ilen;
            if (remain != 0){
                curLen ++;
                remain --;
            }
            ListNode curNode = null;
            for (int j = 0;j < curLen;j++){
                if (head != null){
                    if (j == 0){
                        curNode = head;
                        nodes[i] = curNode;
                        head = head.next;
                        curNode.next = null;
                    } else {
                        curNode.next = head;
                        curNode = curNode.next;
                        head = head.next;
                        curNode.next = null;
                    }
                } else {
                    break;
                }
            }
        }
        return nodes;
    }
}