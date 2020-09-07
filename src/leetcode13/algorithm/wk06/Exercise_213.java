package leetcode13.algorithm.wk06;

/**
 * 213.打家劫舍Ⅱ
 */
public class Exercise_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));
    }

    private int getMax(int[] nums, int start, int end) {
        int prev = 0, cur = 0;
        for (int i = start; i <= end; i++) {
            int temp = cur;
            cur = Math.max(prev + nums[i], cur);
            prev = temp;
        }
        return cur;
    }
}
