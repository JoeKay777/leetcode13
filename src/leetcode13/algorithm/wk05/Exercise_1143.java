package leetcode13.algorithm.wk05;

import sun.security.util.Length;

/**
 * 1143. 最长公共子序列
 */
public class Exercise_1143 {

    /**
     * dp[i][j] 表示以第一个字符串0-i子串 与第二个字符串0-j子串的最长公共子序列长度
     * dp[i][j] = str1[i] == str2[j] ? dp[i-1][j -1] + 1 : max(dp[i][j-1],dp[i-1][j])
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() +1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
        int i = new Exercise_1143().longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}
