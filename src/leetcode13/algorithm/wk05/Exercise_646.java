package leetcode13.algorithm.wk05;

import java.time.temporal.ValueRange;
import java.util.*;

/**
 * 646. 最长数对链
 */
public class Exercise_646 {


    /**
     * 思路：贪心算法，每次选择第二个数最小的加入
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 0;
        int cur = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > cur) {
                res++;
                cur = pair[1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int longestChain = new Exercise_646().findLongestChain(new int[][]{{7, 9}, {4, 5}, {7, 9}, {-7, -1}, {0, 10}, {3, 10}, {3, 6}, {2, 3}});
        System.out.println(longestChain);
    }
}
