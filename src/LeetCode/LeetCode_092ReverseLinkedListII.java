package LeetCode;

import java.util.Stack;

/**
 * @Author: YourName
 * @Date: 2019-06-16
 */
public class LeetCode_092ReverseLinkedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        if (m == n)
            return head;
        Stack<ListNode> stack = new Stack();
        //将m-n的结点入栈，将前后相邻的两个结点标记;
        int num = 1;
        ListNode pfirst = null;
        ListNode psecond = null;
        ListNode p = head;
        //特殊情况，m==1时，头结点变更;
        if (m == 1) pfirst = null;
        for (; num <= n; num++) {
            //记录pfirst;
            if (num < m) {
                if (num == m - 1) {
                    pfirst = p;
                }
                p = p.next;
            } else if (num >= m && num <= n) {
                stack.push(p);
                p = p.next;
            }
        }
        //记录psecond,psecond的一般情况仍适用于n=length of list的特殊情况;
        psecond = p;
        //开始操作链表;
        if (pfirst == null) {
            head = stack.pop();
            pfirst = head;
        }
        while (!stack.empty()) {
            pfirst.next = stack.pop();
            pfirst = pfirst.next;
        }
        pfirst.next = psecond;
        return head;

    }

}
