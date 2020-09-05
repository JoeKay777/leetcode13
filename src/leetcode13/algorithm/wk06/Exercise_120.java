package leetcode13.algorithm.wk06;

import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class Exercise_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[triangle.get(size - 1).size() + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
