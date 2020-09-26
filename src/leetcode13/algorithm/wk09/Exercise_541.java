package leetcode13.algorithm.wk09;

public class Exercise_541 {

    public String reverseStr(String s, int k) {
        if (k == 0) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int l = i;
            int r = l + k > chars.length ? chars.length - 1 : l + k - 1;
            while (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        new Exercise_541().reverseStr("abcd", 4);
    }
}
