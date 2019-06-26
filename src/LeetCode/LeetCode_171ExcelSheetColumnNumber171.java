package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-24
 */
public class LeetCode_171ExcelSheetColumnNumber171 {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = 0;
        int power = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int charAt = (int) ((s.charAt(i) - 'A' + 1) * Math.pow(26, power));
            res += charAt;
            power++;
        }
        return res;
    }
}
