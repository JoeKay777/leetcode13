package leetcode13.algorithm.wk05;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 673. 最长递增子序列的个数
 */
public class Exercise_673 {

    public int findNumberOfLIS(int[] nums) {


        int[] dp = new int[nums.length];
        int[] counts = new int[nums.length];
//        Arrays.fill(dp, 1); 可以不填充1
        Arrays.fill(counts, 1);
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLen) {
                res += counts[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Exercise_673().findNumberOfLIS(new int[]{1, 1, 1, 1});
    }


}
