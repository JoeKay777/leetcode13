package leetcode13.algorithm.wk09;

/**
 * 917. 仅仅反转字母
 */
public class HW_917 {

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(chars[l])) {
                l++;
            }
            while (l < r && !Character.isLetter(chars[r])) {
                r--;
            }
            if (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }

}
