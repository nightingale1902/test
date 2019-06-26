package LeetCode;

public class LeetCode_002AddTwoNumbers {
     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
/*  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //特殊情况处理
        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null && l2 != null){
            return l2;
        }

        if(l1 != null && l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy; //dummy作为哑巴结点
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null){
            if (p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);//求余
            sum /= 10;//除以求商
            cur = cur.next;
        }
        if (sum == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
