package LeetCode;

public class LeetCode_058LengthOfLastWord {
    /*给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
    * 从后往前*/
    public int lengthOfLastWord(String s) {
        s = s.trim();// trim()的作用是去掉字符串两端的多余的空格,注意,是两端的空格,且无论两端的空格有多少个都会去掉,当然 中间的那些空格不会被去掉
        if (s == null || s.length() == 0) return 0;
        int size = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                break;
            }
            size++;

        }
        return size;

    }

}
