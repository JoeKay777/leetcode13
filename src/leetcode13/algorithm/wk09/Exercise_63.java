package leetcode13.algorithm.wk09;

/**
 * 63. 不同路径 II
 */
public class Exercise_63 {

    /**
     * 状态定义dp[i][j]:走到坐标为[i,j]的网格的不同路径
     * 状态转移方程:dp[i][j] =  obstacleGrid[i][j] == 1 ? 0 : (dp[i-1][j] + dp[i][j-1])
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        // 初始化
        for (int i = 1; i < obstacleGrid.length; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < obstacleGrid[0].length; j++) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
