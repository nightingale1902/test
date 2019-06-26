package LeetCode;

import org.junit.Test;

public class LeetCode_876MiddleNode876 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null){
            ++cnt;
            cur = cur.next;
        }
        cnt /= 2;
        while (cnt > 0){
            --cnt;
            head = head.next;
        }
        return head;
    }

}
