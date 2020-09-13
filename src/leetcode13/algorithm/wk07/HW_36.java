package leetcode13.algorithm.wk07;

/**
 * 36.有效的数独
 */
public class HW_36 {
    public boolean isValidSudoku(char[][] board) {
        // 行中出现的数字
        int[][] rows = new int[9][10];
        // 列中出现的数字
        int[][] columns = new int[9][10];

        // 块中出现的数字
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                if (board[i][num] != 0) return false;
                if (columns[j][num] != 0) return false;
                if (box[i / 3 * 3 + j / 3][num] != 0) return false;
                rows[i][num] = 1;
                columns[j][num] = 1;
                box[i / 3 * 3 + j / 3][num] = 1;
            }
        }
        return true;
    }


}
