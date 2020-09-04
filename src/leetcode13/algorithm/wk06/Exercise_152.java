package leetcode13.algorithm.wk06;

/**
 * 152. 乘积最大子数组
 */
public class Exercise_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = max;
        int temp = min;
        for (int i = 1; i < nums.length; i++) {
            temp = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            max = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));
            min = temp;
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        new Exercise_152().maxProduct(new int[]{2,3,-2,4});
    }
}
