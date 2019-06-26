package LeetCode;

/*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。*/
public class LeetCode_019RemoveNthFromEnd019 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //新建链表，反向插入
    //链表长度 - n
    //使用一趟扫描
    /*允许一次遍历，所以我们不能用一次完整的遍历来统计链表中元素的个数，而是遍历到对应位置就应该移除了。那么我们需要用两个指针来帮助我们解题，
    pre和cur指针。首先cur指针先向前走N步，如果此时cur指向空，说明N为链表的长度，则需要移除的为首元素，那么此时我们返回head->next即可，
    如果cur存在，我们再继续往下走，此时pre指针也跟着走，直到cur为最后一个元素时停止，此时pre指向要移除元素的前一个元素，
    我们再修改指针跳过需要移除的元素*/
    /*常用技巧 --> 快慢指针 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode pre = head, cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        if (cur == null) return head.next;
        while (cur.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = head;
        ListNode temp = FindKthToTail2(head, n);
        if (pre == temp) return head.next;
        while (pre.next != temp){
            pre = pre.next;
        }
        pre.next = temp.next;
        return head;
    }

    //返回链表的倒数第 k 个节点
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return null;

        //验证k是否小于head链表的长度
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        if (length < k) return null;

        ListNode pre = head, cur = head;
        for (int i = 0; i < k; i++) { //输入的以head为头结点的链表的结点总数少于k --> 在for循环中增加判断下一个节点是否是空指针的代码
                cur = cur.next;
        }
       if (cur == null) return head.next;//k为链表的长度,直接返回head
        while (cur.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        ListNode resListNode = pre.next;
        return resListNode;
    }

    public ListNode FindKthToTail2(ListNode head, int k){
        if (head == null || k == 0) return null;
        ListNode pAhead = head;
        ListNode pBehind = head;
        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null){
                pAhead = pAhead.next;
            }else {
                return null;
            }
        }
        while (pAhead.next != null){
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }

}
