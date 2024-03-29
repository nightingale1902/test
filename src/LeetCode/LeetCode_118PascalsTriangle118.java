package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-18
 */
public class LeetCode_118PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else {
                    Integer a = res.get(i - 1).get(j);
                    Integer b = res.get(i - 1).get(j - 1);
                    list.add(a + b);
                }
            }
            res.add(list);
        }
        return res;
    }
}
