package LeetCode;

import java.util.Stack;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。*/
public class LeetCode_020ValidParentheses020 {
    /*这里我们需要用一个栈，我们开始遍历输入字符串，如果当前字符为左半边括号时，则将其压入栈中，如果遇到右半边括号时，
    若此时栈为空，则直接返回false，如不为空，则取出栈顶元素，若为对应的左半边括号，则继续循环，反之返回false*/
    public boolean isValid(String s) {
        Stack<Character> parenthese = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                parenthese.push(s.charAt(i));
            }else {
                if (parenthese.empty()) return false;
                if (s.charAt(i) ==')' && parenthese.peek() != '(') return false;
                if (s.charAt(i) ==']' && parenthese.peek() != '[') return false;
                if (s.charAt(i) =='}' && parenthese.peek() != '{') return false;
                parenthese.pop();
            }
        }
        return parenthese.empty();
    }
}
