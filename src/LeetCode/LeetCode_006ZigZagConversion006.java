package LeetCode;
/*
   将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
   比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    L   C   I   R
    E T O E S I I G
    E   D   H   N
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
    请你实现这个将字符串进行指定行数变换的函数：

    string convert(string s, int numRows);
    示例 1:

    输入: s = "LEETCODEISHIRING", numRows = 3
    输出: "LCIRETOESIIGEDHN"
    示例 2:

    输入: s = "LEETCODEISHIRING", numRows = 4
    输出: "LDREOEIIECIHNTSG"
    解释:

    L     D     R
    E   O E   I I
    E C   I H   N
    T     S     G
    */

public class LeetCode_006ZigZagConversion006 {
    //time:O(n)
    //space:O(n),使用了StringBuilder。
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder("");
        }
        for (int i = 0; i < s.length(); i++){
            int index = i % (numRows * 2 - 2);
            //这一步很关键，需要数学推理计算
            //2 * numRows - 2 - index 指方向是相反的
            index = index < numRows ? index : 2 * numRows - 2 - index;
            sb[index].append(s.charAt(i));
        }
        for (int i = 1; i < sb.length; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
