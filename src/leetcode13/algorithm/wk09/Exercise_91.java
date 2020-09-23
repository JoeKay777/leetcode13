package leetcode13.algorithm.wk09;

import java.util.Calendar;

/**
 * 91. 解码方法
 */
public class Exercise_91 {

    /**
     * 状态定义dp[i]:0~i-1个字符解码方法数
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) return 0;
        char[] chars = s.toCharArray();
        if(chars[0] == '0') return 0;
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;  // 初始位置为1便于计算
        dp[1] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                if(chars[i-1] == '1' || chars[i-1] == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) {
                dp[i + 1] = dp[i - 1] + dp[i];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[chars.length];
    }

    public static void main(String[] args) {
        new Exercise_91().numDecodings("12");
    }
}
