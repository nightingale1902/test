package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_096UniqueBinarySearchTrees096 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];//i为总结点， j为左结点， 1 为根节点。
            }
        }
        return res[n];
    }




}
