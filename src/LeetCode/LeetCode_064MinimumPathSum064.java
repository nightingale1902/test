package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_064MinimumPathSum064 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        //递推式 --> dp[i][j] = grid[i][j] + min(dp[i - 1][j])
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < n; ++i) dp[0][i] = grid[0][i] + dp[0][i - 1];
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
