package leetcode13.algorithm.wk08;

import java.util.Arrays;

/**
 * 493. 翻转对
 */
public class Exercise_493 {

    /**
     * 归并排序，分而治之
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);

    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        // 统计翻转对
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > nums[j] * 2L) {
                j++;
            }
            count += (j - mid - 1);
        }
        merge(nums, left, mid, right);
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // 归并排序
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 1};
        new Exercise_493().reversePairs(arr);
        System.out.println(Arrays.toString(arr));

    }

}
