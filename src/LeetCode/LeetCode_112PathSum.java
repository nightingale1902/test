package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-18
 */
public class LeetCode_112PathSum {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean hasPathSum(TreeNode root, int sum) {
        //sum可能为负数 eg 输入 [-2,null,-3]，-5
        if (root == null)
            return false;
        //方法1
       /* if (root.val == sum && (root.left == null && root.right == null))
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);*/

        //方法2
        return hasPathSumRecursion(root,sum);
    }

    private boolean hasPathSumRecursion(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            if(sum == root.val){
                return true;
            } else {
                return false;
            }
        }

        boolean res = false;
        if(root.left != null){
            res = hasPathSumRecursion(root.left, sum - root.val);
        }
        if(root.right != null){
            res = res || hasPathSumRecursion(root.right, sum - root.val);
        }
        return res;
    }

}
