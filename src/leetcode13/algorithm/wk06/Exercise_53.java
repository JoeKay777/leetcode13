package leetcode13.algorithm.wk06;

/**
 * 53. 最大子序和
 */
public class Exercise_53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int prev = nums[0];
        int res = prev;
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(nums[i], prev + nums[i]);
            res = Math.max(prev, res);
        }
        return res;
    }
}
