package leetcode13.algorithm.wk04;

/**
 * 200. 岛屿数量
 */
public class Problem_200 {

    /**
     * 广度优先遍历，相邻的岛屿为同层级
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int landNum = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == '1') {
                    landNum++;
                    // 将统计的陆地转为水，避免重复计算
                    landToWater(x, y, grid);
                }
            }
        }
        return landNum;
    }

    private void landToWater(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        landToWater(x - 1, y, grid);
        landToWater(x + 1, y, grid);
        landToWater(x, y - 1, grid);
        landToWater(x, y + 1, grid);
    }

}
