package LeetCode;

import java.util.ArrayList;
import java.util.List;
/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母*/
public class LeetCode_017LetterCombinations {
    //2019年5月8日20:29:31
    /*
    * 我们用递归 Recursion 来解，我们需要建立一个字典，用来保存每个数字所代表的字符串，然后我们还需要一个变量 level，
    * 记录当前生成的字符串的字符个数，实现套路和上述那些题十分类似。在递归函数中我们首先判断 level，如果跟 digits 中数字的个数相等了，
    * 我们将当前的组合加入结果 res 中，然后返回。否则我们通过 digits 中的数字到 dict 中取出字符串，然后遍历这个取出的字符串，
    * 将每个字符都加到当前的组合后面，并调用递归函数即可
    * */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (!digits.isEmpty()) {
            helper(digits, "", 0, list);
        }
        return list;
    }
    public void helper(String digits, String combo, int position, List<String> list) {
        if (position == digits.length()) {
            list.add(combo);
            return;
        }

        String[] letters = getMapping(digits.charAt(position));
        for (int i = 0; i < letters.length; i++) {
            helper(digits, combo + letters[i], position + 1, list);
        }
    }


    public String[] getMapping(char c){
        switch (c){
            case '2':
                return new String[]{"a", "b", "c"};
            case '3':
                return new String[] {"d", "e", "f"};
            case '4':
                return new String[] {"g", "h", "i"};
            case '5':
                return new String[] {"j", "k", "l"};
            case '6':
                return new String[] {"m", "n", "o"};
            case '7':
                return new String[] {"p", "q", "r", "s"};
            case '8':
                return new String[] {"t", "u", "v"};
            case '9':
                return new String[] {"w", "x", "y", "z"};
        }
        return new String[]{};
    }

    public List<String> letterCombinations2(String digits) {
        List<String> strings = new ArrayList<>();
        if (digits.length() == 0) {
            return strings;
        }
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //选中的字母组合
        String[] arr = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            arr[i] = dict[digits.charAt(i) - '0' - 2];
        }
        int startStr = 0;//循环下标
        group(arr, startStr, "",strings);
        return strings;
    }

    private static String group(String[] arr, int startStr, String str, List<String> strings) {
        char[] chars1 = arr[startStr].toCharArray();
        for (int j = 0; j < chars1.length; j++) {
            if (startStr == arr.length - 1) {
                strings.add(str + chars1[j]);
            } else {
                //startStr+1:遍历下一个字符组合;str + chars1[j]:拼接当前遍历的字符
                group(arr, startStr+1, str + chars1[j],strings);
            }
        }
        return str;
    }

}


