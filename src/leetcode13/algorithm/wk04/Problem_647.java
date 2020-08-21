package leetcode13.algorithm.wk04;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 647. 回文子串
 */
public class Problem_647 {
    /**
     * 层次遍历
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        this.chars = s.toCharArray();
        return subString(0);
    }

    private char[] chars = null;

    private int subString(int start) {
        if (start == chars.length) {
            return 0;
        }
        int count = subString(start + 1);
        for (int i = start; i < chars.length; i++) {
            boolean ok = true;
            int end = i;    // start为子串上限，i为子串上限
            // 判断是否回文
            for (int j = start; j < end; j++, end--) {
                if (chars[j] != chars[end]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int aaa = new Problem_647().countSubstrings("abc");
        System.out.println(aaa);
    }

}
