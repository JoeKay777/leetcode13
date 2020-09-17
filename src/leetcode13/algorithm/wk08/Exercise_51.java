package leetcode13.algorithm.wk08;

import leetcode13.algorithm.wk07.Exercise_212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 */
public class Exercise_51 {

    private int n;

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        int columns = 0;
        int leftDiagonal = 0;
        int rightDiagonal = 0;
        int[] queens = new int[n];
//        Arrays.fill(queens, -1);  // 每次循环都会赋值，可以不设置默认值
        dfs(0, queens, columns, leftDiagonal, rightDiagonal);
        return result;
    }

    private void dfs(int row, int[] queens, int columns, int leftDiagonal, int rightDiagonal) {
        if (row == n) {
            solveQueens(queens);
            return;
        }

        // 获取可用的皇后位置
        int validPosition = ((1 << n) - 1) & (~(columns | leftDiagonal | rightDiagonal));
        while (validPosition != 0) {

            int position = validPosition & (-validPosition);  // 获取最右边的二进制1
            validPosition = validPosition & (validPosition - 1); // 移除最右边的1
            int column = Integer.bitCount(position - 1);    // 获取皇后的纵坐标
            queens[row] = column;   // 必会覆盖当前值，下边可以不撤销
            dfs(row + 1, queens, position | columns, (leftDiagonal | position) << 1, (rightDiagonal | position) >> 1);
//            queens[row] = -1;     //每次循环都会覆盖当前的值,故可以不撤销
        }
    }

    private void solveQueens(int[] queens) {
        List<String> list = new ArrayList<>(n);
        for (int i : queens) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            list.add(new String(chars));
        }
        result.add(list);
    }

    public static void main(String[] args) {

        int i = -100;
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        i = i & 0x3f;
        System.out.println(i);
        System.out.println(0x55555555);
        System.out.println(0x33333333);
        System.out.println(0x0f0f0f0f);
        System.out.println(0x3f);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(0x11);

        System.out.println("=============");
        System.out.println(countBits(-100));
    }

    public static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }


}
