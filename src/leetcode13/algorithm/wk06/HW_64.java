package leetcode13.algorithm.wk06;

import java.util.Arrays;

/**
 * 64.最小路径和
 */
public class HW_64 {

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }
}
