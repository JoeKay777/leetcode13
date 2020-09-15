package leetcode13.algorithm.wk07;

/**
 * 37. 解数独
 */
public class HW_37 {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        // 记录占用的横坐标
        boolean[][] rows = new boolean[9][10];
        // 记录占用的纵坐标
        boolean[][] columns = new boolean[9][10];
        // 记录占用的块
        boolean[][] boxs = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    rows[i][c - '0'] = true;
                    columns[j][c - '0'] = true;
                    boxs[i / 3 * 3 + j / 3][c - '0'] = true;
                }
            }
        }
        backtrack(board, 0, 0, rows, columns, boxs);
    }

    private boolean success = false;

    private void backtrack(char[][] board, int i, int j, boolean[][] rows, boolean[][] columns, boolean[][] boxs) {
        if (i == 9) {
            success = true;
            return;
        }
        if (board[i][j] != '.') {
            // 回溯
            backtrack(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1, rows, columns, boxs);
            return;
        }

        for (char num = '1'; num <= '9'; num++) {
            // 剪枝
            if (rows[i][num - '0']) continue;
            if (columns[j][num - '0']) continue;
            if (boxs[i / 3 * 3 + j / 3][num - '0']) continue;
            // 选择
            board[i][j] = num;
            rows[i][num - '0'] = true;
            columns[j][num - '0'] = true;
            boxs[i / 3 * 3 + j / 3][num - '0'] = true;
            // 回溯
            backtrack(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1, rows, columns, boxs);
            if (success) {
                return;
            }
            // 撤销
            board[i][j] = '.';
            rows[i][num - '0'] = false;
            columns[j][num - '0'] = false;
            boxs[i / 3 * 3 + j / 3][num - '0'] = false;
        }
    }

    public static void main(String[] args) {
        new HW_37().solveSudoku(new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
    }
}
