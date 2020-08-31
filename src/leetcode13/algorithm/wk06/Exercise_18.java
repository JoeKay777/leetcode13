package leetcode13.algorithm.wk06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 */
public class Exercise_18 {

    /**
     * 排序后双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // 小于最小值，直接结束
            int min = nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3];
            if (target < min) {
                break;
            }

            // 大于最大值，选择下一个更大的a
            int max = nums[a] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
            if (target > max) {
                continue;
            }
            int sum = nums[a];
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                // 小于最小值，直接结束
                min = nums[a] + nums[b] + nums[b + 1] + nums[b + 2];
                if (target < min) {
                    break;
                }

                // 大于最大值，选择下一个更大的b
                max = nums[a] + nums[b] + nums[nums.length - 2] + nums[nums.length - 1];
                if (target > max) {
                    continue;
                }

                // 双指针
                int c = b + 1, d = nums.length - 1;
                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
                        c++;
                    } else {
                        list.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        // 过滤重复值
                        while (c < d && nums[c] == nums[++c]) ;
                        while (c < d && nums[d] == nums[--d]) ;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Exercise_18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}
