package leetcode13.algorithm.wk09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 818. 赛车
 */
public class Exercise_818 {

    public int racecar(int target) {
        if (target == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int t = 2; t <= target; t++) {
            int k = 31 - Integer.numberOfLeadingZeros(t + 1);   // 获取最大的加速次数
            if ((1 << k) - 1 == t) { // 全是A
                dp[t] = k;
                continue;
            }
            // 通过目的地然后倒车
            dp[t] = k + 2 + dp[(1 << (k + 1)) - t - 1];
            // 通过目的地的前一个,分别倒车1-i-1，前进剩余的距离
            for (int j = 0; j <= k; j++) {
                dp[t] = Math.min(dp[t], k + j + 2 + dp[t - (1 << k) + (1 << j)]);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
//        int[] dp = new int[target + 3];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 4;
//
//        for (int t = 3; t <= target; ++t) {
//            int k = 32 - Integer.numberOfLeadingZeros(t);
//            if (t == (1 << k) - 1) {
//                dp[t] = k;
//                continue;
//            }
//            for (int j = 0; j < k - 1; ++j)
//                dp[t] = Math.min(dp[t], dp[t - (1 << (k - 1)) + (1 << j)] + k - 1 + j + 2);
//            if ((1 << k) - 1 - t < t)
//                dp[t] = Math.min(dp[t], dp[(1 << k) - 1 - t] + k + 1);
//        }
//
//        return dp[target];
        new Exercise_818().racecar(2);

    }
}
