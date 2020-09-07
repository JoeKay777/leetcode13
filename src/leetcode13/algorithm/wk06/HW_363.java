package leetcode13.algorithm.wk06;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 */
public class HW_363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        for (int l = 0; l < matrix[0].length; l++) {
            int[] column = new int[matrix.length];
            for (int r = l; r < matrix[0].length; r++) {
                for (int i = 0; i < matrix.length; i++) {
                    column[i] += matrix[i][r];
                }
                res = Math.max(res, getMaxSum(column, k));
            }
        }
        return res;
    }

    /**
     * 获取一列小于k的最大和
     *
     * @param column
     * @param k
     * @return
     */
    private int getMaxSum(int[] column, int k) {
        // 优化求最大值
        int prev = column[0];
        int max = prev;
        for (int i = 1; i < column.length; i++) {
            prev = Math.max(column[i], prev + column[i]);
            max = Math.max(max, prev);
        }
        if (max <= k) return max;
        max = Integer.MIN_VALUE;
        for (int s = 0; s < column.length; s++) {
            int sum = 0;
            for (int t = s; t < column.length; t++) {
                sum += column[t];
                if (sum <= k && sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
