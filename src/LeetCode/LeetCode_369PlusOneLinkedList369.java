package LeetCode;

public class LeetCode_369PlusOneLinkedList369 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
/* 1 9 9 9. 1 9 1 9
*  i     j      i j
*
*
*
* 1 0 9 0 9
*       i j
* */

    public ListNode plusOne(ListNode head) {
        //
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy, j = dummy;
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        if (dummy.val == 0) return dummy.next;
        return dummy;
    }
}
