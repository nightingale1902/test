package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-07
 */
public class LeetCode_105ConstructBinaryTreefromPreorderandInorderTraversal105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
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

}
