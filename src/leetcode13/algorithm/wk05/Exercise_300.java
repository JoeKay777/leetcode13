package leetcode13.algorithm.wk05;

import java.util.Arrays;
import java.util.jar.JarEntry;

public class Exercise_300 {

    /**
     * 动态规划解法：
     * dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        new Exercise_300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4});
    }
}
