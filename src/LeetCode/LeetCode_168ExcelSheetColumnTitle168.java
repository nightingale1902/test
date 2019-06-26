package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-24
 */
public class LeetCode_168ExcelSheetColumnTitle168 {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

}
