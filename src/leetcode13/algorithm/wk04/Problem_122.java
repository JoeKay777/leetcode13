package leetcode13.algorithm.wk04;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class Problem_122 {

    public int maxProfit(int[] prices) {


        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {    // 今天比昨天价格高就卖出
                profit += (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }
}