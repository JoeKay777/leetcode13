package leetcode13.algorithm.wk09;

/**
 * 70. 爬楼梯
 */
public class Exercise_70 {
    /**
     * 状态定义：dp[i] 爬第i-1个楼梯的不同方法数量
     * 状态转移方程：dp[i] = dp[i -1] + dp[i - 2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
