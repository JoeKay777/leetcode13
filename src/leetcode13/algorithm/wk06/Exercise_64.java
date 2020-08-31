package leetcode13.algorithm.wk06;

import leetcode13.algorithm.wk05.Exercise_673;

/**
 * 64. 最小路径和
 */
public class Exercise_64 {

    /**
     * dp[i][j] 表示 到达i和j网格时最小路径和
     * <p>
     * dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        // 初始化横坐标
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 初始化纵坐标
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 优化空间
     * dp[i][j] 表示 到达i和j网格时最小路径和
     * <p>
     * dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
     *
     * @param grid
     * @return
     */
    public int minPathSum_2(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        // 初始化第一行
        for (int j = 1; j < grid[0].length; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] = dp[0] + grid[i][0];     // 每行第一个
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {
        new Exercise_64().minPathSum(new int[][]{{1, 2, 5}, {3, 2, 1}});
    }
}
