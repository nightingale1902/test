package LeetCode;

import java.util.Stack;

/*给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。*/
public class LeetCode_032LongestValidParentheses {
    //栈
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)  return 0;
        int result = 0, start = -1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                if (stack.isEmpty()) {
                    start = i;
                } else{
                    stack.pop();
                    result = stack.empty() ? Math.max(result, i - start) : Math.max(result, i - stack.peek());

                }
            }
        }
        return result;
    }

    public int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2)  return 0;
        int max = 0;
        int leftmost = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else { //if )
                if (stack.empty()){
                    leftmost = i;
                }else {
                    stack.pop();
                    max = stack.isEmpty() ? Math.max(max, i - leftmost) : Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
