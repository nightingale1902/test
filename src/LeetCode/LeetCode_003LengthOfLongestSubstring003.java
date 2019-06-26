package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_003LengthOfLongestSubstring003 {
    /*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    示例 1:
        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:
        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:
        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
    //hashmap
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        //i作为终点，而j作为不重复的起点
        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i-j+1);
        }
        return res;
    }
    //hashset abcbefb abcbcbb
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(j));//有重复，就删除j指向的相同元素的第一个值
                j++;
            }
            set.add(s.charAt(i));
            res = Math.max(res, set.size());
        }
        return res;
    }

}
