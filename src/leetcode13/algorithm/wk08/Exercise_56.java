package leetcode13.algorithm.wk08;

import java.util.Arrays;

/**
 * 56.合并区间
 */
public class Exercise_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int prevIndex = i - 1;
            while (prevIndex >= 0 && intervals[prevIndex][0] > current[0]) {
                intervals[prevIndex + 1] = intervals[prevIndex];
                prevIndex++;
            }
            intervals[prevIndex + 1] = current;
        }
        int[][] res = new int[intervals.length][2];
        int k = 1;
        res[0] = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= res[k][1]) {
                res[k][1] = Math.max(intervals[i][1], res[k][1]);
            } else {
                res[++k] = intervals[i];
            }
        }
        return Arrays.copyOf(res, k + 1);
    }
}
