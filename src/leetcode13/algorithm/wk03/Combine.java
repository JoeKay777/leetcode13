package leetcode13.algorithm.wk03;

import java.util.*;

/**
 * 77. 组合
 * 回溯算法模板：
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 *
 */
public class Combine {

    private List<List<Integer>> result = new LinkedList<>();
    private int n = 0;
    private int k = 0;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(new LinkedList<>(), 1);
        return result;
    }

    private void backtrack(LinkedList<Integer> list, int first) {
        //满足条件，保存结果
        if(list.size() == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        for(int i = first; i <= n; i++) {
            if(n - first + 1 < k - list.size()) {   // 过滤不满足条件的选择
                continue;
            }
            // 选择
            list.add(i);
            // 回溯
            backtrack(list,i + 1);
            // 撤销选择
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        new Combine().combine(4, 2);
    }
}
