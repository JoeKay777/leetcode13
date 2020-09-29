package leetcode13.algorithm.wk09;

/**
 * 5. 最长回文子串
 */
public class HW_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int center = 0, length = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            // 以i为中心的回文子串
            // 奇数情况
            int len = getLen(i, i, chars);
            if (len > length) {
                length = len;
                center = i;
            }
            // 偶数情况
            len = getLen(i, i + 1, chars);
            if (len > length) {
                length = len;
                center = i;
            }
        }
        int begin = center - ((length - 1) >> 1);
        return s.substring(center - ((length - 1) >> 1), begin + length);
    }

    private int getLen(int left, int right, char[] chars) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        new HW_5().longestPalindrome("babad");
    }
}
