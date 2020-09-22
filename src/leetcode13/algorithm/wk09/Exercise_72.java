package leetcode13.algorithm.wk09;

/**
 * 72. 编辑距离
 */
public class Exercise_72 {

    /**
     * 状态定义dp[i][j] word1中0-i转成word2中0-j的最少操作
     * 状态转移方程：dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1; 当word1[i] <> word2[j]
     * dp[i-1][j-1]; 当word1[i] = word2[j]
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始字符定位“”
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
