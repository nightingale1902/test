package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-18
 */
public class LeetCode_125ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int length = s.length();
        StringBuilder str = new StringBuilder(length);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }



    public boolean isPalindrome2(String s){
        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j){
          /*  while (i < j && (s.charAt(i) < '0' || (s.charAt(i) > '9' && s.charAt(i) < 'a') || s.charAt(i) > 'z')){
                i++;
            }
            while (i < j && (s.charAt(j) < '0' || (s.charAt(j) > '9' && s.charAt(j) < 'a') || s.charAt(j) > 'z')) {
                j--;
            }*/
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
    public boolean isPalindrome3(String s) {
        int l = 0, r = s.length() - 1;
        while(l <= r){
            if(!isValidChar(s.charAt(l))){
                ++l;
                continue;
            }
            if(!isValidChar(s.charAt(r))){
                --r;
                continue;
            }
            if(!isEqual(s.charAt(l), s.charAt(r))){
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
    public boolean isValidChar(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){
            return true;
        }else{
            return false;
        }
    }
    public boolean isEqual(char l, char r){
        if(l < 'a' && l > '9'){
            l = (char)(l - 'A' + 'a');
        }
        if(r < 'a' && r > '9'){
            r = (char)(r - 'A' + 'a');
        }
        return l == r;
    }
}
