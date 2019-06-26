package LeetCode;

/*

    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    示例 1：

    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    示例 2：

    输入: "cbbd"
    输出: "bb"
*/
public class LeetCode_005LongestPalindrome005 {
    //db算法 time:O(n^2) space:O(n^2)
    public String longestPalindrome(String s) {
        if (s == null && s.length() == 0)
            return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0; //回文最大长度
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                // index: i.........j
                //(j - i <= 2) || dp[i + 1][j - 1] 判断中间是否为回文，
                //(j - i <= 2)放在前面，，否则会发生短路
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {//判断最大回文
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;

    }

    //中心扩散法
    //time:O(n^2) space:O(1)
    String res = "";
    public String longestPalindrome2(String s) {
        if (s == null && s.length() == 0)
            return s;
        for (int i = 0; i < s.length(); i++){
            /*奇数形式的，我们就从遍历到的位置为中心，向两边进行扩散，
            对于偶数情况，我们就把当前位置和下一个位置当作偶数行回文的最中间两个字符，
            然后向两边进行搜索*/

            //奇数
            helper(s, i, i);
            //偶数
            helper(s, i, i+1);

        }
        return res;

    }

    public void helper(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            //这是一个元素的中心扩散法
            left--;
            right++;
        }
        //上面的while条件不满足时，表示当前left和right指向的index恰好不符合要求，因此截取字符串的时候要退一个字母。
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()){
            res = cur;
        }
    }
}