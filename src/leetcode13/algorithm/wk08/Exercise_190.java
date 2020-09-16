package leetcode13.algorithm.wk08;

/**
 * 190. 颠倒二进制位
 */
public class Exercise_190 {
    public int reverseBits(int n) {
        int ret = 0, pos = 32;
        while (pos-- > 0) {
            ret <<= 1;
            ret += (n & 1);
            n >>= 1;
        }
        return ret;
    }
}
