package leetcode13.algorithm.wk05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 */
public class Exercise_491 {

    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums;

    /**
     * 该问题 90. 子集 II
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        backtrack(0, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(int start, List<Integer> list) {
        // 条件
        if (list.size() > 1) {
            result.add(new ArrayList<>(list));
        }

        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 过滤小的元素
            if (!list.isEmpty() && nums[i] < list.get(list.size() - 1)) {
                continue;
            }
            // 同层重复元素过滤
            if (used.contains(nums[i])) {
                continue;
            }
            // 选择
            list.add(nums[i]);
            used.add(nums[i]);

            // 回溯
            backtrack(i + 1, list);

            // 撤销选择
            list.remove(list.size() - 1);
        }
    }
}
