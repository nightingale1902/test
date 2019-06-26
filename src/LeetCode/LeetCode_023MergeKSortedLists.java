package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

//合并 k 个排序链表，返回合并后的排序链表。
/*1. 终止条件
* 2. 找返回值
* 3. 本级递归任务*/
public class LeetCode_023MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //分治大法好
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoListNode(lists[0], lists[1]);

        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = mid, j = 0; i < lists.length; i++, j++) {
            l2[j] = lists[i];
        }
        return mergeTwoListNode(mergeKLists(l1), mergeKLists(l2));
    }

    public ListNode mergeTwoListNode(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoListNode(l1.next, l2);
        }else {
            head = l2;
            head.next = mergeTwoListNode(l1, l2.next);
        }
        return head;
    }

    public ListNode mergeKLists2(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> queue = new PriorityQueue<>(lists.length);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (ListNode node : lists){
            if (node != null)
                queue.add(node);
        }
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null){
                queue.add(tail.next);
            }
        }
        return head.next;
    }
}
