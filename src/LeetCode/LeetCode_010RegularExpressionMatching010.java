package LeetCode;

/*给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

    '.' 匹配任意单个字符。
    '*' 匹配零个或多个前面的元素。
    [匹配应该覆盖整个字符串 (s) ，而不是部分字符串。]

说明:

    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

    示例 1:
    输入:
        s = "aa"
        p = "a"
    输出: false
    解释: "a" 无法匹配 "aa" 整个字符串。

    示例 2:
    输入:
        s = "aa"
        p = "a*"
    输出: true
    解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。

    示例 3:
    输入:
        s = "ab"
        p = ".*"
    输出: true
    解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。

    示例 4:
    输入:
        s = "aab"
        p = "c*a*b"
    输出: true
    解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。

    示例 5:
    输入:
        s = "mississippi"
        p = "mis*is*p*."
    输出: false
 */
public class LeetCode_010RegularExpressionMatching010 {
    //dp问题，一定要会

    /*
    * boolean dp[i][j] 的含义是s[0-i]与p[0-j]是否匹配
    * dp[0][0] = true;
    * 1. p.charAt(j) == s.charAt(i) --> dp[i][j] = dp[i-1][j-1]  dp[i][j]保持之前的状态，而最开始dp[0][0] = true;默认为true
    * 2. If p.charAt(j) == '.' --> dp[i][j] = dp[i-1][j-1];
    * 3. If p.cahrAt(j) == '*' :
    *       here are two sub conditions:
    *       1. If p.charAt(j-1) != s.charAt(i) --> dp[i][j] = dp[i][j-2] //in this case , a* only counts as empty.example
    *           "b a a b", "b c * a a b"
    *              i            j        --> delete directly "c *"
    *       2. If p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.';
    *           example : "a a" , "a *"     and "a a", ". *"
    *                      i         j           i        j
    *             dp[i][j] = dp[i][j-1] //     "a" -> "a*"
    *             dp[i][j] = dp[i-1][j] //      "aaa" -> "a*"
    *             dp[i][j] = dp[i][j-2] //      "" -> "a*"
    *
    * */
    //time: O(m * n) space:O(m * n)
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return  false;
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//不代表任何两个字符的匹配
        //预处理 "aab" ,"c*aab" 如果i = 1时，i-1=0 -->dp[0][0] = true; -->dp[0][2] = true -->删除了"c*"
        for (int i =0; i < p.length(); i++){
            if (p.charAt(i) == '*' && dp[0][i -1]){
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (p.charAt(j) == s.charAt(i)){
                    //because dp[0][0] = true -->i+1,j+1
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '.'){
                    //because dp[0][0] = true -->i+1,j+1
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*'){
                    if (p.charAt(j -1) != s.charAt(i) && p.charAt(j - 1) != '.'){
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j -1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }
   /* @Test
    public void test(){
        String s = "aab";
        String p = "c*a*b";
        boolean temp;
        temp = isMatch(s, p);
        System.out.println(temp);

    }
    public boolean isMatch2(String s, String p) {
        return s.matches(p);
    }
*/
}

/*java.lang.NullPointerException
  at line 31, Solution.isMatch
  at line 54, __DriverSolution__.__helper__
  at line 81, __Driver__.main*/
