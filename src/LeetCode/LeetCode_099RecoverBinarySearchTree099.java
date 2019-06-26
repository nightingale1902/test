package LeetCode;

import java.util.Stack;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_099RecoverBinarySearchTree099 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //中序遍历
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
    public void helper(TreeNode root){
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != null && prev.val > root.val){
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        helper(root.right);
    }

    public void recoverTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur =stack.pop();
                if (prev != null && cur.val <= prev.val){
                    if (first == null) first = prev;
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }


}
