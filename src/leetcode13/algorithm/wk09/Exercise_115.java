package leetcode13.algorithm.wk09;

import java.util.Arrays;

/**
 * 115. 不同的子序列
 */
public class Exercise_115 {

    /**
     * 状态定义dp[i][j]: s[0,j]子串中出现字符串t[0,i]的个数
     * 状态转移方程： dp[i][j] = dp[i-1][j-1](取s[j]) + dp[i][j-1](不取s[i]) ,当s[j] = t[i]
     * = dp[i][j-1], 当s[j] <> t[i]
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        // 任意子串都包含“”字符串
        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {      // s必须大于等于t的长度
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

}
