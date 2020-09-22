package leetcode13.algorithm.wk09;

/**
 * 198. 打家劫舍
 */
public class Exercise_198 {
    /**
     * 状态定义：dp[i] 偷1-i范围内的房子的最高金额
     * 状态转移方程：dp[i]  = max(dp[i -1] , dp[i -2] + nums[i])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
