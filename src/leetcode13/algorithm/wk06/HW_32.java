package leetcode13.algorithm.wk06;

/**
 * 32. 最长有效括号
 */
public class HW_32 {

    /**
     * dp[i]  表示已i结尾的最长有效括号
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        int res = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')' && chars[i - 1] == '(') {
                dp[i + 1] = dp[i - 1] + 2;
            } else if (chars[i] == ')') {
                int left = i - dp[i] - 1;
                if (left >= 0 && chars[left] == '(') {
                    dp[i + 1] = dp[i] + 2 + dp[left];
                }
            }

            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }

}
