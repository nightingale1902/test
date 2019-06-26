package niukewang;

import java.util.*;

/**
 * @Author: xiexiaoxie
 * @Date: 2019-06-07
 */
public class Test {
    //面试题4
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) return "";
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for (int i = len; i >= 0; i--) {
            if (str.charAt(i) == ' ') { //注意：比较的不是" "
                res.append("02%");
            } else {
                res.append(str.charAt(i));
            }

        }
        return res.reverse().toString();
    }

    //面试题5
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /*程序关键之处是ArrayList list = new ArrayList();写在了递归体之外，因此每次递归体中list.add所添加的节点值都是添进同一个数组。

注：因为每次操作的都是同一个数组，其实return语句只在最后一次有实际作用（用来给调用此函数的程序返回倒置后的list），并为最后一次方法体服务，最后一次之前的return没有实际作用（最多有结束本次递归的作用）。

程序的操作过程，与一种行为特别的相似，就是当你的袜子是反面的时候，你得先深入袜子内，抓住底部，然后往外抽，袜子就正面了，不断递归的过程就是插入袜子的过程，每次递归体结束的过程就是慢慢抽出来的过程（因为每一次递归的结束意味着有一个节点装入了新的Arraylist）。袜子的底部就是最后一个节点。
！*/

   /* ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode != null){
                printListFromTailToHead(listNode.next);
                res.add(listNode.val);
            }

        }
        return res;


    }*/

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) return res;
        Stack<ListNode> stack = new Stack<>();
        ListNode pNode = listNode;
        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.next;
        }
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            res.add(temp.val);
        }
        return res;
    }

    //面试题6

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) return null;
        return reConstructBinaryTreeHelper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode reConstructBinaryTreeHelper(int[] preOrder, int startPre, int endPre, int[] inOrder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        TreeNode root = new TreeNode(preOrder[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (inOrder[i] == preOrder[startPre]) {
                // 左右子树都不能包括根节点，子区间都是闭区间

                // i-startIn是左子树长度
                // tartPre + i - startIn是左子树的的最后一个结点下标(包括)
                root.left = reConstructBinaryTreeHelper(preOrder, startPre + 1, startPre + i - startIn,
                        inOrder, startIn, i - 1);
                // startPre + 1 + i - startIn左子树开始结点加上左子树长度
                // 为右子树的开始结点
                root.right = reConstructBinaryTreeHelper(preOrder, startPre + i - startIn + 1, endPre,
                        inOrder, i + 1, endIn);
            }

        }
        return root;

    }


    //面试7
    //用两个栈来实现一个队列，完成队列的Push和Pop操作。
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    /*push 动作都在 stack1 中进行，
      pop 动作在 stack2 中进行。当 stack2 不为空时，直接 pop，当 stack2 为空时，先把 stack1 中的元素 pop 出来，push 到 stack2 中，再从 stack2 中 pop 元素。*/
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) throw new RuntimeException("Queue is empty");
        int node;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                node = stack1.pop();
                stack2.push(node);
            }
        }
        return stack2.pop();
    }

    //递归实现快速排序的代码
    public void quickSort_1(int[] data, int start, int end) {
        if (data == null || start < 0 || end > data.length - 1) {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (start == end) return;
        int index = partition(data, start, end);
        if (index > start) {
            quickSort_1(data, start, index - 1);
        }
        if (index < end) {
            quickSort_1(data, index + 1, end);
        }
    }

    private int partition(int[] data, int start, int end) {
        int index = start + (int) (Math.random() * (end - start + 1));
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        swap(data, small + 1, end);
        return small + 1;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //快排经典的“挖坑填数+分治”

    public void quickSort_2(int[] data, int start, int end) {
        if (data == null || start >= end) return;
        int i = start, j = end;
        int pivotKey = data[start];
        while (i < j) {
            while (i < j && data[j] >= pivotKey) j--;
            if (i < j) data[i++] = data[j];

            while (i < j && data[i] <= pivotKey) i++;
            if (i < j) data[j--] = data[i];
        }

        data[i] = pivotKey;
        quickSort_2(data, start, i - 1);
        quickSort_2(data, i + 1, end);
    }

    //快排记住的方法
    public void quiclSort(int[] arr, int first, int end) {
        if (first >= end) return;
        int pivot = correctPivot(arr, first, end);
        quiclSort(arr, first, pivot - 1);
        quiclSort(arr, pivot + 1, end);
    }

    public int correctPivot(int[] arr, int first, int end) {
        while (first < end) {
            while (first < end && arr[first] <= arr[end]) end--; //右侧扫描
            if (first < end) {
                swap(arr, first, end);
                first++;
            }


        while (first < end && arr[first] <= arr[end]) first++; // 左侧扫描
        if (first < end) {
            swap(arr, first, end);
            end--;
        }

    }
    return first;

}


    //面试8
    //
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0) return 0;
        int len = array.length;
        int low = 0, high = len - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1; // 最小值在右侧
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;//最小值在左侧
            }
        }
        return array[low];
    }

    //面试9



    //面试14
    //调整数组顺序使奇数位于偶数前面
    public void reOrderArray(int [] array) {
        Vector<Integer> odd = new Vector<>();//奇数
        Vector<Integer> even = new Vector<>(); //偶数
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                even.add(array[i]);
            }else {
                odd.add(array[i]);
            }

        }
        odd.addAll(even);
        for (int i = 0; i < array.length; i++) {
            array[i] = odd.get(i);
        }

    }

    public void reorder(int[] array , boolean isFun){
        if (array == null || array.length == 0) return;
        int begin = 0;
        int end = array.length - 1;
        while (begin < end){
            while (begin < end && !isFun(begin)) begin++;
            while (begin < end && isFun(end)) end--;
            if (begin < end){
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
            }
        }

    }

    public boolean isFun(int n){
        return (n & 1) == 0;
    }


    //面试15
    public ListNode FindKthToTail(ListNode head,int k) {

        if (head == null || k == 0) return null;
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
        if (cur == null) return head;//k为链表的长度,直接返回head
        //快慢指针
        while (cur.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        ListNode resListNode = pre.next;
        return resListNode;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        while (head != null){

            // 单独取出下一个节点
            ListNode next = head.next;

            // 将头节点连接到新头节点后面
            head.next = newHead;
            newHead = head;

            // 向后移动头节点
            head = next;

        }
        return newHead;
    }

    //面试18 输入两棵二叉树A，B，判断B是不是A的子结构。

    public boolean HasSubtree(TreeNode s,TreeNode t) {
        boolean result = false;
        //if (s == null && t == null) return true;
        if (s != null && t != null){
            if (s.val == t.val)
                result = doesTree1HaveTree2(s, t);
            if (!result)
                result = HasSubtree(s.left, t);
            if (!result)
                result = HasSubtree(s.right, t);
        }
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode pRoot1, TreeNode pRoot2){
        if (pRoot1 == null && pRoot2 == null) return true;
        if (pRoot1 != null && pRoot2 != null && pRoot1.val == pRoot2.val) return doesTree1HaveTree2(pRoot1.left, pRoot2.left) && doesTree1HaveTree2(pRoot1.right, pRoot2.right);
        return false;

    }
    //面试21
    public class Solution {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();//放入每次的最小元素
        int min = Integer.MAX_VALUE;

        public void push(int node) {
            stack.push(node);
            if (node < min){
                temp.push(node);
                min = node;
            }else {
                temp.push(min);
            }
        }

        public void pop() {
            stack.pop();
            temp.pop();

        }

        public int top() {
            int t = stack.pop();
            stack.push(t);
            return t;

        }

        public int min() {
            /*int m = temp.pop();
            temp.push(m);
            return m;*/
            return temp.peek();
        }
    }

    //面试22
    //int [] pushA --> 压入序列，int [] popA  -->弹出序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length || pushA.length == 0 || popA.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[index]){
                stack.pop();
                index++;
            }

        }
        return stack.isEmpty();
    }



    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                res.add(temp.val);
            }
        }
        return res;
    }

   /* public List<Integer> postorderTraversal(TreeNode root) {

    }*/
   public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) return false;
        if (sequence.length == 1) return true;
        return VerifySquenceOfBSTHelper(sequence, 0, sequence.length - 1);
   }
   public boolean VerifySquenceOfBSTHelper(int[] sequence, int start, int root){
       if (start >= root) return true;
       int i = start;//中间分割点
       while (i < root && sequence[i] < sequence[root]) i++;
       for (int j = i; j < root; j++) {
           if (sequence[j] < sequence[root])
               return false;
       }
       return VerifySquenceOfBSTHelper(sequence, start, i - 1) && VerifySquenceOfBSTHelper(sequence, i, root - 1);
   }

   //面试25
   ArrayList<ArrayList<Integer>> results = new ArrayList<>();
   ArrayList<Integer> curResult = new ArrayList<>();
   public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return results;
        target = target - root.val;
        curResult.add(root.val);
        if (target == 0 && root.left == null && root.right == null)
            results.add(new ArrayList<>(curResult));
        else {
            FindPath(root.left, target);
            FindPath(root.right, target);
        }
        curResult.remove(curResult.size() - 1);
        return results;
   }


    //面试28 字符串的排列
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str == null)
            return res;
        PermutationHelper(str.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }
    public void PermutationHelper(char[] str, int i){
        if(i == str.length - 1){
            res.add(String.valueOf(str));
        }else{
            for(int j = i; j < str.length; j++){
                if(j != i && str[i] == str[j])
                    continue;
                swap(str, i, j);
                PermutationHelper(str, i + 1);
                swap(str, i, j);
            }
        }
    }
    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        connectSiblingNodes(pHead);
        return reconnectNodes(pHead);

    }
    //复制任意节点N，并创建新节点N^
    public void cloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pCloned = new RandomListNode(0);
            pCloned.label = pNode.label;
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }

    }
    //原始链表上的结点n的random指向s，则它对应的复制结点n^的random指向下一个结点s^。
    public void connectSiblingNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
    }
    //将合并的链表拆分为两个
    public RandomListNode reconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        if (pNode != null){
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        while (pNode != null){
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }




   @org.junit.Test
   public void test(){
       ArrayList<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(2);
       list.add(3);
       List<List<Integer>> res = new ArrayList<>();
       System.out.println(res);
/*       res.add(list);
       list.add(50);
       res.add(list);
       System.out.println(res + "发现两个元素竟然一样");*/
       res.add(new ArrayList<>(list));
       list.add(50);
       res.add(new ArrayList<>(list));
       System.out.println(res + "发现两个元素竟然不一样");
   }
   //面试29数组中出现次数超过一半的数字
    // 成熟的O(n)的算法

}
