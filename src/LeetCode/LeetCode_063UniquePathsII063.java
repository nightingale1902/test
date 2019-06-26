package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_063UniquePathsII063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp[i][j] 表示到达 (i-1, j-1) 位置的不同路径的数量，那么i和j需要更新的范围就是[1, m] 和 [1, n]
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;//当起点不是障碍物时，其dp值应该为值，即dp[1][1] = 1，由于其是由 dp[0][1] + dp[1][0] 更新而来，所以二者中任意一个初始化为1即可
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] != 0) continue; // --> 遇到障碍物，进行下一次的循环
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }
        return dp[m][n];
    }
}
