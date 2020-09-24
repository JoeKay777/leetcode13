package leetcode13.algorithm.wk09;

import java.util.Stack;

/**
 * 32. 最长有效括号
 */
public class Exercise_32 {

    /**
     * 状态定义dp[i]:以i结尾的最长有效括号长度
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        int maxLen = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                dp[i + 1] = 0;
            } else if (chars[i - 1] == '(' && chars[i] == ')') {
                dp[i + 1] = dp[i - 1] + 2;
            } else {
                int left = i - dp[i] - 1;
                if (left >= 0 && chars[left] == '(') {
                    dp[i + 1] = dp[i] + 2 + dp[left];
                } else {
                    dp[i + 1] = 0;
                }
            }
            if (dp[i + 1] > maxLen) {
                maxLen = dp[i + 1];
            }
        }
        return maxLen;
    }

    /**
     * 借助栈， 栈中保存括号的下标
     * 遇到'(' 则入栈；
     * 遇到‘）’ 且栈顶是‘(’则出栈，以该‘)’结尾的最长有效括号为i-出栈后的栈顶值【初始值压入-1，方便计算空栈情况】
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_2(String s) {
        if (s == null || s.length() < 2) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();    // 栈内最多只保存一个‘)’且一定是在栈底
                if (stack.isEmpty()) {  // 为空 表示没有匹配到‘(’
                    stack.push(i);
                } else  {   // 不为空表示匹配到，计算有效括号长度
                    maxLen = Math.max(i - stack.peek(), maxLen);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new Exercise_32().longestValidParentheses("()(())");
    }
}
