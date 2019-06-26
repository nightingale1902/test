package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-15
 */
public class LeetCode_086PartitionList086 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);//结点值小于x的组成的链表
        ListNode dummyHead2 = new ListNode(0);//结点值大于或等于x的组成的链表
        ListNode tail1 = dummyHead1;
        ListNode tail2 = dummyHead2;
        while (head != null){
            if (head.val < x){ //小于x
                tail1.next = head;
                tail1 = tail1.next;
                head = head.next;
                tail1.next = null;
            }else {
                tail2.next = head;
                tail2 = tail2.next;
                head = head.next;
                tail2.next = null;
            }
        }
        tail1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
