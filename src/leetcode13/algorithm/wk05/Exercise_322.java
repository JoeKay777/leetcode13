package leetcode13.algorithm.wk05;

/**
 * 322. 零钱兑换
 */
public class Exercise_322 {


    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[coins.length];   // dp[i]表示选择第i个硬币的金额
        for (int money = 1; money < amount; money++) {
            for (int i = 0; i < coins.length; i++) {
                money - coins
            }
        }
    }


}
