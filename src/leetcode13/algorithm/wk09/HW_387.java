package leetcode13.algorithm.wk09;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class HW_387 {
    public int firstUniqChar(String s) {
        // 只包含小写字母
        char[] chars = new char[26];
        for (char ch : s.toCharArray()) {
            chars[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
