package leetcode13.algorithm.wk09;

/**
 * 44. 通配符匹配
 */
public class HW_44 {

    /**
     * 状态定义dp[i+1][j+1] s坐标为0->i,与p坐标0->j是否匹配
     * dp[i+1][j+1] =   dp[i][j] ,当[j] =  '?' || [i] == [j]
     * dp[i][j+1] || dp[i+1][j] ,当[j] = '*'
     * false ,其他
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // 初始化
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }


}
