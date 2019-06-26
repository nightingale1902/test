package LeetCode;

import java.util.ArrayList;
import java.util.List;


/*给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。*/
/*在LeetCode中有关括号的题共有三道，除了这一道的另外两道是 Valid Parentheses 验证括号和 Longest Valid Parentheses 最长有效括号，*/
public class LeetCode_022GenerateParentheses {
    /*对于这种列出所有结果的题首先还是考虑用递归Recursion来解*/
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;
    }

    public void helper(List<String> res, String s, int left, int right){
        if (left > right) return;
        if (left == 0 && right == 0){
            res.add(s);
            return;
        }
        if (left > 0){
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0){
            helper(res, s + ")", left, right - 1);
        }
    }
}
