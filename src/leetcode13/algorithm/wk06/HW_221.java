package leetcode13.algorithm.wk06;

/**
 * 221.最大正方形
 */
public class HW_221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i + 1][j + 1] = 0;
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i][j])) + 1;
                }
                res = Math.max(res, dp[i + 1][j + 1]);
            }
        }
        return res * res;
    }

    // 空间优化
    public int maximalSquare_2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length + 1];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            int leftUp = 0; // 左上角
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = dp[j + 1];
                if (matrix[i][j] == '0') {
                    dp[j + 1] = 0;
                } else {
                    dp[j + 1] = Math.min(dp[j], Math.min(dp[j + 1], leftUp)) + 1;
                }
                leftUp = temp;
                res = Math.max(res, dp[j + 1]);
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        new HW_221().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});

    }
}
