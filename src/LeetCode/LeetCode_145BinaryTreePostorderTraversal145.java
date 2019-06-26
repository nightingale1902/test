package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: YourName
 * @Date: 2019-06-12
 */
public class LeetCode_145BinaryTreePostorderTraversal145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    //非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))){
                res.add(cur.val);
                pre = cur;
                stack.pop();
            }else {
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }
        return res;
    }
    //利用先序遍历“根左右”的遍历顺序，将先序遍历顺序更改为“根右左”，反转结果List，得到结果顺序为“左右根”。
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈
            res.add(0,node.val);                        //逆序添加结点值
        }
        return res;
    }

}
