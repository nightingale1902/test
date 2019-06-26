package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_067AddBinary {
    //当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) //如果a为空，则返回b；反之则返回a
            return b;
        if (b == null || b.length() == 0)
            return a;
        if (a.length() < b.length()) return addBinary(b, a); //保证a的字符串长度都大于或等于b
        int i = a.length() - 1; //获取a,b的长
        int j = b.length() - 1;
        int carry = 0;     //进位标志，初始化为0
        StringBuilder res = new StringBuilder();
        while (j >= 0) {   // a，b都不为空时，从后往前遍历，从低位开始相加
            int digit = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            carry = digit / 2;  //保存下一个carry位：逢2进位
            digit %= 2;         //取余，保存当前位（进位后）的值
            res.insert(0, digit);   //插入到res中
            i--;
            j--;
        }
        //a是更长的，处理a余下的数位
        while (i >= 0) {
            int digit = a.charAt(i) - '0' + carry;
            carry = digit / 2;
            digit %= 2;
            res.insert(0, digit);
            i--;
        }
        if (carry > 0) {
            res.insert(0, carry);
        }
        return res.toString();
    }
}
