package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author: YourName
 * @Date: 2019-06-12
 */
public class LeetCode_226InvertBinaryTree226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        /*queue.offer --> 将指定的元素插入此队列（如果立即可行且不会违反容量限制），插入成功返回 true；否则返回 false。当使用有容量限制的队列时，offer方法通常要优于 add方法---- add方法可能无法插入元素，而只是抛出一个IllegalStateException异常
        * queue.poll() 获取并移除此队列的头，如果此队列为空，则返回 null。 remove方法也可以获取并移除此队列的头，但该方法与 poll方法的唯一不同在于：如果此队列为空，那么remove方法将抛出NoSuchElementException异常
        * element()获取队列的头但不移除此队列的头。如果此队列为空，则将抛出NoSuchElementException异常。
        * peek()获取队列的头但不移除此队列的头。如果此队列为空，则返回 null*/
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
    }
}
