package leetcode13.algorithm.wk05;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class Exercise_322 {

    /**
     * dp[i] 总金额为i时，最少找零的硬币量
     * 动态转移方程式：dp[i] = min(dp[i - coin]) + 1;
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];   // dp[i] 总金额为i时，最少找零的硬币量
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int money = 1; money <= amount; money++) {
            int count = Integer.MAX_VALUE;
            for (int coin : coins) {
                if(money - coin >= 0 && dp[money - coin] != -1) {
                    count = Math.min(count, dp[money - coin] + 1);
                }
            }
            if(count != Integer.MAX_VALUE) {
                dp[money] = count;
            }
        }
        return dp[amount];
    }


}
