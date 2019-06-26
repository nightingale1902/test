package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-16
 */
public class LeetCode_087ScrambleString {
    //https://blog.csdn.net/q839219286/article/details/90091903
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) return true;
        if (s1.length() != s2.length()) return false;
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0, s1.length());
    }
    private boolean dfs(char[] s1, char[] s2, int start1, int start2, int len){
        if (len == 1) {
            return s1[start1] == s2[start2];
        }
        if (!equals(s1, s2, start1, start2, len)) {
            return false;
        }
        for (int i = 1; i < len; i++){
            if (dfs(s1, s2, start1, start2, i) && dfs(s1, s2, start1 + i, start2 + i, len - i)) return true;
            if (dfs(s1, s2, start1, start2 + len - i, i) && dfs(s1, s2, start1 + i, start2, len - i)) return true;
        }
        return false;
    }
    public boolean equals(char[] s1, char[] s2, int start1, int start2, int len){
        int[] charArr = new int[26];
        for (int i=0; i < len; i++) {
            charArr[s1[start1 + i] - 'a']++;
            charArr[s2[start2 + i] - 'a']--;
        }
        for (int item : charArr) {
            if (item != 0) return false;
        }
        return true;
    }

}
