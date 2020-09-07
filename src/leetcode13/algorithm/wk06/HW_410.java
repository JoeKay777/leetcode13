package leetcode13.algorithm.wk06;

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
                    if(cnt > m) {
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
}
