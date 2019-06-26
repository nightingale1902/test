package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-07
 */
public class LeetCode_894AllPossibleFullBinaryTrees894 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) return res;
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i -1);
            for (TreeNode a : left){
                for (TreeNode b : right){
                    TreeNode cur = new TreeNode(0);
                    cur.left = a;
                    cur.right = b;
                    res.add(cur);
                }
            }
        }
        return res;

    }
}
