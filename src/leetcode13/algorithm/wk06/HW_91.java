package leetcode13.algorithm.wk06;

/**
 * 91.解码方法
 */
public class HW_91 {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        int prev = 1, cur = 1;
        for (int i = 1; i < chars.length; i++) {
            int temp = cur;
            if(chars[i]  == '0') {
                if(chars[i -1] == '1' || chars[i -1] == '2') {
                    cur = prev;
                } else {
                    return 0;
                }
            } else if(chars[i -1]  == '1' || (chars[i -1] == '2' && chars[i] <= '6')) {
                cur += prev;
            }
            prev = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        new HW_91().numDecodings("226");
    }
}
