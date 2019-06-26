package LeetCode;

/*给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

    示例 1:
    输入: 123
    输出: 321

    示例 2:
    输入: -123
    输出: -321

    示例 3:
    输入: 120
    输出: 21

    注意:
    假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，
    如果反转后整数溢出那么就返回 0。*/
public class LeetCode_007ReverseInteger007 {
    //time:O(n) space:O(1)
    public int reverse(int x) {
        //int类型的数字倒着写有可能越界所以使用long类型，converse的常用套路。应该加强练习
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }
        return (int) res;
    }
}
