package leetcode13.algorithm.wk06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class Exercise_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);  // 必须排序
        for (int a = 0; a < nums.length - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // 优化
            int min = nums[a] + nums[a + 1] + nums[a + 2];
            if (0 < min) {
                break;
            }
            int max = nums[a] + nums[nums.length - 2] + nums[nums.length - 1];
            if (0 > max) {
                continue;
            }

            int b = a + 1, c = nums.length - 1;
            while (b < c) {
                int res = nums[a] + nums[b] + nums[c];
                if (res < 0) {
                    b++;
                } else if (res > 0) {
                    c--;
                } else {
                    list.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    while (b < c && nums[b] == nums[++b]) ;
                    while (b < c && nums[c] == nums[--c]) ;
                }
            }
        }
        return list;
    }
}
