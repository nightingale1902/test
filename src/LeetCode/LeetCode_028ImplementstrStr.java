package LeetCode;
/*给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
如果不存在，则返回  -1*/
public class LeetCode_028ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.equals(needle)){
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)){
                String substring = haystack.substring(i, i + needle.length());
                if (substring.equals(needle)) return i;
            }
        }
        return -1;
    }
}
