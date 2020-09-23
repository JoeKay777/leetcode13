package leetcode13.algorithm.wk09;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 */
public class Exercise_300 {

    /**
     * 状态定义dp[i]:以下标i结尾的最长上升子序列
     * 状态转移方程：dp[i] = Max(dp[j])[0≤j<i,nums[j]<nums[i]]  + 1
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] > dp[i] - 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }
        return maxLen;
    }

    /**
     * 时间优化：贪心+二分查找
     * 状态定义dp[i]：升序长度为i+1的最小数
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int index = 0;  // 标记dp数组元素长度，index+1=maxLen
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[index]) {
                dp[++index] = nums[i];
                continue;
            }
            // 二分查找最小的大于或等于nums[i]的位置
            int l = 0, r = index;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (dp[mid] >= nums[i]) {
                    if (mid == 0 || dp[mid - 1] < nums[i]) {    // dp[mid]前一个值比nums[i]小，且dp[mid]大于等于nums[i],则dp[mid]就是最小的大于等于nums[i]的值
                        dp[mid] = nums[i];
                        break;
                    }
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            //

        }
        return index + 1;
    }
}
