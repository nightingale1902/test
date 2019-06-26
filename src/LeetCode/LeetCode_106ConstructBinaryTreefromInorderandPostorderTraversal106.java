package LeetCode;

/**
 * @Author: xiexiaoxie
 * @Date: 2019-06-07
 */
public class LeetCode_106ConstructBinaryTreefromInorderandPostorderTraversal106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        return buildHelper(inOrder, 0,
                inOrder.length - 1, postOrder, postOrder.length - 1);

    }

    public TreeNode buildHelper(int[] inOrder, int startIn, int endIn, int[] postOrder, int postEnd) {
        if (startIn > endIn)
            return null;
        TreeNode root = new TreeNode(postOrder[postEnd]);
        // 此if可以省略
        if (startIn == endIn)
            return root;
        // find the i in inorder:
        for (int i = endIn; i >= startIn; i--) {
            if (inOrder[i] == root.val) {
                // endIn-i右子树长度
                // postEnd - (endIn - i) - 1
                root.left = buildHelper(inOrder, startIn,
                        i - 1, postOrder, postEnd - (endIn - i) - 1);
                root.right = buildHelper(inOrder,
                        i + 1, endIn, postOrder, postEnd - 1);
            }
        }
        return root;
    }
}
