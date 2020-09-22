package leetcode13.algorithm.wk09;

/**
 * 746. 使用最小花费爬楼梯
 */
public class Exercise_746 {

    /**
     * 状态定义dp[i]:爬到第i个楼梯最小花费
     * 状态转移方程：dp[i] = min(dp[i -1], dp[i -2]) + cost[i]
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        int[] dp = new int[cost.length + 1];
        dp[1] = cost[0];
        for (int i = 1; i < cost.length; i++) {
            dp[i + 1] = Math.min(dp[i], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[cost.length], dp[cost.length - 1]);
    }
}
