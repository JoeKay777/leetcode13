package leetcode13.algorithm.wk04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class SubsetsWithDup {
    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private List<List<Integer>> result = new ArrayList<>();
w
    private void backtrack(int[] nums, int start, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i -1]) { // 重复过滤掉
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.remove(list.size() -1);
        }
    }

    public static void main(String[] args) {
        System.out.println("sdfdasfds");
        new SubsetsWithDup().subsetsWithDup(new int[] {1,2,2});
    }


}