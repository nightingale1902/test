package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-13
 */
public class LeetCode_138CopyListwithRandomPointer138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    public void cloneNodes(Node pHead) {
        Node pNode = pHead;
        while (pNode != null) {
            Node pCloned = new Node();
            pCloned.val = pNode.val;
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }

    }

    //原始链表上的结点n的random指向s，则它对应的复制结点n^的random指向下一个结点s^。
    public void connectSiblingNodes(Node pHead) {
        Node pNode = pHead;
        while (pNode != null) {
            Node pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
    }

    //将合并的链表拆分为两个
    public Node reconnectNodes(Node pHead) {
        Node pNode = pHead;
        Node pClonedHead = null;
        Node pClonedNode = null;
        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }
}
