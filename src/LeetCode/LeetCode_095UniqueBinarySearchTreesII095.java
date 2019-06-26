package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_095UniqueBinarySearchTreesII095 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> subLeftTree = generateTrees(start, i - 1);
            List<TreeNode> subRightTree = generateTrees(i + 1, end);
            for(TreeNode left : subLeftTree){
                for(TreeNode right : subRightTree){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }

    public List<TreeNode> generateTreesHelper(int begin, int end){
        List<TreeNode> res = new LinkedList<>();
        if (begin > end){
            res.add(null);
            return res;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> leftTrees = generateTreesHelper(begin, i - 1);
            List<TreeNode> rightTrees = generateTreesHelper(i + 1, end);
            for (TreeNode l : leftTrees){
                for (TreeNode r : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
