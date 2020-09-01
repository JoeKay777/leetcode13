package leetcode13.algorithm.wk06;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class Exercise_322 {

    private int res = Integer.MAX_VALUE;
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        this.coins = coins;
        backtract(amount, coins.length - 1, 0); // 优先最大硬币找零
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void backtract(int amount, int index, int count) {
        // 终止条件
        if (amount == 0) {
            res = count;
            return;
        }
        if (index < 0) {
            return;
        }

        // 选择：从最多-0依次选择当前面值的硬币
        int k = amount / coins[index];
        while (k >= 0 && count + k < res) { //  剪枝
            backtract(amount - k * coins[index], index - 1, count + k);
            k--;
        }
    }

    public static void main(String[] args) {
        new Exercise_322().coinChange(new int[]{1, 2, 5}, 11);
    }
}
