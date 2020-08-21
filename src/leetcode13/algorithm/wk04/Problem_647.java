package leetcode13.algorithm.wk04;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 647. 回文子串
 */
public class Problem_647 {

    private String s = null;
    private int count = 0;

    public int countSubstrings(String s) {
        this.s = s;
        for (int i = 0; i < s.length(); i++) {
            countSub(i, i);
            countSub(i, i + 1);
        }
        return count;
    }

    /**
     * 计算以start，end为中心的回文数量
     *
     * @param start
     * @param end
     */
    private void countSub(int start, int end) {
        for (; start >= 0 && end < s.length(); start--, end++) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            count++;
        }
    }


    public static void main(String[] args) {
        int aaa = new Problem_647().countSubstrings("fdsklf");
        System.out.println(aaa);
    }

}
