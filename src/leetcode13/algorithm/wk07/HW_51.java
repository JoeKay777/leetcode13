package leetcode13.algorithm.wk07;

import java.util.*;

/**
 * 51. N 皇后
 */
public class HW_51 {

    private int n;
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        boolean[] columns = new boolean[n]; // 记录已占用的纵坐标
        Set<Integer> sub = new HashSet<>(); // 记录已占用的右斜
        Set<Integer> add = new HashSet<>(); // 记录已占用的左斜
        backtrack(0, columns, sub, add, new ArrayList<Integer>(n));

        return res;
    }

    private void backtrack(int i, boolean[] columns, Set<Integer> sub, Set<Integer> add, List<Integer> qList) {
        if (i == n) {  // 终止
            List<String> ans = new ArrayList<>(n);
            for (int qIdx : qList) {
                StringBuilder sb = new StringBuilder();
                for (int y = 0; y < n; y++) {
                    if (y == qIdx) {
                        sb.append("Q");
                        continue;
                    }
                    sb.append(".");
                }
                ans.add(sb.toString());
            }
            res.add(ans);
            return;
        }

        // 选择
        for (int j = 0; j < n; j++) {
            if (columns[j]) continue;
            if (sub.contains(i - j)) continue;
            if (add.contains(i + j)) continue;
            columns[j] = true;
            sub.add(i - j);
            add.add(i + j);
            qList.add(i, j);
            // 回溯
            backtrack(i + 1, columns, sub, add, qList);
            // 撤销
            columns[j] = false;
            sub.remove(i - j);
            add.remove(i + j);
            qList.remove(i);
        }


    }


}
