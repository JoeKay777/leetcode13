package leetcode13.algorithm.wk06;

import javafx.util.Pair;

import java.util.*;

/**
 * 621. 任务调度器
 */
public class HW_621 {

    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char ch : tasks) {
            taskCount[ch - 'A']++;
        }
        Arrays.sort(taskCount);
        int maxSize = taskCount[25] - 1;
        int emptySize = maxSize * n;
        for (int i = 24; i >= 0 && taskCount[i] > 0 && emptySize > 0; i--) {
            emptySize -= Math.min(maxSize, taskCount[i]);
        }
        return emptySize > 0 ? emptySize + tasks.length : tasks.length;
    }
}
