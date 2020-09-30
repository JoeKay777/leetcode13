package leetcode13.algorithm.wk09;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 */
public class HW_32 {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(-1);    // 便于计算
        char[] chars = s.toCharArray();
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.offerLast(i);
            } else {
                stack.pollLast();
                if (stack.isEmpty()) {
                    stack.offerLast(i);
                } else {
                    int len = i - stack.peekLast();
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }

}
