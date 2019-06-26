package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_093RestoreIPAddresses093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        doRestore(res, "", s, 0);
        return res;
    }
    public void doRestore(List<String> result, String path, String s, int k){
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4)
                result.add(path.substring(1));
            return;
        }
        // 以0开头的时候单作为一部分
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
            String part = s.substring(0, i);
            if (Integer.parseInt(part) <= 255)
                doRestore(result, path + "." + part, s.substring(i), k + 1);
        }
    }

}
