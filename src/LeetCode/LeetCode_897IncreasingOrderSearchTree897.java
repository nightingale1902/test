package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-07
 */
public class LeetCode_897IncreasingOrderSearchTree897 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        return increasingBSTHelper(root, null);
    }
    public TreeNode increasingBSTHelper(TreeNode node, TreeNode pre){
        if (node == null) return pre;
        TreeNode res = increasingBSTHelper(node.left, node);
        node.left = null;
        node.right = increasingBSTHelper(node.right, pre);
        return res;

    }

}
