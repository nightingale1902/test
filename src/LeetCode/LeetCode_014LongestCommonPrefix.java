package LeetCode;
/*
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

    示例 1:
    输入: ["flower","flow","flight"]
    输出: "fl"

    示例 2:
    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。-->从后往前查
 */
public class LeetCode_014LongestCommonPrefix {
    //time:O(n) space:O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i=0; i<strs.length; i++){
            //indexof 找子串匹配，返回匹配子串在母串的index
            while (strs[i].indexOf(res) != 0){
                //把最后一位截取掉1
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }
}

