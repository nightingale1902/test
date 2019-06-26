package LeetCode;

import java.util.Stack;

/**
 * @Author: YourName
 * @Date: 2019-06-23
 */
public class LeetCode_155MinStack155_2 {
    /*使用两个栈来实现，一个栈来按顺序存储push进来的数据，另一个用来存出现过的最小值*/
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    public LeetCode_155MinStack155_2() {

    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x)
            s2.push(x);
    }

    public void pop() {
        int x = s1.pop();
        if (s2.peek() == x)
            s2.pop();
    }

    public int top() {
       return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

}
