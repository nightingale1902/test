package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-16
 */
public class LeetCode_065ValidNumber {
    //这道题不用过于关注
    public boolean isNumber(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }
        return helper(s);

    }

    private boolean helper(String s) {
        char[] cs = s.toCharArray();
        int index = 0, tail = cs.length - 1;
        //去掉开头空格
        while (index < tail && cs[index] == ' ') {
            index++;
        }
        // 去掉尾部空格
        while (tail > 0 && cs[tail] == ' ') {
            tail--;
        }
        // "   "的情况 -- false
        if (tail == index && !isNum(cs[index])) {
            return false;
        }
        if (cs[index] == '+' || cs[index] == '-') {
            index++;
        }

        boolean dot = false;
        //要么.开头，要么数字开头
        if (cs[index] == '.') {
            index++;
            dot = true;
        } else if (!isNum(cs[index])) {
            return false;
        }
        // 开头是. 后面必须是数字
        // 开头是数字，先跳过数字和 .
        if (dot) {
            if (index == tail + 1 || !isNum(cs[index])) {
                return false;
            }
        } else {
            index = nextNum(cs, index);
            if (index == tail + 1) {
                return true;
            }
            if (cs[index] == '.') {
                index++;
            }
        }
        index = nextNum(cs, index);
        if (index == tail + 1) {
            return true;
        }
        if (cs[index] != 'e' && cs[index] != 'E') {
            return false;
        }
        if (++index == tail + 1) {
            return false;
        }
        if (cs[index] == '+' || cs[index] == '-') {
            if (++index == tail + 1) {
                return false;
            }
        }
        return nextNum(cs, index) == tail + 1;

    }

    private int nextNum(char[] nums, int index) {
        while (index < nums.length && nums[index] >= '0' && nums[index] <= '9') {
            index++;
        }
        return index;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
