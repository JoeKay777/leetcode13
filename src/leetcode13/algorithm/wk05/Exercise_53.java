package leetcode13.algorithm.wk05;

/**
 * 53. 最大子序和
 */
public class Exercise_53 {
    /**
     * 动态规划： dp[i]表示以i为末尾的子数组的最大和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
