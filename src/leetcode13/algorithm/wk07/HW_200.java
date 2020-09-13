package leetcode13.algorithm.wk07;

/**
 * 200.岛屿数量
 */
public class HW_200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    landToWater(grid, i, j);
                }
            }
        }
        return count;
    }

    private void landToWater(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        landToWater(grid, i - 1, j);
        landToWater(grid, i + 1, j);
        landToWater(grid, i, j - 1);
        landToWater(grid, i, j + 1);

    }
}
