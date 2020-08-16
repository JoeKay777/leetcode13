package leetcode13.algorithm.wk03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permute {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums = null;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        backtrack(new ArrayList<Integer>(nums.length));
        return result;
    }

    private void backtrack(List<Integer> list) {
        // 满足条件,保存结果并结束
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }
        int size = list.size();
        for (int num : nums) {
            // 做选择
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            // 回溯
            backtrack(list);
            // 撤销选择
            list.remove(size);

        }
    }
}
