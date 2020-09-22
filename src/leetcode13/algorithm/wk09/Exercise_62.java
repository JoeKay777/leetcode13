package leetcode13.algorithm.wk09;

import java.util.Arrays;

/**
 * 62. 不同路径
 */
public class Exercise_62 {

    /**
     * 状态定义：dp[i][j] 走到坐标为[i,j]的方格的不同路径数量
     * 状态转移方程：dp[i][j] = dp[i -1][j] + dp[i][j -1]
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i -1][j] + dp[i][j -1];
            }
        }
        return dp[m-1][n-1];
    }
}
