package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。*/
public class LeetCode_030SubstringWithConcatenationOfAllWords030 {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>(); //返回值
        int n = words.length; // 记录words中子串的个数
        int m = words[0].length(); // 记录单个子串的长度大小
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i <= s.length() - n * m; i++) {
            HashMap<String, Integer> copy = new HashMap<>(map);
            int k = n;
            int j = i;
            while (k > 0){
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1){
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m; //越过
            }
            if (k == 0) res.add(i);
        }
        return res;
    }
   /* @Test
    public void test(){
        String s = "barfoothefoobarman";
        String[] words ={"foo","bar"};
        System.out.println(findSubstring(s, words));
    }*/

}
