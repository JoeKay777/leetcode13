package leetcode13.algorithm.wk04;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class Problem_153 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) { // right 不能等于left，当仅剩两个值时，left值 小于 right值时，此时mid = left会死循环
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[right]) {   // 右侧旋转，最小值在右侧且mid不可能为最小值
                left = mid + 1;
            } else {    // 左侧旋转 ，最小值在左侧或者mid
                right = mid;
            }

        }
        return nums[left];
    }
}
