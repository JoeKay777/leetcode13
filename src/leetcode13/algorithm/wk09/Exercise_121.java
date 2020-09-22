package leetcode13.algorithm.wk09;

/**
 * 121. 买卖股票的最佳时机
 */
public class Exercise_121 {

    /**
     * 状态定义dp[i]:第i天卖出股票获取的最大利润
     * 状态转移方程：dp[i] = max(dp[i -1] + (prices[i] - prices[i-1]), 0)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = dp[i - 1] + prices[i] - prices[i - 1];
            if (profit > 0) {
                dp[i] = profit;
            }
            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }

    /**
     * 空间优化
     * 状态定义dp[i]:第i天卖出股票获取的最大利润
     * 状态转移方程：dp[i] = max(dp[i -1] + (prices[i] - prices[i-1]), 0)
     *
     * @param prices
     * @return
     */
    public int maxProfit_2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        int profit = 0; // 记录上次最大利润
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(0, profit + prices[i] - prices[i - 1]);
            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }
}
