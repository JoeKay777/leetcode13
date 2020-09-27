package leetcode13.algorithm.wk09;

import java.util.Arrays;
import java.util.List;

/**
 * 557. 反转字符串中的单词 III
 */
public class HW_557 {

    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.split("\\s"));
        for (int i = 0; i < list.size(); i++) {
            list.set(i, reverse(list.get(i).toCharArray()));
        }
        return String.join(" ", list);
    }

    private String reverse(char[] chars) {
        int l = 0, r = chars.length - 1;
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }
}
