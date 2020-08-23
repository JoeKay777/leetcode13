package leetcode13.algorithm.wk04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 529. 扫雷游戏
 */
public class Problem_529 {

    // 定义八个方向
    int[] x_dir = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] y_dir = {1, 1, 0, -1, -1, -1, 0, 1};

    /**
     * 解法一、深度优先遍历
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {    // 碰到地雷，游戏结束
            board[x][y] = 'X';
            return board;
        }

        dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        // 统计周边地雷数量
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x_next = x + x_dir[i];
            int y_next = y + y_dir[i];
            if (x_next >= 0 && x_next < board.length && y_next >= 0 && y_next < board[0].length && board[x_next][y_next] == 'M') {
                count++;
            }
        }
        // 停止条件
        if (count > 0) {
            board[x][y] = (char) (count + '0');
            return;
        }

        // 空地，深度遍历相邻区域
        board[x][y] = 'B';
        for (int i = 0; i < 8; i++) {
            int x_next = x + x_dir[i];
            int y_next = y + y_dir[i];
            if (x_next >= 0 && x_next < board.length && y_next >= 0 && y_next < board[0].length && board[x_next][y_next] == 'E') {
                dfs(board, x_next, y_next);
            }
        }
    }

    /**
     * 解法二、广度优先遍历
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard_2(char[][] board, int[] click) {

        if (board[click[0]][click[1]] == 'M') {    // 碰到地雷，游戏结束
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[click[0]][click[1]] = true;
        queue.offer(click);
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            // 统计附近地雷数
            int count = 0;
            for (int i = 0; i < 8; i++) {
                int x_next = cur[0] + x_dir[i];
                int y_next = cur[1] + y_dir[i];
                if (x_next >= 0 && x_next < board.length && y_next >= 0 && y_next < board[0].length && board[x_next][y_next] == 'M') {
                    count++;
                }
            }
            // 周边有雷，相当于无子节点
            if (count > 0) {
                board[cur[0]][cur[1]] = (char) (count + '0');
                continue;
            }

            // 添加未遍历的子节点
            board[cur[0]][cur[1]] = 'B';
            for (int i = 0; i < 8; i++) {
                int x_next = cur[0] + x_dir[i];
                int y_next = cur[1] + y_dir[i];
                if (x_next >= 0 && x_next < board.length && y_next >= 0 && y_next < board[0].length && board[x_next][y_next] == 'E' && !visited[x_next][y_next]) {
                    visited[x_next][y_next] = true;
                    queue.offer(new int[]{x_next, y_next});
                }
            }
        }
        return board;
    }


    public static void main(String[] args) {
        new Problem_529().updateBoard_2(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}},
                new int[]{3, 0});
        System.out.printf("结束");
    }
}
