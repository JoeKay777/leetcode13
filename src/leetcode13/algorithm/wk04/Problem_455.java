package leetcode13.algorithm.wk04;

import java.util.Arrays;

/**
 * 455.分发饼干
 */
public class Problem_455 {
    /**
     * 貪心算法
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int i = 0, j = 0; i < g.length && j < s.length;) {
            if(s[j] >= g[i]) {
                i++;
                j++;
                count++;
            }else {
                j++;
            }
        }
        return count;
    }
}
