package leetcode13.algorithm.wk08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    /**
     * 排序 + 双指针
     * @param intervals
     * @return
     */
    public int[][] merge_2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length;) {
            int t = intervals[i][1];
            int next = i + 1;
            while (next < intervals.length && intervals[next][0] <= t) {
                t = Math.max(t, intervals[next][1]);
                next++;
            }
            res.add(new int[]{intervals[i][0], t});
            i = next;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        new Exercise_56().merge_2(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}
