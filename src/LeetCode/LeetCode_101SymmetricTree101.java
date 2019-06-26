package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//给定一个二叉树，检查它是否是镜像对称的
public class LeetCode_101SymmetricTree101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //终止条件
    //返回信息
    //本级递归做啥
    public boolean isSymmetric(TreeNode root) {
       if (root == null) return true;
       return isMirror(root.left, root.right);

    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left != null && right == null || left == null && right != null || left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);

    }
    /*利用队列进行迭代。队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。最初，队列中包含的是 root 以及 root。
    该算法的工作原理类似于 BFS，但存在一些关键差异。每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。
    当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。*/
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
