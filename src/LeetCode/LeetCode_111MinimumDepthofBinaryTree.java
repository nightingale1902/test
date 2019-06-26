package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-18
 */
public class LeetCode_111MinimumDepthofBinaryTree {
      public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null) return minDepth(root.left) + 1;
        if (root.right != null && root.left == null) return minDepth(root.right) + 1;
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }
}
