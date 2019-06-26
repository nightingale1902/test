package LeetCode;

import java.util.Arrays;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_062UniquePaths062 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }

        }
        return dp[n - 1];
    }

}
