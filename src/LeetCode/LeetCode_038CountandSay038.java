package LeetCode;

public class LeetCode_038CountandSay038 {
    public String countAndSay(int n) {//求第n个数
        if (n <= 0) {
            return "";
        }
        String str = "1";
        for (int i = 1; i < n; i++) {
            int count = 0; //count 个数
            char prev = '.'; //say 值
            StringBuilder sb = new StringBuilder();
            for (int idx = 0; idx < str.length(); idx++) {
                if (str.charAt(idx) == prev || prev =='.'){
                    count++;
                }else {
                    sb.append(count + Character.toString(prev));
                    count = 1;
                }
                prev = str.charAt(idx);
            }
            sb.append(count + Character.toString(prev));
            str = sb.toString();
        }
        return str;
    }
}
