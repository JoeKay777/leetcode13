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
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(0, columns, sub, add, queens);
        return res;
    }

    private void backtrack(int i, boolean[] columns, Set<Integer> sub, Set<Integer> add, int[] queens) {
        if (i == n) {  // 终止
            generateAns(queens);
            return;
        }

        // 选择
        for (int j = 0; j < n; j++) {
            if (columns[j]) continue;   // 纵坐标冲突
            if (sub.contains(i - j)) continue;  // 右斜冲突
            if (add.contains(i + j)) continue;  // 左斜冲突
            columns[j] = true;
            sub.add(i - j);
            add.add(i + j);
            queens[i] = j;
            // 回溯
            backtrack(i + 1, columns, sub, add, queens);
            // 撤销
            columns[j] = false;
            sub.remove(i - j);
            add.remove(i + j);
            queens[i] = -1;
        }


    }

    private void generateAns(int[] queens) {
        List<String> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[queens[i]] = 'Q';
            ans.add(new String(chars));
        }
        res.add(ans);
    }


}
