package leetcode13.algorithm.wk04;

/**
 * 33.搜索旋转排序数组
 */
public class Problem_33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左边有序，且target在左边
            if (nums[mid] > nums[left] && target >= nums[left] && (target < nums[mid] || target < nums[mid])) {
                right = mid - 1;
            } else if (nums[mid] < nums[left] && (target >= nums[left] || target < nums[mid])) { //  左边无序，且target在左边
                right = mid - 1;
            } else {    // 落在右边
                left = mid + 1;
            }


        }
        return -1;
    }
}
