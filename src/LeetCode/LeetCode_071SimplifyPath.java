package LeetCode;

import java.util.Stack;

/**
 * @Author: YourName
 * @Date: 2019-06-16
 */
public class LeetCode_071SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int pop = 0;
        String[] split = path.split("/");
        for (String s : split)
            if (s.length() > 0)
                stack.push(s);
        while (!stack.isEmpty()) {
            String s = stack.pop();
            if (s.equals(".."))
                pop++;
            else if (!s.equals(".")) {
                if (pop > 0)
                    pop--;
                else
                    sb.insert(0, '/' + s);
            }
        }
        return (sb.length() == 0 ? "/" : sb.toString());
    }
}
