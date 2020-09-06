package leetcode13.algorithm.wk06;

/**
 * 647. 回文子串
 */
public class HW_647 {

    /**
     * 解法一
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            // i为中心
            res += countSub(chars, i, i);
            res += countSub(chars, i, i + 1);
        }
        return res;
    }

    private int countSub(char[] chaArr, int l, int r) {
        int res = 0;
        while (l >= 0 && r < chaArr.length) {
            if (chaArr[l] == chaArr[r]) {
                l--;
                r++;
                res++;
                continue;
            }
            break;
        }
        return res;
    }

    /**
     * 解法二：动态规划
     *
     * @param s
     * @return
     */
    public int countSubstrings_2(String s) {
        char[] chars = s.toCharArray();
        boolean[] dp = new boolean[chars.length];
        int res = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (chars[i] == chars[j] && (j - i <= 1 || dp[i + 1])) {
                    dp[i] = true;
                    res++;
                } else {
                    dp[i] = false;
                }
            }
        }
        return res;
    }
}
