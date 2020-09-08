package leetcode13.algorithm.wk06;

import java.util.Arrays;

public class HW_410 {

    /**
     * 方法一：二分查找
     * 思考：nums包含负数怎么办(加个一个正数，全部转成正数) ？？？
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        // 确定二分查找的最大、最小值
        int left = nums[0];
        int right = nums[0];
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
            left = Math.max(left, nums[i]);
        }
        // 二分查找模板
        while (left < right) {
            int mid = left + (right - left) / 2;    // 中间值作为猜想的最大分段和
            int cnt = 1;    // 分段计数
            int sub = 0;    // 每段元素和
            for (int num : nums) {
                sub += num;
                if (sub > mid) { // 大于猜想的分段和，则分段
                    cnt++;
                    if (cnt > m) {
                        break;
                    }
                    sub = num;
                }
            }
            if (cnt <= m) { // 分段小于m，mid值大了
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 解法二：动态规划
     * dp[i][j]: 0-j元素 分隔i段各自和的最大值最小
     * <p>
     * dp[i][j] = min(dp[i][j], max(dp[i-1][k], sum[j] - sum[k])) ;  i-1 <= k < j
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray_2(int[] nums, int m) {
        int[] sum = new int[nums.length + 1];   // 前i和
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[][] dp = new int[m + 1][nums.length + 1];
        // 填充默认值，为最大值
        for (int[] col : dp) {
            Arrays.fill(col, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;   // 保证分1段时，公式满足
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= nums.length; j++) {
                for (int k = i - 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], sum[j] - sum[k]));
                }
            }
        }
        return dp[m][nums.length];
    }
}
