package leetcode13.algorithm.wk06;

import java.util.Arrays;
import java.util.jar.JarEntry;

/**
 * 62. 不同路径
 */
public class Exercise_62 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n -1];
    }
}
