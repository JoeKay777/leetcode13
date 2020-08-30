package leetcode13.algorithm.wk05;

/**
 * 72. 编辑距离
 */
public class Exercise_72 {
    /**
     * dp[i][j] 表示word1[0..i] 匹配word2[0..j]最小编辑距离
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 初始化“”与word2匹配
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        // 初始化word1与“”匹配
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
