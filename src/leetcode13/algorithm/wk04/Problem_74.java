package leetcode13.algorithm.wk04;

/**
 * 74.搜索二维矩阵
 */
public class Problem_74 {

    /**
     * 二维看做一维
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int y = mid % matrix[0].length;
            int x = mid / matrix[0].length;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        new Problem_74().searchMatrix(new int[][]{{1}, {3}}, 3);
    }
}
