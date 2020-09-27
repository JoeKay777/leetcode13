package leetcode13.algorithm.wk09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 */
public class HW_151 {

    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

}
