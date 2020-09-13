package leetcode13.algorithm.wk07;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生产
 */
public class HW_22 {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", n, n);
        return res;
    }

    private void backtrack(String s, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }
        if(l > 0) {
            backtrack(s + "(", l - 1, r);
        }
        if (r > l) {    // 右括号少于左括号时
            backtrack(s + ")", l, r - 1);
        }
    }
}
