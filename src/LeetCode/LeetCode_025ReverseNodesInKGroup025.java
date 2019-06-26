package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
那么将最后剩余节点保持原有顺序。*/
public class LeetCode_025ReverseNodesInKGroup025 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(-1), pre = dummy, cur = head;
        dummy.next = head; //可以使用head了。
        for (int i = 1; cur != null; i++) {
            if (i % k == 0){
                pre = reverseOneGroup(pre, cur.next);
                cur = pre.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;

    }
    public ListNode reverseOneGroup(ListNode pre, ListNode next){
       ListNode last = pre.next, cur = last.next;
       while (cur != next){
           last.next = cur.next;
           cur.next = pre.next;
           pre.next = cur;
           cur = last.next;
       }
       return last;
    }
    //递归做法
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            if (cur == null) return head;
            cur = cur.next;
        }
        ListNode newHead = reverse(head, cur);
        head.next = reverseKGroup2(cur, k);
        return newHead;

    }

    public ListNode reverse(ListNode head, ListNode tail){
       ListNode pre = tail;
       while (head != tail){
           ListNode temp = head.next;
           head.next = pre;
           pre = head;
           head = temp;
       }
       return pre;
    }
    //栈
    public ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null ) return null;
        if (k == 1) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode next = head;
        while (next != null){
            int count = 0;
            while (next != null && count < k){
                stack.add(next);
                next = next.next;
                count++;
            }
            //代表将后面没有k个元素的一组，直接放置于已经翻转的链表之后。
            if (k != count){
                current.next = head;
                break;
            }
            while (!stack.isEmpty()){
                current.next = stack.pop();
                current = current.next;
            }
            current.next = next;
            head = next;

        }
        return dummy.next;
    }
    //改进
    public ListNode reverseKGroup4(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true){
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k){
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            //如果出现个数小于k，就结束执行转换，如果count == k，往下面程序执行，将栈中的元素取出。
            if (count != k){
                p.next = head;
                break;
            }
            while (!stack.isEmpty()){
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup5(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null){
            prev = reverse(prev, k);
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode prev, int k){
        ListNode last = prev; //last 是翻转链表后面的元素
        for (int i = 0; i < k + 1; i++) { // k+1原因是prev 首先指向dummy
            last = last.next;
            if (i != k && last == null) return null;
        }
        ListNode tail = prev.next;//tail指向未翻转前的第一个元素
        ListNode curr = prev.next.next;
        while (curr != last){
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            tail.next = next;
            curr = next;
        }
        return tail;
    }


}

