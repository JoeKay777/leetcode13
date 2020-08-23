package leetcode13.algorithm.wk04;

/**
 * 学习总结：
 * 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方,最小值即为无序的地方
 * // Java
 * public int binarySearch(int[] array, int target) {
 * int left = 0, right = array.length - 1, mid;
 * while (left <= right) {
 * mid = (right - left) / 2 + left;
 * <p>
 * if (array[mid] == target) {
 * return mid;
 * } else if (array[mid] > target) {
 * right = mid - 1;
 * } else {
 * left = mid + 1;
 * }
 * }
 * <p>
 * return -1;
 * }
 */
public class StudySummary {
    public int binarySearch(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {   // 最小值在左边
                right = mid;
            } else if (nums[mid] > nums[left]) { // 最小值在右边
                left = mid;
            } else {
                // 剩余两个值时，最小值为其中小值
                left = nums[left] > nums[right] ? right : left;
                break;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        int index = new StudySummary().binarySearch(new int[]{ 0, 1, 2, 3});
        System.out.println(index);
    }
}
