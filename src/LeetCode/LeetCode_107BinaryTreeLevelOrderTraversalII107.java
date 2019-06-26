package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-17
 */
public class LeetCode_107BinaryTreeLevelOrderTraversalII107 {
    /*给定一个二叉树，返回其节点值自底向上的层次遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）*/
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        levelOrderBottomHelper(res, 0, root);
        //题目要求是从底层往上，需要翻转
        /*for (int i = 0, j = res.size() - 1; i < j; i++, j--) {
            List<Integer> temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
        }*/
        return reverse(res, 0, res.size() - 1);
    }
    //BFS
    public void levelOrderBottomHelper(List<List<Integer>> res, int level, TreeNode root){
          if (root == null) return;
          if (res.size() == level){ //父节点
              List<Integer> cur = new ArrayList<>();
              cur.add(root.val);
              res.add(cur);
          }else {//两个左右子节点
              res.get(level).add(root.val);
          }
          levelOrderBottomHelper(res, level + 1, root.left);
          levelOrderBottomHelper(res, level + 1, root.right);
    }
    public List<List<Integer>> reverse(List<List<Integer>> res, int i, int j){
        while (i < j){
            List<Integer> temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++;
            j--;
        }
        return res;
    }
}
