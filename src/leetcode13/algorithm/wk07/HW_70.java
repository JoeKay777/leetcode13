package leetcode13.algorithm.wk07;

import com.sun.org.apache.xpath.internal.objects.XNull;

/**
 * 70. 爬楼梯
 */
public class HW_70 {
    public int climbStairs(int n) {
        climb = new int[n + 1];
        return dfs(n);
    }

    private int[] climb;

    private int dfs(int n) {
        if (n < 3) {
            return n;
        }
        if (climb[n] > 0) {
            return climb[n];
        }
        int num = dfs(n - 1) + dfs(n - 2);
        climb[n] = num;
        return num;
    }
}
