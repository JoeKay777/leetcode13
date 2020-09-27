package leetcode13.algorithm.wk09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 */
public class Exercise_84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);    // 首尾增加哨兵
        stack.offerLast(0);
        int maxArea = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[i] < newHeights[stack.peekLast()]) { // 出栈
                Integer height = newHeights[stack.pollLast()];
                maxArea = Math.max(maxArea, (i - stack.peekLast() - 1) * height);
            }
            stack.offerLast(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        new Exercise_84().largestRectangleArea(new int[]{4, 2, 0, 3, 2, 4, 3, 4});
    }
}
