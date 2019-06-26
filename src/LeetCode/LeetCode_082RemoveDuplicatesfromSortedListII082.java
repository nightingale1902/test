package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-15
 */
public class LeetCode_082RemoveDuplicatesfromSortedListII082 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        ListNode pre = dummy;
        while (p != null && p.next != null){
            if (p.val == p.next.val){
                int val = p.val;
                while (p != null && val == p.val){ //删除2个及其以上的重复结点
                    p = p.next;
                }
                pre.next = p;
            }else {
                pre = p;
                p = p.next;
            }
        }
        return dummy.next;
    }

}
