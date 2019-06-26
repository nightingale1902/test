package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-15
 */
public class LeetCode_077Combinations {
        //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            backtrackHelper(res, new ArrayList<>(), 1, k, n);
            return res;
        }
        public void backtrackHelper(List<List<Integer>> res, List<Integer> cur, int i, int k, int n){
            if (cur.size() == k){
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int j = i; j <= n; j++) {
                if (k - cur.size() > n - j + 1) break;
                cur.add(j);
                backtrackHelper(res, cur, j + 1, k, n);
                cur.remove(cur.size() - 1);
            }
        }
}
