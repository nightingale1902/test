package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-10
 */
public class LeetCode_061RotateList061 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1;
        ListNode p = head;
        while (p.next != null){
            p = p.next;
            len++;
        }
        p.next = head;
        k %= len;
        for (int i = 0; i < len - k; i++) { //找到旋转点处
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }

}
