package LeetCode;

import java.util.*;

public class LeetCode_049Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            //将排序后的字符串作为hashmap的key，是一个重要关键
            Arrays.sort(curr);
            String key = String.valueOf(curr);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        //Collection results = map.values();
        return new ArrayList<>(map.values());
    }
}
