package leetcode13.algorithm.wk05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class Exercise_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;  // 过滤重复值
            int b = a + 1, c = nums.length - 1;
            while (b < c) {
                if (nums[a] + nums[b] + nums[c] > 0) {
                    c--;
                } else if (nums[a] + nums[b] + nums[c] < 0) {
                    b++;
                } else {
                    result.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    // 过滤重复
                    while (b < c && nums[b] == nums[++b]) ; // 过滤重复值
                    while (b < c && nums[c] == nums[--c]) ; // 过滤重复值
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Exercise_15().threeSum(new int[]{0, 0, 0, 0});
    }
}
