package leetcode13.algorithm.wk08;

/**
 * 52. N皇后 II
 */
public class Exercise_52 {

    private int n;
    private int count = 0;

    public int totalNQueens(int n) {
        // 记录有皇后的行号
        int columns = 0;
        // 记录左对接线
        int leftDia = 0;
        // 记录右对角线
        int rightDia = 0;
        this.n = n;
        dfs(0, columns, leftDia, rightDia);
        return count;
    }

    private void dfs(int i, int columns, int leftDia, int rightDia) {
        if (i == n) {
            count++;
            return;
        }
        // 获取可用位置
        int validPositon = ((1 << n )- 1) & (~(columns | leftDia | rightDia));
        while (validPositon != 0) {
            // 取最右侧1
            int position = validPositon & (-validPositon);
            // 移除最右侧1
            validPositon = validPositon & (validPositon - 1);
            dfs(i + 1, columns | position, (leftDia | position) << 1, (rightDia | position) >> 1);
        }
    }

    public static void main(String[] args) {
        new Exercise_52().totalNQueens(4);
    }
}
