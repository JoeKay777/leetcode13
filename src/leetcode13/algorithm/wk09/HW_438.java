package leetcode13.algorithm.wk09;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class HW_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) return res;
        int[] window = new int[26];       // 保存滑动窗口中的字符
        int[] match = new int[26];        // 字符串p包含的字符

        for (int i = 0; i < p.length(); i++) {
            match[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if (matchChar(window, match)) {
            res.add(0);
        }
        char[] chars = s.toCharArray();
        for (int head = 1, tail = p.length(); tail < chars.length; tail++, head++) {
            // 获取当前窗口字符
            window[chars[head - 1] - 'a']--;
            window[chars[tail] - 'a']++;
            if (matchChar(window, match)) {
                res.add(head);
            }
        }
        return res;
    }

    private boolean matchChar(int[] window, int[] match) {
        for (int i = 0; i < 26; i++) {
            if (window[i] != match[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new HW_438().findAnagrams(
                "cbaebabacd",
                "abc");
    }
}
