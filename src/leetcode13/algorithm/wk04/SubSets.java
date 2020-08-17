package leetcode13.algorithm.wk04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 78. 子集
 */
public class SubSets {

    /**
     * 分治法
     * f(n) = 2* f(n)
     *
     * private static int divide_conquer(Problem problem, ) {
     *
     *   if (problem == NULL) {
     *     int res = process_last_result();
     *     return res;
     *   }
     *   subProblems = split_problem(problem)
     *
     *   res0 = divide_conquer(subProblems[0])
     *   res1 = divide_conquer(subProblems[1])
     *
     *   result = process_result(res0, res1);
     *
     *   return result;
     * }
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        if(nums.length == 0) {
            return Collections.emptyList();
        }
        divide(nums.length - 1);
        return result;
    }

    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums = null;
    private void divide(int idx) {
        if(idx == 0) {
            List<Integer> list1 = new ArrayList<>(0);
            List<Integer> list2 = new ArrayList<>(1);
            list2.add(nums[idx]);
            result.add(list1);
            result.add(list2);
            return;
        }
        divide(idx - 1);
        List<List<Integer>> curList = new ArrayList<>(result.size());
        for (List<Integer> list: result) {
            List<Integer> list_copy = new ArrayList<>(list);
            list_copy.add(nums[idx]);
            curList.add(list_copy);
        }
        result.addAll(curList);
    }
}
