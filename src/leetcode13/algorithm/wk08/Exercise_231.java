package leetcode13.algorithm.wk08;

/**
 * 231. 2的幂
 */
public class Exercise_231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long l = (long) n;  // int类型会溢出
        return (l & (l - 1)) == 0;
    }
}
