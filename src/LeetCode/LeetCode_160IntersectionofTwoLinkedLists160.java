package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-23
 */
public class LeetCode_160IntersectionofTwoLinkedLists160 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        if (headA == null || headB == null)
            return res;
        int lengthA = getListNodeLength(headA);
        int lengthB = getListNodeLength(headB);
        if (lengthA > lengthB) {
             return getIntersectionNode(headB, headA);
        }
        ListNode pA = headA, pB = headB;
        while (pA != null && pB != null) {
            int tempA = pA.val;
            int tempB = pB.val;
            if (tempA < tempB){
                pA = pA.next;
            } else if (tempA > tempB) {
                pB = pB.next;
            }else {
                res = pA;
                return res;
            }
        }
        return res;

    }

    public int getListNodeLength(ListNode head) {
        int res = 0;
        if (head == null)
            return res;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
/*    public ListNode listSplitSort(ListNode head){
        if(null == head) {
            return head;
        }

        ListNode tmp = head;
        ListNode slow = head, fast = head; //快慢指针找到原链表的中间节点
        while(fast != null) {
            fast = fast.next;
            if(fast != null)
            {
                fast = fast.next;
            }

            if(null == fast)
            {
                break;
            }
            slow = slow.next;
        }

        tmp = slow;
        slow = slow.next;//中间节点的下一个节点作为第二个子链表的头节点
        tmp.next = null; //保证每个子链表尾指针都指向NULL
        return slow;
    }*/

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /*每个链表各用两个指针，先两个链表各一个指针一起走，一个走到结尾后，就可以判断那个长哪个短，然后先走长的，之后保持一致，
        最后判断是否相等。*/
        ListNode res = null;
        if(headA == null || headB == null) return res;
        ListNode p1 = headA, q1 = headA;
        ListNode p2 = headB, q2 = headB;
        while(p1.next != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1.next != null){
            while(p1.next != null){
                q1 = q1.next;
                p1 = p1.next;
            }
        }
        if(p2.next != null){
            while(p2.next != null){
                q2 = q2.next;
                p2 = p2.next;
            }
        }
        while(q1 != q2){
            q1 = q1.next;
            q2 = q2.next;
        }
        res = q1;
        return res;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
