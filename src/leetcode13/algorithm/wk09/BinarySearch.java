package leetcode13.algorithm.wk09;

/**
 * 二分查找模板大全
 */
public class BinarySearch {

    /**
     * 查找给定值，返回下标，不存在返回-1
     *
     * @param nums
     * @return
     */
    public int bSearch(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == value) return mid;
            if (nums[mid] < value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变体一：查找第一个值等于给定值的元素
     *
     * @param nums
     * @return
     */
    public int bSearch_1(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < value) {
                l = mid + 1;
            } else if (nums[mid] > value) {
                r = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != value) return mid;
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变体一优化版
     * 查找第一个值等于给定值的元素
     *
     * @param nums
     * @return
     */
    public int bSearch_2(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= value) {
                r = mid - 1;
            } else {
                l = mid + 1;

            }
        }
        return l < nums.length && nums[l] == value ? l : -1;
    }

    /**
     * 变体二：查找最后一个值等于给定值的元素
     *
     * @param nums
     * @return
     */
    public int bSearch_3(int[] nums, int value) {
        int l = 0, n = nums.length, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < value) {
                l = mid + 1;
            } else if (nums[mid] > value) {
                r = mid - 1;
            } else {
                if (mid == n - 1 || nums[mid + 1] != value) return mid;
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体二优化版
     * 查找最后一个值等于给定值的元素
     *
     * @param nums
     * @return
     */
    public int bSearch_4(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r >= 0 && nums[r] == value ? r : -1;
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     *
     * @param nums
     * @return
     */
    public int bSearch_5(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= value) {
                if (mid == 0 || nums[mid - 1] < value) return mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -l;
    }

    /**
     * 变体四：查找最后一个小于等于给定值的元素
     *
     * @param nums
     * @return
     */
    public int bSearch_6(int[] nums, int value) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= value) {
                if (mid == nums.length - 1 || nums[mid + 1] > value) return mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -l;
    }


}
