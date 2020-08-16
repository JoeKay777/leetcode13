package leetcode13.algorithm.wk03;

import java.util.*;

/**
 * 47. 全排列 II
 */
public class PermuteUnique {

    private List<Integer> numsList = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums) {
            numsList.add(num);
        }
        backtrack(new ArrayList<Integer>(nums.length), 0);
        return result;
    }

    private void backtrack(List<Integer> list, int first) {
        // 满足条件，保存并结束
        if (list.size() == numsList.size()) {
            result.add(new ArrayList<>(list));
        }
        Set<Integer> usered = new HashSet<>(); // 用于过滤值重复的元素
        for (int i = first; i < numsList.size(); i++) {
            // 做选择
            if (usered.contains(numsList.get(i))) {  // 数值相同舍去
                continue;
            }
            usered.add(numsList.get(i));
            Collections.swap(numsList, first, i);
            list.add(numsList.get(first));
            // 回溯
            backtrack(list, first + 1);
            // 撤销选择
            Collections.swap(numsList, i , first);
            list.remove(list.size() - 1);
        }
    }
}
