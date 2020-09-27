package leetcode13.algorithm.wk09;

import java.util.Arrays;

/**
 * 85. 最大矩形
 */
public class Exercise_85 {

    /**
     * height[j] 记录[x,j]列最大高度
     * left[j]  记录[x,j]列左边界下标 （k = j->0 第一个matrix[x][k] == 0的坐标 k + 1）
     * right[j] 记录[x,j]列右边界下标 （k = j->m 第一个matrix[x][k] == 0的坐标k， 包含0便于计算面积）
     * area = height[j] * (right[j] - left[j])
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix[0].length;
        int[] height = new int[m];
        int[] left = new int[m];    // 初始化为0
        int[] right = new int[m];   // 初始化为m
        Arrays.fill(right, m);

        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            int curLeft = 0, curRight = m;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    height[j] = 0;
                    left[j] = 0;    // 直接为0不影响下一行的左边界计算
                    curLeft = j + 1;    // 记录本行左边界
                }
            }
            for (int j = m - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = m;  // 直接为m不影响下一行的右边界计算
                    curRight = j;
                }
            }
            // 计算面积
            for (int j = 0; j < m; j++) {
                maxArea = Math.max(maxArea, height[j] * (right[j] - left[j]));
            }
        }
        return maxArea;
    }

}
